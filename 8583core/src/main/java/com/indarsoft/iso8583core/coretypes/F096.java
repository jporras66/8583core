package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F096 - Message security code.
 * 
 */
public class F096 extends TypeFixed {
	
	private F096 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F096 } 
	 */			
    protected static F096 get ( byte[] bytearr, Field field ){   	
    	return new F096 ( bytearr, field ) ;
    }
}