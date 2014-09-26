package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F068 - Receiving institution country code.
 * 
 */
public class F068 extends TypeFixed {
	
	private F068 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F068 } 
	 */			
    protected static F068 get ( byte[] bytearr, Field field ){   	
    	return new F068 ( bytearr, field ) ;
    }
}