package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F041 - Card acceptor terminal identification.
 * 
 */
public class F041 extends TypeFixed {
	
	private F041 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F041 } 
	 */			
    protected static F041 get ( byte[] bytearr, Field field ){   	
    	return new F041 ( bytearr, field ) ;
    }
}