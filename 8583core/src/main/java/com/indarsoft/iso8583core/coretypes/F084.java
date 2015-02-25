package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F084 - Debits, processing fee amount.
 * 
 */
public class F084 extends TypeFixed {
	
	private F084 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F084 } 
	 */			
    protected static F084 get ( byte[] bytearr, Field field ){   	
    	return new F084 ( bytearr, field ) ;
    }
}