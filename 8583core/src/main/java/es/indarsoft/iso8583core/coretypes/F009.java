package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F009 - Conversion rate, settlement.
 * 
 */
public class F009 extends TypeFixed {
	
	private F009 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F009 } 
	 */			
    protected static F009 get ( byte[] bytearr, Field field ){   	
    	return new F009 ( bytearr, field ) ;
    }
}