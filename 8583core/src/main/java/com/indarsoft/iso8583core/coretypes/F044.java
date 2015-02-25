package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F044 - Additional response data.
 * 
 */	
public class F044 extends TypeVar {

	private F044 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F044 } Additional response data
	 */			
    protected static F044 get ( byte[] bytearr, Field field ){
    	    	
    	return new F044 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F044 }
	 */    
    protected static F044 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F044 ( baro,  field ) ;
    }
	
}
