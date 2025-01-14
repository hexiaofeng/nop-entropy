/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.tcc.core.meta;

import io.nop.core.reflect.IClassModel;
import io.nop.core.reflect.ReflectionManager;

public class TccServiceMetaBuilder {
    public TccServiceMeta buildFromClass(Class<?> clazz) {
        IClassModel classModel = ReflectionManager.instance().getClassModel(clazz);
        return buildFromClassModel(classModel);
    }

    public TccServiceMeta buildFromClassModel(IClassModel classModel) {
        return null;
    }
}
