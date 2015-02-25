package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F073 - Date, action.
 * 
 */
public class F073 extends TypeFixed {
	
	private F073 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F073 } 
	 */			
    protected static F073 get ( byte[] bytearr, Field field ){   	
    	return new F073 ( bytearr, field ) ;
    }
}