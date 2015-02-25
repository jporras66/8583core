package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F094 - Service indicator.
 * 
 */
public class F094 extends TypeFixed {
	
	private F094 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F094 } 
	 */			
    protected static F094 get ( byte[] bytearr, Field field ){   	
    	return new F094 ( bytearr, field ) ;
    }
}