package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F021 - Forwarding institution country code.
 * 
 */
public class F021 extends TypeFixed {
	
	private F021 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F021 } 
	 */			
    protected static F021 get ( byte[] bytearr, Field field ){   	
    	return new F021 ( bytearr, field ) ;
    }
}