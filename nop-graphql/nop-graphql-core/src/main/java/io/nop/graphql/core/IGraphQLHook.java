/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.graphql.core;

public interface IGraphQLHook {
    Object beginExecute(IGraphQLExecutionContext context);

    void endExecute(Object meter, Throwable exception, IGraphQLExecutionContext context);

    Object beginInvoke(IDataFetchingEnvironment env);

    void endInvoke(Object meter, Throwable exception, IDataFetchingEnvironment env);

    Object beginDataFetch(IDataFetchingEnvironment env);

    void endDataFetch(Object meter, Throwable exception, IDataFetchingEnvironment env);
}