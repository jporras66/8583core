package com.indarsoft.iso8583core.types;

import java.util.Arrays;
import com.indarsoft.iso8583core.utl.Common;

/**
 * TypeVar : Primitive type variable length data.
 * <p>
 * This class describe a variable length data type <br>
 * 
 */
public class TypeVar extends TypeMain  {

	protected final String className = this.getClass().getSimpleName() + "." ;
	private int fieldLength; 
	private int dataLength; 
	/**
	 * Constructor for new TypeVar
	 * 
	 * @param bytearr value
	 * @param field see {@link Field}  
	 * 
	 * 
	 */
	public TypeVar ( byte[] bytearr , Field field )   {   	
        
    	super( bytearr, field) ; 
    	validate() ;

    }
    
	public TypeVar ( byte[] bytearr , Field fieldAtr , boolean validateField )   {   	
        
    	super( bytearr, fieldAtr) ; 
    	if ( validateField ) validate() ; 

    }
        
    private void validate() {
    	
    	validateLength() ; 
    	validateData() ;
 
    }
    
    protected void validateLength(){
      	/*
    	 *  Length codification & Length value validation          
    	*/ 
    	if ( ! super.validateFieldLengthFormat()  ) {
    	   	super.setIsvalid(  false );
    	   	super.setStatusMsg ( className+"validateLength invalid. Codification is : " + super.getField().getLengthFormat() ) ;
    	   	return;
    	}   
    	    	
    	this.fieldLength = calculateFieldLength();
    	if ( this.fieldLength <  super.getField().getMinfieldLength() || this.fieldLength >  super.getField().getMaxfieldLength()  ) {
    		super.setIsvalid(  false );
    	    super.setStatusMsg ( className+"validateLength invalid. Field length is " + this.fieldLength + " but expected beetwen " + super.getField().getMinfieldLength() + " and " + super.getField().getMaxfieldLength() ) ; 
    	    return;
    	 }     
    }
    
    protected void validateData(){

       	/*
    	 *  Data Length & codification validation        
    	*/        
    	this.dataLength = getBytearr().length - getField().getLengthOfLengthField()  ;
    	int arrlength 	= getField().getVarExpectedDataArrayLength( fieldLength ) ;	
    	if ( this.dataLength != arrlength  ) {
    		super.setIsvalid( false );
    		super.setStatusMsg( className+"validateData invalid. Data array Length is " + this.dataLength + " but expected is " +  arrlength + " for a fieldLength of " + fieldLength + " characters" ) ;
    		return;
    	}
    	    	
    	boolean isvalid = super.validateFieldDataFormat( ); 
    	if ( ! isvalid ){
    		super.setIsvalid(  false );
    		super.setStatusMsg ( className+"validateData invalid. fieldFormat is " + super.getFieldFormat().toString() ) ;
    	    return;
    	}    	
    }
    
	private int calculateFieldLength(  ){
			
		int numDigits = super.getField().getLengthOfLengthField() ;
		byte[] bar = Arrays.copyOfRange ( super.getBytearr() , 0 , numDigits  );
		
		return Common.computeFieldLength( bar , super.getField() ) ; 
	}
		
	/**
	 * return Length sub-array of bytes
	 * 
	 * @return byte[]
	 * 
	 */
	 public byte[] getLength() { 
		 byte[] dataarr = Arrays.copyOfRange ( super.getBytearr(), 0, super.getField().getLengthOfLengthField() );
		 return dataarr ;
	 }
	/**
	 * return data sub-array of bytes
	 * 
	 * @return byte[]
	 * 
	 */	 
	 public byte[] getData(  ){ 
		 int sp = super.getField().getLengthOfLengthField() ;
		 int ep = super.getBytearr().length ;
		 byte[] dataarr = Arrays.copyOfRange ( super.getBytearr(), sp  , ep  );
		 return dataarr ;
	 }	
	
 	/**
	 * return data sub-array as String 
	 * 
	 * @return String
	 * 
	 */
	public String data2String () {
		
		byte[] bytearr = getData();
		
		return Common.toString( bytearr,  super.getField() ) ;
		
	}
 	/**
	 * return length sub-array as String 
	 * 
	 * @return String
	 * 
	 */
	public String length2String () {
		
		byte[] bytearr = getLength();
		
		return Common.toString( bytearr,  super.getField() ) ;
		
	}
}
