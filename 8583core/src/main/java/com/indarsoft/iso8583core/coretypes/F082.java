package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F082 - Credits, processing fee amount.
 * 
 */
public class F082 extends TypeFixed {
	
	private F082 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F082 } 
	 */			
    protected static F082 get ( byte[] bytearr, Field field ){   	
    	return new F082 ( bytearr, field ) ;
    }
}