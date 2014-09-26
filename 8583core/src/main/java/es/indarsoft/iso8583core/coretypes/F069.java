package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F069 - Settlement institution country code.
 * 
 */
public class F069 extends TypeFixed {
	
	private F069 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F069 } 
	 */			
    protected static F069 get ( byte[] bytearr, Field field ){   	
    	return new F069 ( bytearr, field ) ;
    }
}