/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.xlang.exec;

import io.nop.api.core.util.Guard;
import io.nop.api.core.util.SourceLocation;
import io.nop.core.context.IEvalContext;
import io.nop.core.lang.eval.IEvalPredicate;
import io.nop.core.lang.eval.IEvalScope;
import io.nop.core.lang.eval.IExecutableExpression;
import io.nop.core.lang.eval.IExpressionExecutor;
import io.nop.core.model.query.FilterOp;

import java.util.function.Predicate;

public class AssertOpExecutable extends AbstractExecutable implements IEvalPredicate {
    private final FilterOp filterOp;
    protected final IExecutableExpression value;
    private final Predicate<Object> predicate;

    public AssertOpExecutable(SourceLocation loc, FilterOp filterOp,
                              IExecutableExpression value) {
        super(loc);
        this.filterOp = filterOp;
        this.value = Guard.notNull(value, "value");
        this.predicate = Guard.notNull(filterOp, "filterOp").getPredicate();
    }

    public FilterOp getFilterOp() {
        return filterOp;
    }

    @Override
    public boolean allowBreakPoint() {
        return false;
    }

    public void display(StringBuilder sb) {
        value.display(sb);
        sb.append(' ');
        sb.append(getFilterOp().name());
        sb.append(' ');
    }

    @Override
    public Object execute(IExpressionExecutor executor, IEvalScope scope) {
        Object v1 = executor.execute(value, scope);
        return predicate.test(v1);
    }

    @Override
    public boolean passConditions(IEvalContext ctx) {
        IEvalScope scope = ctx.getEvalScope();
        IExpressionExecutor executor = scope.getExpressionExecutor();
        Object v1 = executor.execute(value, scope);
        return predicate.test(v1);
    }
}