/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.report.core.build;

import io.nop.api.core.config.AppConfig;
import io.nop.api.core.exceptions.NopException;
import io.nop.api.core.util.ProcessResult;
import io.nop.commons.util.objects.ValueWithLocation;
import io.nop.core.lang.eval.IEvalAction;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.reflect.bean.BeanTool;
import io.nop.excel.imp.ImportModelHelper;
import io.nop.excel.imp.model.ImportModel;
import io.nop.excel.imp.model.ImportSheetModel;
import io.nop.excel.model.ExcelCell;
import io.nop.excel.model.ExcelSheet;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.excel.model.XptCellModel;
import io.nop.excel.model.XptSheetModel;
import io.nop.excel.util.MultiLineConfigParser;
import io.nop.report.core.XptConstants;
import io.nop.report.core.util.ExcelReportHelper;
import io.nop.xlang.api.EvalCode;
import io.nop.xlang.api.XLang;
import io.nop.xlang.api.XLangCompileTool;
import io.nop.xlang.xdef.IXDefAttribute;
import io.nop.xlang.xdef.IXDefNode;
import io.nop.xlang.xdef.IXDefinition;
import io.nop.xlang.xdsl.json.DslXNodeToJsonTransformer;
import io.nop.xlang.xmeta.SchemaLoader;

import java.util.Map;

import static io.nop.report.core.XptErrors.ARG_PROP_NAME;
import static io.nop.report.core.XptErrors.ERR_XPT_UNDEFINED_CELL_MODEL_PROP;

/**
 * 将Excel模型转换为Xpt报表模型
 */
public class ExcelToXptModelTransformer {

    public void transform(ExcelWorkbook workbook) {
        ImportModel importModel = ImportModelHelper.getImportModel(XptConstants.XPT_IMP_MODEL_PATH);
        IXDefinition xptXDef = SchemaLoader.loadXDefinition(XptConstants.XDSL_SCHEMA_WORKBOOK);
        IXDefNode cellModelNode = xptXDef.getXdefDefine(XptConstants.XDEF_NODE_EXCEL_CELL).getChild(XptConstants.PROP_MODEL);

        XptConfigParseHelper.parseWorkbookModel(workbook, importModel);

        ImportSheetModel impSheetModel = importModel.getSheet(XptConstants.SHEET_NAME_XPT_SHEET_MODEL);

        XLangCompileTool compileTool = XLang.newCompileTool();
        DslXNodeToJsonTransformer transformer =
                new DslXNodeToJsonTransformer(false, xptXDef, compileTool);

        for (ExcelSheet sheet : workbook.getSheets()) {
            String sheetName = sheet.getName();
            if (!sheetName.endsWith(XptConstants.POSTFIX_XPT_SHEET_MODEL)) {
                String modelSheetName = sheetName + XptConstants.POSTFIX_XPT_SHEET_MODEL;
                ExcelSheet modelSheet = workbook.getSheet(modelSheetName);
                if (modelSheet != null) {
                    XptSheetModel sheetModel = importModel(impSheetModel, modelSheet, compileTool.getScope(),
                            XptSheetModel.class);
                    sheet.setModel(sheetModel);
                }
                parseCellModel(sheet, cellModelNode, transformer);
            }
        }

        workbook.getSheets().removeIf(sheet -> {
            String sheetName = sheet.getName();
            return sheetName.equals(XptConstants.SHEET_NAME_XPT_WORKBOOK_MODEL)
                    || sheetName.endsWith(XptConstants.POSTFIX_XPT_SHEET_MODEL);
        });

        if (AppConfig.isDebugMode()) {
            dumpModel(workbook);
        }
    }

    private void dumpModel(ExcelWorkbook workbook) {
        ExcelReportHelper.dumpXptModel(workbook);
    }

    private void parseCellModel(ExcelSheet sheet, IXDefNode cellModelNode, DslXNodeToJsonTransformer transformer) {
        sheet.getTable().forEachRealCell((cell, rowIndex, colIndex) -> {
            XptCellModel cellModel = new XptCellModel();
            ExcelCell ec = (ExcelCell) cell;
            ec.setModel(cellModel);

            if (ec.getComment() != null) {
                parseCellModelFromComment(ec, cellModelNode, transformer);
            }

            return ProcessResult.CONTINUE;
        });
    }

    private void parseCellModelFromComment(ExcelCell cell, IXDefNode cellModelNode, DslXNodeToJsonTransformer transformer) {
        XptCellModel cellModel = cell.getModel();

        Map<String, ValueWithLocation> config =
                MultiLineConfigParser.INSTANCE.parseConfig(cell.getLocation(), cell.getComment());

        for (Map.Entry<String, ValueWithLocation> entry : config.entrySet()) {
            String varName = entry.getKey();
            ValueWithLocation vl = entry.getValue();

            IXDefAttribute attr = cellModelNode.getAttribute(varName);
            if (attr != null) {
                Object value = transformer.parseValue(vl, varName, attr.getType());
                value = addSource(vl, value);
                BeanTool.instance().setProperty(cellModel, attr.getPropName(), value);
            } else {
                IXDefNode child = cellModelNode.getChild(varName);
                if (child != null && child.getXdefValue() != null) {
                    Object value = transformer.parseValue(vl, varName, child.getXdefValue());
                    value = addSource(vl, value);
                    BeanTool.instance().setProperty(cellModel, child.getXdefBeanProp(), value);
                } else {
                    throw new NopException(ERR_XPT_UNDEFINED_CELL_MODEL_PROP)
                            .source(vl)
                            .param(ARG_PROP_NAME, entry.getKey());
                }
            }
        }
    }

    private Object addSource(ValueWithLocation vl, Object value) {
        if (value instanceof IEvalAction && vl.getValue() instanceof String) {
            return EvalCode.addSource(vl.getLocation(), (IEvalAction) value, (String) vl.getValue());
        }
        return value;
    }

    private <T> T importModel(ImportSheetModel impModel, ExcelSheet sheet, IEvalScope scope, Class<T> clazz) {
        return ImportModelHelper.parseSheet(impModel, sheet, scope, clazz);
    }
}