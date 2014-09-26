package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F018 - Merchant type.
 * 
 */
public class F018 extends TypeFixed {
	
	private F018 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F018 } 
	 */			
    protected static F018 get ( byte[] bytearr, Field field ){   	
    	return new F018 ( bytearr, field ) ;
    }
}