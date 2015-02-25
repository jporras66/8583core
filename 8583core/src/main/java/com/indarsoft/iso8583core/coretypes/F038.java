package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F038 - Authorization identification response.
 * 
 */
public class F038 extends TypeFixed {
	
	private F038 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F038 } 
	 */			
    protected static F038 get ( byte[] bytearr, Field field ){   	
    	return new F038 ( bytearr, field ) ;
    }
}