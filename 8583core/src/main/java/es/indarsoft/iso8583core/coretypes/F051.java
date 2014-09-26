package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F051 - Currency code, cardholder billing.
 * 
 */
public class F051 extends TypeFixed {
	
	private F051 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F051 } 
	 */			
    protected static F051 get ( byte[] bytearr, Field field ){   	
    	return new F051 ( bytearr, field ) ;
    }
}