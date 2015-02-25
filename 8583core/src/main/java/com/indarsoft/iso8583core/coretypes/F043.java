package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F043 - Card acceptor name location.
 * 
 */
public class F043 extends TypeFixed {
	
	private F043 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F043 } 
	 */			
    protected static F043 get ( byte[] bytearr, Field field ){   	
    	return new F043 ( bytearr, field ) ;
    }
}