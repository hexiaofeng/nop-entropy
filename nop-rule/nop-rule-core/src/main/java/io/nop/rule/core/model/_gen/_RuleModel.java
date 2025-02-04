package io.nop.rule.core.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [1:2:0:0]/nop/schema/rule.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement"})
public abstract class _RuleModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: afterExecute
     * 无论规则是否成功匹配，都会执行到这里
     */
    private io.nop.core.lang.eval.IEvalAction _afterExecute ;
    
    /**
     *  
     * xml name: beforeExecute
     * 在规则匹配前执行，可以用于初始化上下文对象
     */
    private io.nop.core.lang.eval.IEvalAction _beforeExecute ;
    
    /**
     *  
     * xml name: decisionMatrix
     * 
     */
    private io.nop.rule.core.model.RuleDecisionMatrixModel _decisionMatrix ;
    
    /**
     *  
     * xml name: decisionTree
     * 
     */
    private io.nop.rule.core.model.RuleDecisionTreeModel _decisionTree ;
    
    /**
     *  
     * xml name: description
     * 
     */
    private java.lang.String _description ;
    
    /**
     *  
     * xml name: displayName
     * 
     */
    private java.lang.String _displayName ;
    
    /**
     *  
     * xml name: inputs
     * 
     */
    private KeyedList<io.nop.rule.core.model.RuleInputDefineModel> _inputs = KeyedList.emptyList();
    
    /**
     *  
     * xml name: outputs
     * 
     */
    private KeyedList<io.nop.rule.core.model.RuleOutputDefineModel> _outputs = KeyedList.emptyList();
    
    /**
     * 
     * xml name: afterExecute
     *  无论规则是否成功匹配，都会执行到这里
     */
    
    public io.nop.core.lang.eval.IEvalAction getAfterExecute(){
      return _afterExecute;
    }

    
    public void setAfterExecute(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._afterExecute = value;
           
    }

    
    /**
     * 
     * xml name: beforeExecute
     *  在规则匹配前执行，可以用于初始化上下文对象
     */
    
    public io.nop.core.lang.eval.IEvalAction getBeforeExecute(){
      return _beforeExecute;
    }

    
    public void setBeforeExecute(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._beforeExecute = value;
           
    }

    
    /**
     * 
     * xml name: decisionMatrix
     *  
     */
    
    public io.nop.rule.core.model.RuleDecisionMatrixModel getDecisionMatrix(){
      return _decisionMatrix;
    }

    
    public void setDecisionMatrix(io.nop.rule.core.model.RuleDecisionMatrixModel value){
        checkAllowChange();
        
        this._decisionMatrix = value;
           
    }

    
    /**
     * 
     * xml name: decisionTree
     *  
     */
    
    public io.nop.rule.core.model.RuleDecisionTreeModel getDecisionTree(){
      return _decisionTree;
    }

    
    public void setDecisionTree(io.nop.rule.core.model.RuleDecisionTreeModel value){
        checkAllowChange();
        
        this._decisionTree = value;
           
    }

    
    /**
     * 
     * xml name: description
     *  
     */
    
    public java.lang.String getDescription(){
      return _description;
    }

    
    public void setDescription(java.lang.String value){
        checkAllowChange();
        
        this._description = value;
           
    }

    
    /**
     * 
     * xml name: displayName
     *  
     */
    
    public java.lang.String getDisplayName(){
      return _displayName;
    }

    
    public void setDisplayName(java.lang.String value){
        checkAllowChange();
        
        this._displayName = value;
           
    }

    
    /**
     * 
     * xml name: inputs
     *  
     */
    
    public java.util.List<io.nop.rule.core.model.RuleInputDefineModel> getInputs(){
      return _inputs;
    }

    
    public void setInputs(java.util.List<io.nop.rule.core.model.RuleInputDefineModel> value){
        checkAllowChange();
        
        this._inputs = KeyedList.fromList(value, io.nop.rule.core.model.RuleInputDefineModel::getName);
           
    }

    
    public io.nop.rule.core.model.RuleInputDefineModel getInput(String name){
        return this._inputs.getByKey(name);
    }

    public boolean hasInput(String name){
        return this._inputs.containsKey(name);
    }

    public void addInput(io.nop.rule.core.model.RuleInputDefineModel item) {
        checkAllowChange();
        java.util.List<io.nop.rule.core.model.RuleInputDefineModel> list = this.getInputs();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.rule.core.model.RuleInputDefineModel::getName);
            setInputs(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_inputs(){
        return this._inputs.keySet();
    }

    public boolean hasInputs(){
        return !this._inputs.isEmpty();
    }
    
    /**
     * 
     * xml name: outputs
     *  
     */
    
    public java.util.List<io.nop.rule.core.model.RuleOutputDefineModel> getOutputs(){
      return _outputs;
    }

    
    public void setOutputs(java.util.List<io.nop.rule.core.model.RuleOutputDefineModel> value){
        checkAllowChange();
        
        this._outputs = KeyedList.fromList(value, io.nop.rule.core.model.RuleOutputDefineModel::getName);
           
    }

    
    public io.nop.rule.core.model.RuleOutputDefineModel getOutput(String name){
        return this._outputs.getByKey(name);
    }

    public boolean hasOutput(String name){
        return this._outputs.containsKey(name);
    }

    public void addOutput(io.nop.rule.core.model.RuleOutputDefineModel item) {
        checkAllowChange();
        java.util.List<io.nop.rule.core.model.RuleOutputDefineModel> list = this.getOutputs();
        if (list == null || list.isEmpty()) {
            list = new KeyedList<>(io.nop.rule.core.model.RuleOutputDefineModel::getName);
            setOutputs(list);
        }
        list.add(item);
    }
    
    public java.util.Set<String> keySet_outputs(){
        return this._outputs.keySet();
    }

    public boolean hasOutputs(){
        return !this._outputs.isEmpty();
    }
    

    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._decisionMatrix = io.nop.api.core.util.FreezeHelper.deepFreeze(this._decisionMatrix);
            
           this._decisionTree = io.nop.api.core.util.FreezeHelper.deepFreeze(this._decisionTree);
            
           this._inputs = io.nop.api.core.util.FreezeHelper.deepFreeze(this._inputs);
            
           this._outputs = io.nop.api.core.util.FreezeHelper.deepFreeze(this._outputs);
            
        }
    }

    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.put("afterExecute",this.getAfterExecute());
        out.put("beforeExecute",this.getBeforeExecute());
        out.put("decisionMatrix",this.getDecisionMatrix());
        out.put("decisionTree",this.getDecisionTree());
        out.put("description",this.getDescription());
        out.put("displayName",this.getDisplayName());
        out.put("inputs",this.getInputs());
        out.put("outputs",this.getOutputs());
    }
}
 // resume CPD analysis - CPD-ON
