package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F014 - Date, expiration.
 * 
 */
public class F014 extends TypeFixed {
	
	private F014 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F014 } 
	 */			
    protected static F014 get ( byte[] bytearr, Field field ){   	
    	return new F014 ( bytearr, field ) ;
    }
}