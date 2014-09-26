package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F061 - Reserved private.
 * 
 */	
public class F061 extends TypeVar {

	private F061 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F061 } Reserved private
	 */			
    protected static F061 get ( byte[] bytearr, Field field ){
    	    	
    	return new F061 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F061 }
	 */    
    protected static F061 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F061 ( baro,  field ) ;
    }
	
}
