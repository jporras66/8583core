package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F040 - Service restriction code.
 * 
 */
public class F040 extends TypeFixed {
	
	private F040 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F040 } 
	 */			
    protected static F040 get ( byte[] bytearr, Field field ){   	
    	return new F040 ( bytearr, field ) ;
    }
}