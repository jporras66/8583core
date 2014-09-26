package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F008 - Amount, cardholder billing fee.
 * 
 */
public class F008 extends TypeFixed {
	
	private F008 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F008 } 
	 */			
    protected static F008 get ( byte[] bytearr, Field field ){   	
    	return new F008 ( bytearr, field ) ;
    }
}