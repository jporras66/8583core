package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F083 - Credits, transaction fee amount.
 * 
 */
public class F083 extends TypeFixed {
	
	private F083 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F083 } 
	 */			
    protected static F083 get ( byte[] bytearr, Field field ){   	
    	return new F083 ( bytearr, field ) ;
    }
}