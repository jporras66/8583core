package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F075 - Credits, reversal number.
 * 
 */
public class F075 extends TypeFixed {
	
	private F075 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F075 } 
	 */			
    protected static F075 get ( byte[] bytearr, Field field ){   	
    	return new F075 ( bytearr, field ) ;
    }
}