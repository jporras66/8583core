package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F092 - File security code.
 * 
 */
public class F092 extends TypeFixed {
	
	private F092 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F092 } 
	 */			
    protected static F092 get ( byte[] bytearr, Field field ){   	
    	return new F092 ( bytearr, field ) ;
    }
}