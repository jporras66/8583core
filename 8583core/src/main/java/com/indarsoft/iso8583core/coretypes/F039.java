package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F039 - Response code.
 * 
 */
public class F039 extends TypeFixed {
	
	private F039 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F039 } 
	 */			
    protected static F039 get ( byte[] bytearr, Field field ){   	
    	return new F039 ( bytearr, field ) ;
    }
}