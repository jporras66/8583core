package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F078 - Transfer number.
 * 
 */
public class F078 extends TypeFixed {
	
	private F078 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F078 } 
	 */			
    protected static F078 get ( byte[] bytearr, Field field ){   	
    	return new F078 ( bytearr, field ) ;
    }
}