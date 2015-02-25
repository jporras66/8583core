package com.indarsoft.iso8583core.types;

/**
 *  FieldFormatType
 *   
 *  <p>
 * 	0 - NUMERIC		numeric <br>
 * 	1 - AN			Alphanumeric <br>
 * 	2 - ANS			Alphanumeric & special <br>
 * 	3 - BINARY		Binary  <br>
 * 	
 */
public enum FieldFormatType {
	
	NUMERIC(0), AN(1), ANS(2) , BINARY(3) ;
    @SuppressWarnings("unused")
	private int value;

    private FieldFormatType (int value) {
            this.value = value;
    }
    
    public static  FieldFormatType getInstance (String value) {
    	//if ( "BCD".equals( value ) ) 		return FieldFormatType.BCD ;
    	if ( "NUMERIC".equals( value ) ) 	return FieldFormatType.NUMERIC ;
    	if ( "ANS".equals( value ) ) 		return FieldFormatType.ANS ;
    	if ( "AN".equals( value ) ) 		return FieldFormatType.AN ;
    	if ( "BINARY".equals( value ) ) 	return FieldFormatType.BINARY ;
    	
    	return null ; 
    }    
}
