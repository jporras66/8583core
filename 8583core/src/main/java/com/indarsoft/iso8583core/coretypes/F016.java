package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F016 - Date, conversion.
 * 
 */
public class F016 extends TypeFixed {
	
	private F016 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F016 } 
	 */			
    protected static F016 get ( byte[] bytearr, Field field ){   	
    	return new F016 ( bytearr, field ) ;
    }
}