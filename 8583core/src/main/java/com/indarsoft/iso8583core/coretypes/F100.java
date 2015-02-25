package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F100 - Receiving institution identification code.
 * 
 */	
public class F100 extends TypeVar {

	private F100 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F100 } Receiving institution identification code
	 */			
    protected static F100 get ( byte[] bytearr, Field field ){
    	    	
    	return new F100 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F100 }
	 */    
    protected static F100 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F100 ( baro,  field ) ;
    }
	
}
