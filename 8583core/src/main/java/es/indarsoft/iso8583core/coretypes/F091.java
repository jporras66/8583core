package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F091 - File update code.
 * 
 */
public class F091 extends TypeFixed {
	
	private F091 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F091 } 
	 */			
    protected static F091 get ( byte[] bytearr, Field field ){   	
    	return new F091 ( bytearr, field ) ;
    }
}