package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F085 - Debits, transaction fee amount.
 * 
 */
public class F085 extends TypeFixed {
	
	private F085 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F085 } 
	 */			
    protected static F085 get ( byte[] bytearr, Field field ){   	
    	return new F085 ( bytearr, field ) ;
    }
}