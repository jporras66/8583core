package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F101 - File name.
 * 
 */
public class F101 extends TypeFixed {
	
	private F101 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F101 } 
	 */			
    protected static F101 get ( byte[] bytearr, Field field ){   	
    	return new F101 ( bytearr, field ) ;
    }
}