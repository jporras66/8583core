package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F037 - Retrieval reference number.
 * 
 */
public class F037 extends TypeFixed {
	
	private F037 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F037 } 
	 */			
    protected static F037 get ( byte[] bytearr, Field field ){   	
    	return new F037 ( bytearr, field ) ;
    }
}