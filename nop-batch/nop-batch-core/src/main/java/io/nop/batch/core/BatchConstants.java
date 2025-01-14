/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.batch.core;

public interface BatchConstants {
    String VAR_RECORD = "record";

    String DEFAULT_METER_PREFIX = "nop.";

    String METER_TASK = "batch.task";
    String METER_CHUNK = "batch.chunk";
    String METER_LOAD = "batch.load";
    String METER_CONSUME = "batch.consume";

    String METER_ITEM_LOAD = "batch.item.load";
    String METER_ITEM_PROCESS = "batch.item.process";
    String METER_ITEM_CONSUME = "batch.item.consume";

    String METER_ITEM_RETRY = "batch.item.retry";
    String METER_ITEM_SKIP = "batch.item.skip";

    String STATUS_SUCCESS = "SUCCESS";
    String STATUS_FAILURE = "FAILURE";
}
