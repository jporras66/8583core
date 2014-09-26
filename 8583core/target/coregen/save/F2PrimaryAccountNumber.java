package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.utl.Common;

/**
 * 	FIELD F2PrimaryAccountNumber. 
 * 	
 */

public class F2PrimaryAccountNumber extends TypeVar {

	private F2PrimaryAccountNumber (byte[] bytearr , Field field ) {
		
    	super( bytearr, field ) ;
		
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor.
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F2PrimaryAccountNumber }
	 */			
    protected static F2PrimaryAccountNumber get ( byte[] bytearr, Field field ){
    	    	
    	return new F2PrimaryAccountNumber ( bytearr , field) ;
    }
    
	/** Static constructor.
	 * 
	 * @param 	bytearr  ( has only coded data )
	 * 			It calculates array length and adds to array data
	 * @return	{@link F2PrimaryAccountNumber }
	 */    
    protected static F2PrimaryAccountNumber getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F2PrimaryAccountNumber ( baro , field) ;
    }
	
}
