/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.api.core.annotations.task;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在长时任务的start方法上标注
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TaskMethod {

    /**
     * 用于获取长时任务的执行状态信息。status方法的参数为原始request对象，返回TaskStatusBean对象。
     */
    String statusMethod() default "";

    /**
     * 用于取消正在执行的长时任务。cancel方法的参数为原始request对象，返回TaskStatusBean对象
     */
    String cancelMethod();
}
