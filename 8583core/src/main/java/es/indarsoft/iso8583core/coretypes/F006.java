package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F006 - Amount, cardholder billing.
 * 
 */
public class F006 extends TypeFixed {
	
	private F006 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F006 } 
	 */			
    protected static F006 get ( byte[] bytearr, Field field ){   	
    	return new F006 ( bytearr, field ) ;
    }
}