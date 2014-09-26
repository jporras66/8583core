package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.codification.types.Field;

/**
 * 	Service Code
 *	8 bytes array length
 *  
 *  The first bitmap
 *  The first and second bitmap
 *  The first, second, and third bitmap (when available)
 *  
 */
@SuppressWarnings("unused")
public class ServiceCode {

	private String 	className = this.getClass().getSimpleName() + "." ;	
	private byte[] 	bytearr;				
	private boolean isvalid = true ;
	private String  msg ; 
	
	/**  Service Code
	 * 
	 * @param byte[] bytearr
	 * @param {@link Field }  field
	 * 
	 */		
	private ServiceCode (byte[] bytearr ) {
	
		this.bytearr = bytearr ;

	}

}
