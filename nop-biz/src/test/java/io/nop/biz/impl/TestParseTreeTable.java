package io.nop.biz.impl;

import io.nop.api.core.util.CloneHelper;
import io.nop.core.initialize.CoreInitialization;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.lang.json.JsonTool;
import io.nop.core.resource.IResource;
import io.nop.core.resource.ResourceHelper;
import io.nop.core.unittest.BaseTestCase;
import io.nop.ooxml.xlsx.util.ExcelHelper;
import io.nop.report.core.util.ExcelReportHelper;
import io.nop.xlang.api.XLang;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParseTreeTable extends BaseTestCase {
    @BeforeAll
    public static void beforeAll() {
        CoreInitialization.initialize();
    }

    @AfterAll
    public static void afterAll() {
        CoreInitialization.destroy();
    }

    @Test
    public void testParse() {
        IResource resource = attachmentResource("test_imp.test.xlsx");
        Object bean = ExcelHelper.loadXlsxObject("/nop/test/imp/test.imp.xml", resource);
        assertEquals(attachmentJsonText("imp-result.json"), JsonTool.serialize(bean, true));
    }


    /**
     * 可以解析两种不同的Excel模板格式
     */
    @Test
    public void testParse2() {
        IResource resource = attachmentResource("test_imp2.test.xlsx");
        Object bean = ExcelHelper.loadXlsxObject("/nop/test/imp/test.imp.xml", resource);
        assertEquals(attachmentJsonText("imp-result.json"), JsonTool.serialize(bean, true));

        // 报表导出的时候会对tree table数据进行转换，因此bean的属性会被修改
        Object bean2 = CloneHelper.deepClone(bean);

        ExcelReportHelper.saveXlsxObject("/nop/test/imp/test.imp.xml", getTargetResource("test-exp.xlsx"), bean);

        String html = ExcelReportHelper.getHtmlForXlsxObject("/nop/test/imp/test.imp.xml", bean2);
        ResourceHelper.writeText(getTargetResource("test-exp.html"), html);
    }


    @Test
    public void testParse3() {
        IResource resource = attachmentResource("test_imp3.test.xlsx");
        Object bean = ExcelHelper.loadXlsxObject("/nop/test/imp/test3.imp.xml", resource);
        assertEquals(attachmentJsonText("imp-result3.json"), JsonTool.serialize(bean, true));

        IEvalScope scope = XLang.newEvalScope();
        scope.setLocalValue("indexYears", Arrays.asList(2001, 2002, 2003, 2004));

        ExcelReportHelper.saveXlsxObject("/nop/test/imp/test3.imp.xml", getTargetResource("test-exp3.xlsx"), bean, scope);

    }

}
