/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.xlang.xpath.parse;

import io.nop.api.core.util.SourceLocation;
import io.nop.commons.text.tokenizer.TextScanner;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.lang.eval.IExpressionExecutor;
import io.nop.core.lang.xml.XNode;
import io.nop.xlang.XLangConstants;
import io.nop.xlang.ast.CustomExpression;
import io.nop.xlang.ast.Expression;
import io.nop.xlang.exec.AbstractExecutable;
import io.nop.xlang.expr.simple.SimpleExprParser;

public class XPathExprParser extends SimpleExprParser {
    @Override
    protected Expression defaultFactorExpr(TextScanner sc) {
        if (sc.tryConsume('@')) {
            SourceLocation loc = sc.location();
            String attrName = sc.nextXmlName();
            sc.skipBlank();
            CustomExpression ret = new CustomExpression();
            ret.setLocation(loc);
            ret.setSource("@" + attrName);
            ret.setExecutable(new AbstractExecutable(loc) {
                @Override
                public void display(StringBuilder sb) {
                    sb.append("@").append(attrName);
                }

                @Override
                public Object execute(IExpressionExecutor executor, IEvalScope scope) {
                    XNode node = (XNode) scope.getEvalScope().getValue(XLangConstants.XPATH_VAR_THIS_NODE);
                    return node.getAttr(attrName);
                }
            });
            return ret;
        }
        return super.defaultFactorExpr(sc);
    }
}
