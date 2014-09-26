package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F093 - Response indicator.
 * 
 */
public class F093 extends TypeFixed {
	
	private F093 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F093 } 
	 */			
    protected static F093 get ( byte[] bytearr, Field field ){   	
    	return new F093 ( bytearr, field ) ;
    }
}