package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F086 - Credits, amount.
 * 
 */
public class F086 extends TypeFixed {
	
	private F086 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F086 } 
	 */			
    protected static F086 get ( byte[] bytearr, Field field ){   	
    	return new F086 ( bytearr, field ) ;
    }
}