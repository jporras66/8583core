package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F099 - Settlement institution identification code       .
 * 
 */	
public class F099 extends TypeVar {

	private F099 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F099 } Settlement institution identification code       
	 */			
    protected static F099 get ( byte[] bytearr, Field field ){
    	    	
    	return new F099 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F099 }
	 */    
    protected static F099 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F099 ( baro,  field ) ;
    }
	
}
