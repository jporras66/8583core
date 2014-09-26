package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F023 - Application PAN sequence number.
 * 
 */
public class F023 extends TypeFixed {
	
	private F023 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F023 } 
	 */			
    protected static F023 get ( byte[] bytearr, Field field ){   	
    	return new F023 ( bytearr, field ) ;
    }
}