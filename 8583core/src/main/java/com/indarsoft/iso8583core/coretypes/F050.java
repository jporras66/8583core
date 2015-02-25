package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F050 - Currency code, settlement.
 * 
 */
public class F050 extends TypeFixed {
	
	private F050 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F050 } 
	 */			
    protected static F050 get ( byte[] bytearr, Field field ){   	
    	return new F050 ( bytearr, field ) ;
    }
}