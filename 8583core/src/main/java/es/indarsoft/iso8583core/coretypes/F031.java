package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F031 - Amount, settlement processing fee.
 * 
 */
public class F031 extends TypeFixed {
	
	private F031 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F031 } 
	 */			
    protected static F031 get ( byte[] bytearr, Field field ){   	
    	return new F031 ( bytearr, field ) ;
    }
}