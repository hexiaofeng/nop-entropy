/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.xlang.exec;

import io.nop.api.core.util.SourceLocation;
import io.nop.core.lang.eval.IEvalOutput;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.lang.eval.IExpressionExecutor;

public class OutputTextExecutable extends AbstractExecutable {
    private final String text;

    public OutputTextExecutable(SourceLocation loc, String text) {
        super(loc);
        this.text = text;
    }

    @Override
    public boolean allowBreakPoint() {
        return false;
    }

    @Override
    public void display(StringBuilder sb) {
        sb.append("@text:").append(text);
    }

    @Override
    public Object execute(IExpressionExecutor executor, IEvalScope scope) {
        IEvalOutput out = scope.getOut();
        out.text(getLocation(), text);
        return null;
    }
}
