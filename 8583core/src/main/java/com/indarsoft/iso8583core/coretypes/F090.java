package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F090 - Original data elements.
 * 
 */
public class F090 extends TypeFixed {
	
	private F090 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F090 } 
	 */			
    protected static F090 get ( byte[] bytearr, Field field ){   	
    	return new F090 ( bytearr, field ) ;
    }
}