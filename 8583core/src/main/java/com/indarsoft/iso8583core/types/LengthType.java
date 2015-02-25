package com.indarsoft.iso8583core.types;

/**
 * 	LengthType
 * 
 *  <p>
 * 	0 - F	Fixed Length data field <br>
 * 	1 - V	Variable Length data field  <br>	
 * 	
 */
public enum LengthType {


	F(0), V(1) ;
    @SuppressWarnings("unused")
	private int value;

    private LengthType (int value) {
            this.value = value;
    }
    
    public static  LengthType getInstance (String value) {
    	if ( "F".equals( value ) ) 	return LengthType.F ;
    	if ( "V".equals( value ) ) 	return LengthType.V ;
    	
    	return null ; 
    }
}
