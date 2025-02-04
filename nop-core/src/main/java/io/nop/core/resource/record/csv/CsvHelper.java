/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.core.resource.record.csv;

import io.nop.commons.util.IoHelper;
import io.nop.core.reflect.ReflectionManager;
import io.nop.core.resource.IResource;
import io.nop.core.type.IGenericType;
import org.apache.commons.csv.CSVFormat;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class CsvHelper {
    public static <T> List<T> readCsv(IResource resource, Type type, CSVFormat format) {
        IGenericType rowType = type == null ? null : ReflectionManager.instance().buildGenericType(type);
        CsvRecordInput<T> input = new CsvRecordInput<>(resource, null,
                format, rowType, null, true, true);
        try {
            return input.readAll();
        } finally {
            IoHelper.safeCloseObject(input);
        }
    }

    public static List<Map<String, Object>> readCsv(IResource resource) {
        return readCsv(resource, null, CSVFormat.DEFAULT);
    }

    public static <T> void writeCsv(IResource resource, CSVFormat format, List<String> headers, List<T> data) {
        CsvRecordOutput<T> output = new CsvRecordOutput<>(resource, null, format, headers, true);
        try {
            output.writeBatch(data);
        } finally {
            IoHelper.safeCloseObject(output);
        }
    }
}