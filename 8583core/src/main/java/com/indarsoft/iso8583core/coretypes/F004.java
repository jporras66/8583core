package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F004 - Amount, transaction.
 * 
 */
public class F004 extends TypeFixed {
	
	private F004 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F004 } 
	 */			
    protected static F004 get ( byte[] bytearr, Field field ){   	
    	return new F004 ( bytearr, field ) ;
    }
}