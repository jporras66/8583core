
package com.indarsoft.iso8583core.types;

import java.util.Arrays;

import com.indarsoft.iso8583core.utl.Common;

/**
 * TypeMain : Abstract class for all data types.
 * 
 */
public abstract class TypeMain {

	private Field	field ;
    private byte[] 	bytearr;				
	private boolean isvalid = true ;
	private String  statusMsg ; 
//    

	/** Constructor
	 * 
	 * @param abytearr value
	 * @param afield {@link Field} afield 
	 * 
	 */
    protected TypeMain ( byte[] abytearr, Field	afield){
    	bytearr = abytearr; 
    	field	= afield;    	
    }
	
    protected Field getField() {
 		return field ;
 	}
    
    public FieldCodificationType getFieldCodification() {
		return field.getFieldCodification();
	}	
	
    public FieldFormatType getFieldFormat() {
		return field.getFieldFormat();
	}
	
    public LengthFormatType getLengthFormat() {
		return field.getLengthFormat();
	}
    
	public boolean isValid() {
		return isvalid;
	}

	public String getStatusMsg() {
		return statusMsg;
	}
	
	public String toString () {
		
		return Common.toString( bytearr,  field ) ; 
	}
	
	
	/**
	 * Validates data for this field 
	 * 
	 * @return boolean
	 * 
	 */  	
	protected boolean validateFieldDataFormat ( ){

		byte[] bar = Arrays.copyOfRange ( bytearr , field.getLengthOfLengthField() , bytearr.length );
		
		return Common.hasvalidCodification( bar, field ); 
		
	}
	
	/**
	 * validate length test.codification 
	 * 
	 * @return boolean
	 * 
	 */  	
	protected boolean validateFieldLengthFormat ( ){

		byte[] bar = Arrays.copyOfRange ( bytearr , 0, field.getLengthOfLengthField() );
		return Common.hasvalidLengthFormat( bar,  this.field ) ;
		
	}
	
	protected void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

	protected void setStatusMsg(String msg) {
		this.statusMsg = msg;
	}

	public byte[] getBytearr() {
		return bytearr;
	}

	public int getFieldId(){
		return field.getId() ;
	}
}
