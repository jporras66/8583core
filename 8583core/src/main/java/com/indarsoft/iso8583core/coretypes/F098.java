package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F098 - Payee.
 * 
 */
public class F098 extends TypeFixed {
	
	private F098 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F098 } 
	 */			
    protected static F098 get ( byte[] bytearr, Field field ){   	
    	return new F098 ( bytearr, field ) ;
    }
}