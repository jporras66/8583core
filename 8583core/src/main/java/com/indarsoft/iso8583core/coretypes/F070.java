package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F070 - Network management information code.
 * 
 */
public class F070 extends TypeFixed {
	
	private F070 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F070 } 
	 */			
    protected static F070 get ( byte[] bytearr, Field field ){   	
    	return new F070 ( bytearr, field ) ;
    }
}