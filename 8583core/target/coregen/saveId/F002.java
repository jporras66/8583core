package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.utl.Common;

/**
 * 	FIELD F002. 
 * 	
 */

public class F002 extends TypeVar {

	private F002 (byte[] bytearr , Field field ) {
		
    	super( bytearr, field ) ;
		
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor.
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F002 }
	 */			
    protected static F002 get ( byte[] bytearr, Field field ){
    	    	
    	return new F002 ( bytearr , field) ;
    }
    
	/** Static constructor.
	 * 
	 * @param 	bytearr  ( has only coded data )
	 * 			It calculates array length and adds to array data
	 * @return	{@link F002 }
	 */    
    protected static F002 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F002 ( baro , field) ;
    }
	
}
