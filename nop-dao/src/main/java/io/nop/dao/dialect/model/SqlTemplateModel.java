/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.dao.dialect.model;

import io.nop.dao.dialect.model._gen._SqlTemplateModel;

public class SqlTemplateModel extends _SqlTemplateModel implements ISqlFunctionModel {
    public SqlTemplateModel() {

    }

    public String getType() {
        return "template";
    }
}