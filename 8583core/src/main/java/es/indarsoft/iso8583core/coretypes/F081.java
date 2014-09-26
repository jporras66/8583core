package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.TypeFixed;

/** Application : ISO8583CORE  - Class F081 - Authorizations, number.
 * 
 */
public class F081 extends TypeFixed {
	
	private F081 (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;
    	if ( ! super.isValid() ){
    		return;
		}		
	}	
	
	/** Static constructor .
	 * 
	 * @param 	bytearr
	 * @return	{@link F081 } 
	 */			
    protected static F081 get ( byte[] bytearr, Field field ){   	
    	return new F081 ( bytearr, field ) ;
    }
}