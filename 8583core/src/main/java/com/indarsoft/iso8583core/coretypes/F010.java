package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F010 - Conversion rate, cardholder billing.
 * 
 */
public class F010 extends TypeFixed {
	
	private F010 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F010 } 
	 */			
    protected static F010 get ( byte[] bytearr, Field field ){   	
    	return new F010 ( bytearr, field ) ;
    }
}