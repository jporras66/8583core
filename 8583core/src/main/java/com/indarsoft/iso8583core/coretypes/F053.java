package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F053 - Security related control information.
 * 
 */
public class F053 extends TypeFixed {
	
	private F053 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F053 } 
	 */			
    protected static F053 get ( byte[] bytearr, Field field ){   	
    	return new F053 ( bytearr, field ) ;
    }
}