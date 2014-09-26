package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F005 - Amount, settlement.
 * 
 */
public class F005 extends TypeFixed {
	
	private F005 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F005 } 
	 */			
    protected static F005 get ( byte[] bytearr, Field field ){   	
    	return new F005 ( bytearr, field ) ;
    }
}