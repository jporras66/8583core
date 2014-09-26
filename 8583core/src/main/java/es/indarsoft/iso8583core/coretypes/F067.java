package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F067 - Extended payment code.
 * 
 */
public class F067 extends TypeFixed {
	
	private F067 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F067 } 
	 */			
    protected static F067 get ( byte[] bytearr, Field field ){   	
    	return new F067 ( bytearr, field ) ;
    }
}