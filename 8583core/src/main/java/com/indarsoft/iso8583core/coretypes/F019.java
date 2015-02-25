package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F019 - Acquiring institution country code.
 * 
 */
public class F019 extends TypeFixed {
	
	private F019 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F019 } 
	 */			
    protected static F019 get ( byte[] bytearr, Field field ){   	
    	return new F019 ( bytearr, field ) ;
    }
}