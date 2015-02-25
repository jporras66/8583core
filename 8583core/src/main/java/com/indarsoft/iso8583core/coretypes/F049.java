package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F049 - Currency code, transaction.
 * 
 */
public class F049 extends TypeFixed {
	
	private F049 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F049 } 
	 */			
    protected static F049 get ( byte[] bytearr, Field field ){   	
    	return new F049 ( bytearr, field ) ;
    }
}