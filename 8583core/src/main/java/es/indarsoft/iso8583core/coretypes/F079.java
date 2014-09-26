package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F079 - Transfer, reversal number.
 * 
 */
public class F079 extends TypeFixed {
	
	private F079 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F079 } 
	 */			
    protected static F079 get ( byte[] bytearr, Field field ){   	
    	return new F079 ( bytearr, field ) ;
    }
}