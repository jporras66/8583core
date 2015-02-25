package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F095 - Replacement amounts.
 * 
 */
public class F095 extends TypeFixed {
	
	private F095 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F095 } 
	 */			
    protected static F095 get ( byte[] bytearr, Field field ){   	
    	return new F095 ( bytearr, field ) ;
    }
}