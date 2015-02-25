package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F052 - Personal identification number data.
 * 
 */
public class F052 extends TypeFixed {
	
	private F052 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F052 } 
	 */			
    protected static F052 get ( byte[] bytearr, Field field ){   	
    	return new F052 ( bytearr, field ) ;
    }
}