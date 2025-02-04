package io.nop.xlang.xt.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [76:10:0:0]/nop/schema/xt.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement"})
public abstract class _XtChooseModel extends io.nop.xlang.xt.model.XtRuleModel {
    
    /**
     *  
     * xml name: otherwise
     * 
     */
    private io.nop.xlang.xt.model.XtRuleGroupModel _otherwise ;
    
    /**
     *  
     * xml name: when
     * 
     */
    private io.nop.xlang.xt.model.XtChooseWhenModel _when ;
    
    /**
     * 
     * xml name: otherwise
     *  
     */
    
    public io.nop.xlang.xt.model.XtRuleGroupModel getOtherwise(){
      return _otherwise;
    }

    
    public void setOtherwise(io.nop.xlang.xt.model.XtRuleGroupModel value){
        checkAllowChange();
        
        this._otherwise = value;
           
    }

    
    /**
     * 
     * xml name: when
     *  
     */
    
    public io.nop.xlang.xt.model.XtChooseWhenModel getWhen(){
      return _when;
    }

    
    public void setWhen(io.nop.xlang.xt.model.XtChooseWhenModel value){
        checkAllowChange();
        
        this._when = value;
           
    }

    

    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._otherwise = io.nop.api.core.util.FreezeHelper.deepFreeze(this._otherwise);
            
           this._when = io.nop.api.core.util.FreezeHelper.deepFreeze(this._when);
            
        }
    }

    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.put("otherwise",this.getOtherwise());
        out.put("when",this.getWhen());
    }
}
 // resume CPD analysis - CPD-ON
