package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F088 - Debits, amount.
 * 
 */
public class F088 extends TypeFixed {
	
	private F088 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F088 } 
	 */			
    protected static F088 get ( byte[] bytearr, Field field ){   	
    	return new F088 ( bytearr, field ) ;
    }
}