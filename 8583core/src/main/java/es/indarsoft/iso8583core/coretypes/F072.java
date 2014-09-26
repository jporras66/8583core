package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.utl.Common;

/** Application : ISO8583CORE  - Class F072 - Data record.
 * 
 */	
public class F072 extends TypeVar {

	private F072 (byte[] bytearr , Field field) {
		
    	super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return ;
    	}
	}
	/** Static constructor .
	 * 
	 * @param 	bytearr ( full array :  coded length + coded data ).
	 * @return	{@link F072 } Data record
	 */			
    protected static F072 get ( byte[] bytearr, Field field ){
    	    	
    	return new F072 ( bytearr, field ) ;
    }
    
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * 			It calculates array length and adds to array data
	 * @return	{@link F072 }
	 */    
    protected static F072 getIn ( byte[] bytearr, Field field  ){
    	
    	byte[] baro = Common.addLength( bytearr, field ) ;
    	return new F072 ( baro,  field ) ;
    }
	
}
