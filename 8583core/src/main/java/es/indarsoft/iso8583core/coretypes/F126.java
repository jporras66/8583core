package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F126 - Issuer trace id.
 * 
 */	
public class F126 extends TypeVar {

	private F126 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F126 } Issuer trace id
	 */			
    protected static F126 get ( byte[] bytearr, Field field ){
    	    	
    	return new F126 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F126 }
	 */    
    protected static F126 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F126 ( baro,  field ) ;
    }
	
}
