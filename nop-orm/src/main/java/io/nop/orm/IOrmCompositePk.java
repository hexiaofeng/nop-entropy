/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.orm;

import java.util.List;

public interface IOrmCompositePk {
    char COMPOSITE_PK_SEPARATOR = OrmConstants.COMPOSITE_PK_SEPARATOR;

    String toString();

    int size();

    Object get(int index);

    Object get(String propName);

    List<String> propNames();

    boolean containsNull();
}