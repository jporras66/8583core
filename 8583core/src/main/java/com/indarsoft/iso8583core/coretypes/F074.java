package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F074 - Credits, number.
 * 
 */
public class F074 extends TypeFixed {
	
	private F074 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F074 } 
	 */			
    protected static F074 get ( byte[] bytearr, Field field ){   	
    	return new F074 ( bytearr, field ) ;
    }
}