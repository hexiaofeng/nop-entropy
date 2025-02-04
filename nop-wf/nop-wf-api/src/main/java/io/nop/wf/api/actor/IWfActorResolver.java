/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.wf.api.actor;

/**
 * 
 * @author canonical_entropy@163.com
 */
public interface IWfActorResolver {
	IWfActor resolveUser(String userId);
	
	IWfActor resolveActor(String actorType, String actorId, String deptId);
	
}