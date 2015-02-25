package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F024 - Network International identifier.
 * 
 */
public class F024 extends TypeFixed {
	
	private F024 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F024 } 
	 */			
    protected static F024 get ( byte[] bytearr, Field field ){   	
    	return new F024 ( bytearr, field ) ;
    }
}