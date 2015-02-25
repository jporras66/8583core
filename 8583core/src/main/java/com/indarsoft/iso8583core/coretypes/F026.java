package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F026 - Point of service capture code.
 * 
 */
public class F026 extends TypeFixed {
	
	private F026 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F026 } 
	 */			
    protected static F026 get ( byte[] bytearr, Field field ){   	
    	return new F026 ( bytearr, field ) ;
    }
}