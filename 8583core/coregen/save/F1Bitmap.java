package com.indarsoft.iso8583core.coretypes;

import com.indarsoft.utl.Binary;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.iso8583core.types.Field;

/**
 * 	BITMAP
 *	8 bytes array length
 *  
 *  The first bitmap
 *  The first and second bitmap
 *  The first, second, and third bitmap (when available)
 *  
 */
public class F1Bitmap extends TypeVar {

	private String 	bitmapStr ; 
	private Ordinal ordinal ; 
	
	private F1Bitmap (byte[] bytearr,  Ordinal ordinal, Field field) {
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
	 * @param 	byte[] bytearr (  coded data )
	 * @return	{@link F1Bitmap }
	 */			
    protected static F1Bitmap get ( byte[] bytearr, Ordinal ordinal, Field field ){
    	    	
    	return new F1Bitmap ( bytearr , ordinal , field ) ;
    }
	/**  Test if F1Bitmap contains field number 
	 * 
	 * 	@param 	int fieldNumber ( > 0 ).
	 * 	@return boolean
	 * 
	 */	
	public boolean hasFieldNumber ( int fieldNumber ){
		 
		char c = bitmapStr.charAt( fieldNumber - 1 ) ;
		if ( c == '1' ) return true ;
		return false ; 
	}
	/**  Test if F1Bitmap points to another F1Bitmap
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
