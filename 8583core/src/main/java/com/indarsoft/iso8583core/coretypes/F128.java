package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F128 - Message authentication code.
 * 
 */
public class F128 extends TypeFixed {
	
	private F128 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F128 } 
	 */			
    protected static F128 get ( byte[] bytearr, Field field ){   	
    	return new F128 ( bytearr, field ) ;
    }
}