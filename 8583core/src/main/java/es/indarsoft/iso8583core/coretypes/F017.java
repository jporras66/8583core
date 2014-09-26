package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F017 - Date, capture.
 * 
 */
public class F017 extends TypeFixed {
	
	private F017 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F017 } 
	 */			
    protected static F017 get ( byte[] bytearr, Field field ){   	
    	return new F017 ( bytearr, field ) ;
    }
}