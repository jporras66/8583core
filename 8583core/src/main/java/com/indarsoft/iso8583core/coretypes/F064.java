package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F064 - Message authentication code.
 * 
 */
public class F064 extends TypeFixed {
	
	private F064 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F064 } 
	 */			
    protected static F064 get ( byte[] bytearr, Field field ){   	
    	return new F064 ( bytearr, field ) ;
    }
}