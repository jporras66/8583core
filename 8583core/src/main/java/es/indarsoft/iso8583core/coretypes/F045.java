package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F045 - Track 1 data.
 * 
 */	
public class F045 extends TypeVar {

	private F045 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F045 } Track 1 data
	 */			
    protected static F045 get ( byte[] bytearr, Field field ){
    	    	
    	return new F045 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F045 }
	 */    
    protected static F045 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F045 ( baro,  field ) ;
    }
	
}
