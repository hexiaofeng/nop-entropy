package io.nop.excel.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [192:14:0:0]/nop/schema/excel/workbook.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement"})
public abstract class _XptSheetModel extends io.nop.core.resource.component.AbstractComponentModel {
    
    /**
     *  
     * xml name: afterExpand
     * 
     */
    private io.nop.core.lang.eval.IEvalAction _afterExpand ;
    
    /**
     *  
     * xml name: beforeExpand
     * 
     */
    private io.nop.core.lang.eval.IEvalAction _beforeExpand ;
    
    /**
     *  
     * xml name: beginLoop
     * 可以根据模板生成多个sheet。 beginLoop如果返回数组，则针对数组中的每一项都生成一个Sheet
     */
    private io.nop.core.lang.eval.IEvalAction _beginLoop ;
    
    /**
     *  
     * xml name: endLoop
     * 
     */
    private io.nop.core.lang.eval.IEvalAction _endLoop ;
    
    /**
     *  
     * xml name: loopIndexName
     * 
     */
    private java.lang.String _loopIndexName ;
    
    /**
     *  
     * xml name: loopItemsName
     * 
     */
    private java.lang.String _loopItemsName ;
    
    /**
     *  
     * xml name: loopVarName
     * 
     */
    private java.lang.String _loopVarName ;
    
    /**
     *  
     * xml name: sheetNameExpr
     * 
     */
    private io.nop.core.lang.eval.IEvalAction _sheetNameExpr ;
    
    /**
     *  
     * xml name: sheetVarName
     * 如果非空，则所有顶层的非展开单元格中的field实际都对应于此对象中的field。
     * 例如 sheetVarName=entity, 则field=x 实际对应 entity.x
     * 如果没有指定sheetVarName, 则field=x，实际对应scope.getValue('x')
     */
    private java.lang.String _sheetVarName ;
    
    /**
     *  
     * xml name: testExpr
     * 
     */
    private io.nop.core.lang.eval.IEvalPredicate _testExpr ;
    
    /**
     * 
     * xml name: afterExpand
     *  
     */
    
    public io.nop.core.lang.eval.IEvalAction getAfterExpand(){
      return _afterExpand;
    }

    
    public void setAfterExpand(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._afterExpand = value;
           
    }

    
    /**
     * 
     * xml name: beforeExpand
     *  
     */
    
    public io.nop.core.lang.eval.IEvalAction getBeforeExpand(){
      return _beforeExpand;
    }

    
    public void setBeforeExpand(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._beforeExpand = value;
           
    }

    
    /**
     * 
     * xml name: beginLoop
     *  可以根据模板生成多个sheet。 beginLoop如果返回数组，则针对数组中的每一项都生成一个Sheet
     */
    
    public io.nop.core.lang.eval.IEvalAction getBeginLoop(){
      return _beginLoop;
    }

    
    public void setBeginLoop(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._beginLoop = value;
           
    }

    
    /**
     * 
     * xml name: endLoop
     *  
     */
    
    public io.nop.core.lang.eval.IEvalAction getEndLoop(){
      return _endLoop;
    }

    
    public void setEndLoop(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._endLoop = value;
           
    }

    
    /**
     * 
     * xml name: loopIndexName
     *  
     */
    
    public java.lang.String getLoopIndexName(){
      return _loopIndexName;
    }

    
    public void setLoopIndexName(java.lang.String value){
        checkAllowChange();
        
        this._loopIndexName = value;
           
    }

    
    /**
     * 
     * xml name: loopItemsName
     *  
     */
    
    public java.lang.String getLoopItemsName(){
      return _loopItemsName;
    }

    
    public void setLoopItemsName(java.lang.String value){
        checkAllowChange();
        
        this._loopItemsName = value;
           
    }

    
    /**
     * 
     * xml name: loopVarName
     *  
     */
    
    public java.lang.String getLoopVarName(){
      return _loopVarName;
    }

    
    public void setLoopVarName(java.lang.String value){
        checkAllowChange();
        
        this._loopVarName = value;
           
    }

    
    /**
     * 
     * xml name: sheetNameExpr
     *  
     */
    
    public io.nop.core.lang.eval.IEvalAction getSheetNameExpr(){
      return _sheetNameExpr;
    }

    
    public void setSheetNameExpr(io.nop.core.lang.eval.IEvalAction value){
        checkAllowChange();
        
        this._sheetNameExpr = value;
           
    }

    
    /**
     * 
     * xml name: sheetVarName
     *  如果非空，则所有顶层的非展开单元格中的field实际都对应于此对象中的field。
     * 例如 sheetVarName=entity, 则field=x 实际对应 entity.x
     * 如果没有指定sheetVarName, 则field=x，实际对应scope.getValue('x')
     */
    
    public java.lang.String getSheetVarName(){
      return _sheetVarName;
    }

    
    public void setSheetVarName(java.lang.String value){
        checkAllowChange();
        
        this._sheetVarName = value;
           
    }

    
    /**
     * 
     * xml name: testExpr
     *  
     */
    
    public io.nop.core.lang.eval.IEvalPredicate getTestExpr(){
      return _testExpr;
    }

    
    public void setTestExpr(io.nop.core.lang.eval.IEvalPredicate value){
        checkAllowChange();
        
        this._testExpr = value;
           
    }

    

    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
        }
    }

    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.put("afterExpand",this.getAfterExpand());
        out.put("beforeExpand",this.getBeforeExpand());
        out.put("beginLoop",this.getBeginLoop());
        out.put("endLoop",this.getEndLoop());
        out.put("loopIndexName",this.getLoopIndexName());
        out.put("loopItemsName",this.getLoopItemsName());
        out.put("loopVarName",this.getLoopVarName());
        out.put("sheetNameExpr",this.getSheetNameExpr());
        out.put("sheetVarName",this.getSheetVarName());
        out.put("testExpr",this.getTestExpr());
    }
}
 // resume CPD analysis - CPD-ON
