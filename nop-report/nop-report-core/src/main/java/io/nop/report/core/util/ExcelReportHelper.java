package io.nop.report.core.util;

import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.resource.IResource;
import io.nop.core.resource.VirtualFileSystem;
import io.nop.core.resource.component.ResourceComponentManager;
import io.nop.core.resource.tpl.IBinaryTemplateOutput;
import io.nop.core.resource.tpl.ITemplateOutput;
import io.nop.excel.imp.model.ImportModel;
import io.nop.excel.model.ExcelWorkbook;
import io.nop.ooxml.xlsx.imp.XlsxObjectLoader;
import io.nop.ooxml.xlsx.parse.ExcelWorkbookParser;
import io.nop.report.core.XptConstants;
import io.nop.report.core.build.XptModelBuilder;
import io.nop.report.core.engine.IReportEngine;
import io.nop.report.core.engine.ReportSheetGenerator;
import io.nop.report.core.engine.renderer.XlsxReportRendererFactory;
import io.nop.report.core.imp.ExcelTemplateToXptModelTransformer;
import io.nop.xlang.api.XLang;
import io.nop.xlang.api.XLangCompileTool;

public class ExcelReportHelper {
    /**
     * 根据imp模型定义解析Excel，返回领域对象
     *
     * @param impModelPath imp模型定义
     * @param resource     excel文件
     */
    public static Object loadXlsxObject(String impModelPath, IResource resource) {
        return new XlsxObjectLoader(impModelPath).parseFromResource(resource);
    }

    public static void saveXlsxObject(String impModelPath, IResource resource, Object obj) {
        ExcelWorkbook xptModel = buildXptModelFromImpModel(impModelPath);

        IEvalScope scope = XLang.newEvalScope();
        scope.setLocalValue(null, XptConstants.VAR_ENTITY, obj);

        IBinaryTemplateOutput output = new XlsxReportRendererFactory()
                .buildRenderer(xptModel, new ReportSheetGenerator(xptModel));
        output.generateToResource(resource, scope);
    }

    public static void saveXlsxObject(IReportEngine reportEngine, String impModelPath, IResource resource,
                                      Object obj, String renderType) {
        IEvalScope scope = XLang.newEvalScope();
        scope.setLocalValue(null, XptConstants.VAR_ENTITY, obj);

        ExcelWorkbook workbook = reportEngine.buildXptModelFromImpModel(impModelPath);
        ITemplateOutput output = reportEngine.getRendererForXptModel(workbook, renderType);
        output.generateToResource(resource, scope);
    }

    public static ExcelWorkbook buildXptModelFromImpModel(String impModelPath) {
        ImportModel impModel = (ImportModel) ResourceComponentManager.instance().loadComponentModel(impModelPath);

        IResource resource = VirtualFileSystem.instance().getResource(impModel.getTemplatePath());
        ExcelWorkbook template = new ExcelWorkbookParser().parseFromResource(resource);

        new ExcelTemplateToXptModelTransformer().transform(template, impModel);

        XLangCompileTool cp = XLang.newCompileTool().allowUnregisteredScopeVar(true);
        new XptModelBuilder(cp).build(template);

        return template;
    }
}