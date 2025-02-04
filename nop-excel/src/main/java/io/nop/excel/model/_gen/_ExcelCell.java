package io.nop.excel.model._gen;

import io.nop.commons.collections.KeyedList; //NOPMD - suppressed UnusedImports - Used for List Prop
import io.nop.core.lang.json.IJsonHandler;



// tell cpd to start ignoring code - CPD-OFF
/**
 * generate from [72:30:0:0]/nop/schema/excel/workbook.xdef <p>
 * 
 */
@SuppressWarnings({"PMD.UselessOverridingMethod","PMD.UnusedLocalVariable",
    "PMD.UnnecessaryFullyQualifiedName","PMD.EmptyControlStatement"})
public abstract class _ExcelCell extends io.nop.core.model.table.impl.AbstractCell {
    
    /**
     *  
     * xml name: comment
     * 
     */
    private java.lang.String _comment ;
    
    /**
     *  
     * xml name: formula
     * 
     */
    private java.lang.String _formula ;
    
    /**
     *  
     * xml name: mergeAcross
     * 向右合并的列数。mergeAcross + 1 == colSpan
     */
    private int _mergeAcross  = 0;
    
    /**
     *  
     * xml name: mergeDown
     * 
     */
    private int _mergeDown  = 0;
    
    /**
     *  
     * xml name: model
     * 
     */
    private io.nop.excel.model.XptCellModel _model ;
    
    /**
     *  
     * xml name: name
     * 
     */
    private java.lang.String _name ;
    
    /**
     *  
     * xml name: richText
     * 
     */
    private io.nop.excel.model.ExcelRichText _richText ;
    
    /**
     *  
     * xml name: styleId
     * 
     */
    private java.lang.String _styleId ;
    
    /**
     *  
     * xml name: type
     * 
     */
    private io.nop.excel.model.constants.ExcelCellType _type ;
    
    /**
     *  
     * xml name: value
     * 
     */
    private java.lang.Object _value ;
    
    /**
     * 
     * xml name: comment
     *  
     */
    
    public java.lang.String getComment(){
      return _comment;
    }

    
    public void setComment(java.lang.String value){
        checkAllowChange();
        
        this._comment = value;
           
    }

    
    /**
     * 
     * xml name: formula
     *  
     */
    
    public java.lang.String getFormula(){
      return _formula;
    }

    
    public void setFormula(java.lang.String value){
        checkAllowChange();
        
        this._formula = value;
           
    }

    
    /**
     * 
     * xml name: mergeAcross
     *  向右合并的列数。mergeAcross + 1 == colSpan
     */
    
    public int getMergeAcross(){
      return _mergeAcross;
    }

    
    public void setMergeAcross(int value){
        checkAllowChange();
        
        this._mergeAcross = value;
           
    }

    
    /**
     * 
     * xml name: mergeDown
     *  
     */
    
    public int getMergeDown(){
      return _mergeDown;
    }

    
    public void setMergeDown(int value){
        checkAllowChange();
        
        this._mergeDown = value;
           
    }

    
    /**
     * 
     * xml name: model
     *  
     */
    
    public io.nop.excel.model.XptCellModel getModel(){
      return _model;
    }

    
    public void setModel(io.nop.excel.model.XptCellModel value){
        checkAllowChange();
        
        this._model = value;
           
    }

    
    /**
     * 
     * xml name: name
     *  
     */
    
    public java.lang.String getName(){
      return _name;
    }

    
    public void setName(java.lang.String value){
        checkAllowChange();
        
        this._name = value;
           
    }

    
    /**
     * 
     * xml name: richText
     *  
     */
    
    public io.nop.excel.model.ExcelRichText getRichText(){
      return _richText;
    }

    
    public void setRichText(io.nop.excel.model.ExcelRichText value){
        checkAllowChange();
        
        this._richText = value;
           
    }

    
    /**
     * 
     * xml name: styleId
     *  
     */
    
    public java.lang.String getStyleId(){
      return _styleId;
    }

    
    public void setStyleId(java.lang.String value){
        checkAllowChange();
        
        this._styleId = value;
           
    }

    
    /**
     * 
     * xml name: type
     *  
     */
    
    public io.nop.excel.model.constants.ExcelCellType getType(){
      return _type;
    }

    
    public void setType(io.nop.excel.model.constants.ExcelCellType value){
        checkAllowChange();
        
        this._type = value;
           
    }

    
    /**
     * 
     * xml name: value
     *  
     */
    
    public java.lang.Object getValue(){
      return _value;
    }

    
    public void setValue(java.lang.Object value){
        checkAllowChange();
        
        this._value = value;
           
    }

    

    public void freeze(boolean cascade){
        if(frozen()) return;
        super.freeze(cascade);

        if(cascade){ //NOPMD - suppressed EmptyControlStatement - Auto Gen Code
        
           this._model = io.nop.api.core.util.FreezeHelper.deepFreeze(this._model);
            
           this._richText = io.nop.api.core.util.FreezeHelper.deepFreeze(this._richText);
            
        }
    }

    protected void outputJson(IJsonHandler out){
        super.outputJson(out);
        
        out.put("comment",this.getComment());
        out.put("formula",this.getFormula());
        out.put("mergeAcross",this.getMergeAcross());
        out.put("mergeDown",this.getMergeDown());
        out.put("model",this.getModel());
        out.put("name",this.getName());
        out.put("richText",this.getRichText());
        out.put("styleId",this.getStyleId());
        out.put("type",this.getType());
        out.put("value",this.getValue());
    }
}
 // resume CPD analysis - CPD-ON
