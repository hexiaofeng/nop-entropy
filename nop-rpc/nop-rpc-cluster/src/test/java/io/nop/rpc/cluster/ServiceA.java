package io.nop.rpc.cluster;

import io.nop.api.core.beans.ApiRequest;
import io.nop.api.core.beans.ApiResponse;

public interface ServiceA {
    ApiResponse<String> myMethod(ApiRequest<String> request);
}
