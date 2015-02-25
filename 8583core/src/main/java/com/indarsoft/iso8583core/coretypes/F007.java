package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F007 - Transmission date time.
 * 
 */
public class F007 extends TypeFixed {
	
	private F007 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F007 } 
	 */			
    protected static F007 get ( byte[] bytearr, Field field ){   	
    	return new F007 ( bytearr, field ) ;
    }
}