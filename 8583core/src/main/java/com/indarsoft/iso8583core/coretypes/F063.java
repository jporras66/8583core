package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F063 - Reserved private.
 * 
 */	
public class F063 extends TypeVar {

	private F063 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F063 } Reserved private
	 */			
    protected static F063 get ( byte[] bytearr, Field field ){
    	    	
    	return new F063 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F063 }
	 */    
    protected static F063 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F063 ( baro,  field ) ;
    }
	
}
