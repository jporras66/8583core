package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F028 - Amount, transaction fee.
 * 
 */
public class F028 extends TypeFixed {
	
	private F028 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F028 } 
	 */			
    protected static F028 get ( byte[] bytearr, Field field ){   	
    	return new F028 ( bytearr, field ) ;
    }
}