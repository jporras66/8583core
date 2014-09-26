package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F015 - Date, settlement.
 * 
 */
public class F015 extends TypeFixed {
	
	private F015 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F015 } 
	 */			
    protected static F015 get ( byte[] bytearr, Field field ){   	
    	return new F015 ( bytearr, field ) ;
    }
}