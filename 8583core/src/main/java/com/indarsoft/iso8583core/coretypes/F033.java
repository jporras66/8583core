package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F033 - Forwarding institution identification code.
 * 
 */	
public class F033 extends TypeVar {

	private F033 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F033 } Forwarding institution identification code
	 */			
    protected static F033 get ( byte[] bytearr, Field field ){
    	    	
    	return new F033 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F033 }
	 */    
    protected static F033 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F033 ( baro,  field ) ;
    }
	
}
