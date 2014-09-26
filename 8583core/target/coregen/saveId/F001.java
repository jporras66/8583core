package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.utl.Binary;
import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.types.Field;

/**
 * 	BITMAP
 *	8 bytes array length
 *  
 *  The first bitmap
 *  The first and second bitmap
 *  The first, second, and third bitmap (when available)
 *  
 */
public class F001 extends TypeVar {

	private String 	bitmapStr ; 
	private Ordinal ordinal ; 
	
	private F001 (byte[] bytearr,  Ordinal ordinal, Field field) {
//		
    	super( bytearr, field , false) ;  // do not validate data
    	this.ordinal = ordinal ; 
    	this.bitmapStr = Binary.toBitStr( bytearr ) ;
//    	
    	if ( ! super.isValid()  ){
    		return;
		}
	}
	
	/**   get static constructor
	 * 
	 * @param 	bytearr (  coded data )
	 * @return	{@link F001 }
	 */			
    protected static F001 get ( byte[] bytearr, Ordinal ordinal, Field field ){
    	    	
    	return new F001 ( bytearr , ordinal , field ) ;
    }
	/**  Test if F001 contains field number 
	 * 
	 * 	@param 	fieldNumber int ( > 0 ).
	 * 	@return boolean
	 * 
	 */	
	public boolean hasFieldNumber ( int fieldNumber ){
		 
		char c = bitmapStr.charAt( fieldNumber - 1 ) ;
		if ( c == '1' ) return true ;
		return false ; 
	}
	/**  Test if F001 points to another F001
	 * 
	 * 	@return boolean
	 * 
	 */	
	public boolean hasAnotherBitmap ( ){
		
		return hasFieldNumber( 1 ) ;
		
	}
	/**  returns bitmap as string
	 * 
	 * 	@return String
	 * 
	 */		
	public  String getBitmapStr (){
		return bitmapStr ;
	}
	
	public Ordinal getOrdinal() {
		return ordinal;
	}
	
	public int getFirstFiledId() {
		
		int firstId = 0;
		if ( ordinal == Ordinal.FIRST ) 	firstId = 2 ;
		else
		if ( ordinal == Ordinal.SECOND ) 	firstId = 66 ;
		else
		if ( ordinal == Ordinal.THIRD ) 	firstId = 130 ;
		return firstId ;
	}
	
	public int getLastFiledId() {
		
		int lastId = 0;
		if ( ordinal == Ordinal.FIRST ) 	lastId = 64 ;
		else
		if ( ordinal == Ordinal.SECOND ) 	lastId = 128 ;
		else
		if ( ordinal == Ordinal.THIRD ) 	lastId = 192 ;
		return lastId ;
	}
	
	
	public enum Ordinal {

			FIRST(1), SECOND(2), THIRD(3) ;
		    @SuppressWarnings("unused")
			private int value;

		    private Ordinal (int value) {
		            this.value = value;
		    }
		    
		    public static  Ordinal getInstance (String value) {
		    	if ( "FIRST".equals( value ) ) 	return Ordinal.FIRST ;
		    	if ( "SECOND".equals( value ) ) return Ordinal.SECOND ;
		    	if ( "THIRD".equals( value ) ) return Ordinal.THIRD ;		    	
		    	return null ; 
		    }
	}


}
