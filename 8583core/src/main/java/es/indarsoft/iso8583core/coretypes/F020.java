package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F020 - PAN extended, country code.
 * 
 */
public class F020 extends TypeFixed {
	
	private F020 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F020 } 
	 */			
    protected static F020 get ( byte[] bytearr, Field field ){   	
    	return new F020 ( bytearr, field ) ;
    }
}