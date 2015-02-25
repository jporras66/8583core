package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F022 - Point of service entry mode.
 * 
 */
public class F022 extends TypeFixed {
	
	private F022 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F022 } 
	 */			
    protected static F022 get ( byte[] bytearr, Field field ){   	
    	return new F022 ( bytearr, field ) ;
    }
}