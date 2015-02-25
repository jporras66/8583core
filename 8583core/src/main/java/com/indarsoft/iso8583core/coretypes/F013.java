package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F013 - Date, local transaction.
 * 
 */
public class F013 extends TypeFixed {
	
	private F013 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F013 } 
	 */			
    protected static F013 get ( byte[] bytearr, Field field ){   	
    	return new F013 ( bytearr, field ) ;
    }
}