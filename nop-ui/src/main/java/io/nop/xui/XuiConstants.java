/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.xui;

public interface XuiConstants {
    String MODE_EDIT = "edit";
    String MODE_VIEW = "view";
    String MODE_QUERY = "query";

    String MODE_LIST_EDIT = "list-edit";
    String MODE_LIST_VIEW = "list-view";

    String MODE_LIST_PREFIX = "list-";

    String DATA_TYPE_ANY = "any";

    String DATA_TYPE_ENUM = "enum";

    String PROP_ID = "id";


    String GRAPHQL_LABEL_PROP = "graphql:labelProp";
    String GRAPHQL_JSON_COMPONENT_PROP = "graphql:jsonComponentProp";

    String EXT_RELATION = "ext:relation";
    String EXT_KIND = "ext:kind";
    String EXT_CONTROL = "ext:control";
    String EXT_JOIN_LEFT_PROP = "ext:joinLeftProp";
    String EXT_JOIN_RIGHT_PROP = "ext:joinRightProp";
    String EXT_JOIN_RIGHT_DISPLAY_PROP = "ext:joinRightDisplayProp";
    String EXT_REF_DISPLAY_PROP = "ext:refDisplayProp";

    String KIND_TO_ONE = "to-one";
    String KIND_TO_MANY = "to-many";

    String FILE_TYPE_VIEW_XML = "view.xml";
}
