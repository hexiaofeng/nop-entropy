/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.commons.util.retry;

import io.nop.api.core.exceptions.NopException;
import io.nop.api.core.util.FutureHelper;
import io.nop.commons.concurrent.executor.IScheduledExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class RetryHelper {
    public static <T> T retryCall(IRetryPolicy retryPolicy, Callable<T> task) {
        int retryTimes = 0;
        do {
            try {
                return task.call();
            } catch (Throwable e) {
                long delay = retryPolicy.getRetryDelay(e, retryTimes);
                if (delay < 0)
                    throw NopException.adapt(e);
                if (delay > 0) {
                    try {
                        Thread.sleep(delay);
                    } catch (Exception ex) { //NOPMD - suppressed EmptyCatchBlock
                        // ignore
                    }
                }
                retryTimes++;
            }
        } while (true);
    }

    public static <T> CompletableFuture<T> retryExecute(IRetryPolicy retryPolicy, IScheduledExecutor executor,
                                                        Callable<?> task) {
        CompletableFuture<T> promise = new CompletableFuture<>();
        _retryExecute(promise, retryPolicy, executor, task, 0, 0);
        return promise;
    }

    static <T> void _retryExecute(CompletableFuture<T> promise, IRetryPolicy retryPolicy, IScheduledExecutor executor,
                                  Callable<?> task, long delay, int retryTimes) {
        executor.schedule(() -> {
            FutureHelper.futureCall(task).whenComplete((ret, ex) -> {
                if (ex != null) {
                    long nextDelay = retryPolicy.getRetryDelay(ex, retryTimes);
                    if (nextDelay >= 0) {
                        _retryExecute(promise, retryPolicy, executor, task, nextDelay, retryTimes + 1);
                        return;
                    }
                    promise.completeExceptionally(ex);
                } else {
                    promise.complete((T) ret);
                }
            });
            return null;
        }, delay, TimeUnit.MILLISECONDS);
    }
}