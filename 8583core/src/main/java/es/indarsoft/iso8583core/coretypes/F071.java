package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F071 - Message number.
 * 
 */
public class F071 extends TypeFixed {
	
	private F071 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F071 } 
	 */			
    protected static F071 get ( byte[] bytearr, Field field ){   	
    	return new F071 ( bytearr, field ) ;
    }
}