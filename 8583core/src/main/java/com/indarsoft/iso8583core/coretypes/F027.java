package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F027 - Authorizing identification response length.
 * 
 */
public class F027 extends TypeFixed {
	
	private F027 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F027 } 
	 */			
    protected static F027 get ( byte[] bytearr, Field field ){   	
    	return new F027 ( bytearr, field ) ;
    }
}