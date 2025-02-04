/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.api.core.util;

public interface IOrdered {
    int HIGH_PRIORITY = 1000;

    int NORMAL_PRIORITY = 5000;

    int LOW_PRIORITY = 10000;

    default int order() {
        return NORMAL_PRIORITY;
    }
}