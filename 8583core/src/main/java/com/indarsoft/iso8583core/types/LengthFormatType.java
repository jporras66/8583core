package com.indarsoft.iso8583core.types;
/**
 *  LengthFormatType
 *   
 *  <p>
 * 	0 - EBCDIC <br>
 * 	1 - ASCII <br>
 * 	2 - BINARY <br>			
 * 	
 */
public enum LengthFormatType {

	EBCDIC(0),  ASCII(1), BINARY(2) ;
    @SuppressWarnings("unused")
	private int value;

    private LengthFormatType (int value) {
            this.value = value;
    }
    
    public static  LengthFormatType getInstance (String value) {
    	if ( "EBCDIC".equals( value ) ) 	return LengthFormatType.EBCDIC ;
    	if ( "ASCII".equals( value ) ) 		return LengthFormatType.ASCII ;
    	if ( "BINARY".equals( value ) ) 	return LengthFormatType.BINARY ;
    	
    	return null ; 
    }
    
}
