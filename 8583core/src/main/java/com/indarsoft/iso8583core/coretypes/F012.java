package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F012 - Time, local transaction.
 * 
 */
public class F012 extends TypeFixed {
	
	private F012 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F012 } 
	 */			
    protected static F012 get ( byte[] bytearr, Field field ){   	
    	return new F012 ( bytearr, field ) ;
    }
}