package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F025 - Point of service condition code.
 * 
 */
public class F025 extends TypeFixed {
	
	private F025 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F025 } 
	 */			
    protected static F025 get ( byte[] bytearr, Field field ){   	
    	return new F025 ( bytearr, field ) ;
    }
}