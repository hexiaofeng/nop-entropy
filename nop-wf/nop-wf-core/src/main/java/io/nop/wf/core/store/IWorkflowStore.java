/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.wf.core.store;

import io.nop.wf.core.IWorkflowVarSet;
import io.nop.wf.api.actor.IWfActor;
import io.nop.wf.core.model.IWorkflowActionModel;
import io.nop.wf.core.model.IWorkflowModel;
import io.nop.wf.core.model.IWorkflowStepModel;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface IWorkflowStore {

    Object loadBizEntity(String bizObjType, String bizEntityId);

    void updateBizEntityState(String bizObjType, Object bizEntity, String bizEntityStateProp, String state);

    IWorkflowRecord newWfRecord(IWorkflowModel model);

    /**
     * 返回的stepRecord的status和stepId, stepDefId等字段都已经被正确初始化
     *
     * @param wfRecord
     * @param stepModel
     * @return
     */
    IWorkflowStepRecord newStepRecord(IWorkflowRecord wfRecord, IWorkflowStepModel stepModel);

    IWorkflowActionRecord newActionRecord(IWorkflowStepRecord stepRecord, IWorkflowActionModel actionModel);

    void saveWfRecord(IWorkflowRecord wfRecord);

    void removeWfRecord(IWorkflowRecord wfRecord);

    void saveStepRecord(IWorkflowStepRecord stepRecord);

    void saveActionRecord(IWorkflowActionRecord actionRecord);

    void addNextStepRecord(IWorkflowStepRecord currentStep, String actionId, IWorkflowStepRecord nextStep);

    void addNextSpecialStep(IWorkflowStepRecord currentStep, String actionId, String specialStepId);

    IWorkflowRecord getWfRecord(String wfName, String wfVersion, String wfId);

    IWorkflowVarSet getGlobalVars(IWorkflowRecord wfRecord);

    IWorkflowVarSet getOutputVars(IWorkflowRecord wfRecord);

    void logError(IWorkflowRecord wfRecord, String errorCode, Map<String, Object> params);

    void logError(IWorkflowRecord wfRecord, String stepName, String actionName, Throwable e);

    IWorkflowStepRecord getStepRecordById(IWorkflowRecord wfRecord, String stepId);

    IWorkflowStepRecord getLatestStepRecordByName(IWorkflowRecord wfRecord, String stepName);

    Collection<? extends IWorkflowStepRecord> getStepRecords(IWorkflowRecord wfRecord, boolean includeHistory);

    Collection<? extends IWorkflowStepRecord> getStepRecordsByName(IWorkflowRecord wfRecord, String stepName);

    Collection<? extends IWorkflowStepRecord> getPrevStepRecords(IWorkflowStepRecord stepRecord);

    Collection<? extends IWorkflowStepRecord> getNextStepRecords(IWorkflowStepRecord stepRecord);

    IWorkflowStepRecord getPrevStepRecordByName(IWorkflowStepRecord stepRecord, String stepName);

    IWorkflowStepRecord getNextStepRecordByName(IWorkflowStepRecord stepRecord, String stepName);

    IWorkflowStepRecord getNextStepRecordByName(IWorkflowStepRecord stepRecord, String stepName, IWfActor actor);

    Collection<? extends IWorkflowStepRecord> getJoinWaitStepRecords(IWorkflowStepRecord stepRecord, String joinKey, Set<String> stepNames);

    Collection<? extends IWorkflowStepRecord> getPrevStepRecordsByName(IWorkflowStepRecord stepRecord, Collection<String> stepNames);

    Collection<? extends IWorkflowStepRecord> getNextStepRecordsByName(IWorkflowStepRecord stepRecord, Collection<String> stepNames);

    boolean isAllStepsHistory(IWorkflowRecord wfRecord);

    IWorkflowStepRecord getNextWaitingStepRecord(IWorkflowStepRecord stepRecord, String joinKey, String stepName, IWfActor actor);


    Set<String> getOnSignals(IWorkflowRecord wfRecord);

    void saveOnSignals(IWorkflowRecord wfRecord, Set<String> signals);
}
