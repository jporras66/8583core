package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F066 - Settlement code.
 * 
 */
public class F066 extends TypeFixed {
	
	private F066 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F066 } 
	 */			
    protected static F066 get ( byte[] bytearr, Field field ){   	
    	return new F066 ( bytearr, field ) ;
    }
}