/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.core.dict;

import io.nop.api.core.beans.DictBean;
import io.nop.api.core.exceptions.NopException;
import io.nop.commons.cache.ICache;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static io.nop.core.CoreErrors.ARG_DICT_NAME;
import static io.nop.core.CoreErrors.ERR_DICT_UNKNOWN_DICT;

public interface IDictProvider {

    @Nullable
    DictBean getDict(String locale, String dictName, ICache<Object, Object> cache);

    @Nonnull
    default DictBean requireDict(String locale, String dictName, ICache<Object, Object> cache) {
        DictBean dict = getDict(locale, dictName, cache);
        if (dict == null)
            throw new NopException(ERR_DICT_UNKNOWN_DICT).param(ARG_DICT_NAME, dictName);
        return dict;
    }

    /**
     * 判断字典是否存在。解析meta文件的时候可能需要验证dict配置正确
     */
    boolean existsDict(String dictName);

    void addDictLoader(String prefix, IDictLoader dictLoader);

    void removeDictLoader(String prefix, IDictLoader dictLoader);
}