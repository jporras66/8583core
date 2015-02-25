package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F042 - Card acceptor identification code.
 * 
 */
public class F042 extends TypeFixed {
	
	private F042 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F042 } 
	 */			
    protected static F042 get ( byte[] bytearr, Field field ){   	
    	return new F042 ( bytearr, field ) ;
    }
}