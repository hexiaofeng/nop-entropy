/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.tcc.core.interceptor;

import io.nop.api.core.ApiConstants;
import io.nop.api.core.beans.ApiRequest;
import io.nop.api.core.beans.ApiResponse;
import io.nop.rpc.api.IRpcServiceInterceptor;
import io.nop.rpc.api.IRpcServiceInvocation;
import io.nop.tcc.api.ITccEngine;
import io.nop.tcc.api.TccBranchRequest;
import io.nop.tcc.core.impl.TccHelper;
import io.nop.tcc.core.meta.ITccServiceMeta;
import io.nop.tcc.core.meta.TccMethodMeta;

import java.util.concurrent.CompletionStage;

import static io.nop.api.core.context.ContextProvider.thenOnContext;

public class TccRpcServiceInterceptor implements IRpcServiceInterceptor {

    private final ITccEngine tccEngine;
    private final ITccServiceMeta serviceMeta;

    public int order() {
        return ApiConstants.INTERCEPTOR_PRIORITY_TCC;
    }

    public TccRpcServiceInterceptor(ITccEngine engine, ITccServiceMeta serviceMeta) {
        this.tccEngine = engine;
        this.serviceMeta = serviceMeta;
    }

    @Override
    public CompletionStage<ApiResponse<?>> interceptAsync(IRpcServiceInvocation inv) {
        TccContext tccContext;
        if (inv.isInbound()) {
            // 如果是服务端，则根据ApiRequest中的tcc信息来初始化TccContext
            tccContext = TccContext.buildFromRequest(inv.getRequest());
            if (tccContext != null) {
                TccContext.setCurrent(tccContext);
                return thenOnContext(runWithTccContext(tccContext, inv)).whenComplete((ret, err) -> {
                    TccContext.setCurrent(null);
                });
            } else {
                return inv.proceedAsync();
            }
        } else {
            // 如果是客户端调用，则获取上下文中的TccContext
            tccContext = TccContext.getCurrent();
            return runWithTccContext(tccContext, inv);
        }
    }

    private CompletionStage<ApiResponse<?>> runWithTccContext(TccContext tccContext, IRpcServiceInvocation inv) {
        TccMethodMeta methodMeta = serviceMeta.getMethodMeta(inv.getServiceMethod());
        // 对于不支持tcc事务的方法，直接返回
        if (methodMeta == null) {
            return inv.proceedAsync();
        }

        if (tccContext != null) {
            // 如果事务分组不匹配，则忽略tccContext
            if (!TccHelper.isSameTxnGroup(methodMeta.getTxnGroup(), tccContext.getTxnGroup()))
                tccContext = null;
        }

        ApiRequest<?> request = inv.getRequest();
        String txnId = null;
        if (tccContext != null) {
            txnId = tccContext.getTxnId();
        }

        TccContext finalContext = tccContext;
        return tccEngine.runInTransactionAsync(methodMeta.getTxnGroup(), txnId, txn -> {
            if (shouldStartBranch(inv.isInbound(), txn.isInitiator(), methodMeta)) {
                TccBranchRequest req = buildBranchRequest(methodMeta, finalContext, request);
                return tccEngine.runBranchTransactionAsync(txn, req, t -> inv.proceedAsync());
            }
            return inv.proceedAsync();
        });
    }

    protected boolean shouldStartBranch(boolean inbound, boolean txnInitiator, TccMethodMeta methodMeta) {
        if (methodMeta.getCancelMethod() == null)
            return false;

        if (inbound) {
            // 总是由客户端负责记录branch信息，并负责回滚。因此服务端只要不是事务的启动者就不记录branch信息
            if (!txnInitiator)
                return false;
        }

        return true;
    }

    private TccBranchRequest buildBranchRequest(TccMethodMeta methodMeta, TccContext tccContext,
                                                ApiRequest<?> request) {
        TccBranchRequest req = new TccBranchRequest();
        req.setServiceName(serviceMeta.getServiceName());
        req.setTxnGroup(methodMeta.getTxnGroup());
        req.setServiceMethod(methodMeta.getServiceMethod());
        req.setCancelMethod(methodMeta.getCancelMethod());
        req.setConfirmMethod(methodMeta.getConfirmMethod());

        if (tccContext != null) {
            req.setParentBranchId(tccContext.getBranchId());
            req.setParentBranchNo(tccContext.getBranchNo());
        }
        req.setRequest(request);
        return req;
    }
}