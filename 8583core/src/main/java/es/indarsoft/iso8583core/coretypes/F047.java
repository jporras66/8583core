package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F047 - Additional data national.
 * 
 */	
public class F047 extends TypeVar {

	private F047 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F047 } Additional data national
	 */			
    protected static F047 get ( byte[] bytearr, Field field ){
    	    	
    	return new F047 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F047 }
	 */    
    protected static F047 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F047 ( baro,  field ) ;
    }
	
}
