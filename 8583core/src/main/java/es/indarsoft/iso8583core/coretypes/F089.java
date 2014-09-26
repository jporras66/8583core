package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F089 - Debits, reversal amount.
 * 
 */
public class F089 extends TypeFixed {
	
	private F089 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F089 } 
	 */			
    protected static F089 get ( byte[] bytearr, Field field ){   	
    	return new F089 ( bytearr, field ) ;
    }
}