package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F097 - Amount, net settlement.
 * 
 */
public class F097 extends TypeFixed {
	
	private F097 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F097 } 
	 */			
    protected static F097 get ( byte[] bytearr, Field field ){   	
    	return new F097 ( bytearr, field ) ;
    }
}