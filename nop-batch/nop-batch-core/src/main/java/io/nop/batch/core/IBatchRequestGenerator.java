/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.batch.core;

/**
 * 在执行过程中动态产生新的request对象
 */
public interface IBatchRequestGenerator<S, R, C> {
    /**
     * 每次调用都产生一个新的对象。如果返回null，则表示已经结束，不应该再被调用
     */
    S nextRequest(C context);

    /**
     * 将request对象的处理结果数据反馈给生成器，从而确定如何生成下一个request。
     *
     * @param response IBatchProcessor处理request所输出的response对象
     * @param context  上下文对象
     */
    void onResponse(R response, C context);
}