package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F080 - Inquiries number.
 * 
 */
public class F080 extends TypeFixed {
	
	private F080 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F080 } 
	 */			
    protected static F080 get ( byte[] bytearr, Field field ){   	
    	return new F080 ( bytearr, field ) ;
    }
}