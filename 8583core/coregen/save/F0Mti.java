package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.types.TypeFixed;
import es.indarsoft.iso8583core.types.Field;

public class F0Mti extends TypeFixed {

	
	private static String[] messageCodes = { 	"0200", "0210", "0220", "0230",
												"0420", "0430", "0422", "0432",
												} ;	
	private F0Mti (byte[] bytearr, Field field) {
		
		super( bytearr, field ) ;	
    	if ( ! super.isValid() ){
    		return;
		}		
    	if ( ! isValid() ){
    		super.setIsvalid( false );
    		super.setStatusMsg(  super.className + "validate. Invalid message type ");
    		return;
		}		
	}	
	
	/**   get static constructor
	 * 
	 * @param 	bytearr (  coded data )
	 * @return	{@link F0Mti }
	 */			
    protected static F0Mti get ( byte[] bytearr, Field field ){
    	    	
    	return new F0Mti ( bytearr , field ) ;
    }
    
    public boolean isValid(){
    	
    	for (int i=0; i<messageCodes.length; i++ ){
    		if (  messageCodes[i].equals( super.toString()) ) return true ;
    	}
    	return false ;
    }
    
}