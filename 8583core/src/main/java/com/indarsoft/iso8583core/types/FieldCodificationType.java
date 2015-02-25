package com.indarsoft.iso8583core.types;
/**
 *  FieldCodificationType
 *  
 *  <p>
 * 	0 - EBCDIC 	<br>
 * 	1 - ASCII  	<br>
 * 	2 - BCD		<br>
 * 	
 */
public enum FieldCodificationType {

	EBCDIC(0), ASCII(1), BCD(2) ;
    @SuppressWarnings("unused")
	private int value;

    private FieldCodificationType (int value) {
            this.value = value;
    }	
    
    public static  FieldCodificationType getInstance (String value) {
    	if ( "EBCDIC".equals( value ) ) 	return FieldCodificationType.EBCDIC ;
    	if ( "BCD".equals( value ) ) 		return FieldCodificationType.BCD ;
    	if ( "ASCII".equals( value ) ) 		return FieldCodificationType.ASCII ;
    	
    	return null ; 
    }
}
