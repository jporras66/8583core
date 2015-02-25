package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F065 - Bit Map, Extended.
 * 
 */
public class F065 extends TypeFixed {
	
	private F065 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F065 } 
	 */			
    protected static F065 get ( byte[] bytearr, Field field ){   	
    	return new F065 ( bytearr, field ) ;
    }
}