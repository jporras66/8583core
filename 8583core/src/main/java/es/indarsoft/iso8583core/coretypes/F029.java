package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F029 - Amount, settlement fee.
 * 
 */
public class F029 extends TypeFixed {
	
	private F029 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F029 } 
	 */			
    protected static F029 get ( byte[] bytearr, Field field ){   	
    	return new F029 ( bytearr, field ) ;
    }
}