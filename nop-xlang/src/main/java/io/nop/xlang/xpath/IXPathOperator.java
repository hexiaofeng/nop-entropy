/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.xlang.xpath;

/**
 * 用于从XNode节点上获取值，对应xpath最后的取值部分
 *
 * @param <E>
 */
public interface IXPathOperator<E> {
    Object apply(E node, IXPathContext<E> context);
}