package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F011 - System trace audit number.
 * 
 */
public class F011 extends TypeFixed {
	
	private F011 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F011 } 
	 */			
    protected static F011 get ( byte[] bytearr, Field field ){   	
    	return new F011 ( bytearr, field ) ;
    }
}