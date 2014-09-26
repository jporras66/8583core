package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F087 - Credits, reversal amount.
 * 
 */
public class F087 extends TypeFixed {
	
	private F087 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F087 } 
	 */			
    protected static F087 get ( byte[] bytearr, Field field ){   	
    	return new F087 ( bytearr, field ) ;
    }
}