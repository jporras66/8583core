package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F077 - Debits, reversal number.
 * 
 */
public class F077 extends TypeFixed {
	
	private F077 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F077 } 
	 */			
    protected static F077 get ( byte[] bytearr, Field field ){   	
    	return new F077 ( bytearr, field ) ;
    }
}