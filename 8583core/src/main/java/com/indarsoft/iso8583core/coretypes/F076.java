package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F076 - Debits, number.
 * 
 */
public class F076 extends TypeFixed {
	
	private F076 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F076 } 
	 */			
    protected static F076 get ( byte[] bytearr, Field field ){   	
    	return new F076 ( bytearr, field ) ;
    }
}