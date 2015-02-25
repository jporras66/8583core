package com.indarsoft.iso8583core.utl;

import com.indarsoft.utl.Ascii;
import com.indarsoft.utl.Binary;
import com.indarsoft.utl.Ebcdic;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthFormatType;
/**
 * Some common utilities.
 * 
 * @author fjavier.porras@gmail.com
 *
 */
public class Common {

	/**
	 * Validates if the input byte array has a valid codification for a given field.
	 * <p>
	 * - For the field FieldFormat : <br>
	 * - NUMERIC :	Checks if is BCD or NUMERIC coded (ASCII or EBCDIC) depending on FieldCodificationType <br>
	 * - AN, ANS :  Checks if is AN, ANS and is coded as FieldFormatType indicates (ASCII or EBCDIC) <br>
	 * - BINARY  :  For BINARY always returns TRUE.<br>
	 * @param bar
	 * 			input byte array
	 * @param field
	 * 			input {@link Field}
	 * @return boolean
	 */
	public static boolean hasvalidCodification ( byte[]  bar , Field field  ) {
		
		Charset charset = Charset.getInstance();
		if ( field.getFieldFormat() == FieldFormatType.NUMERIC ){
			if ( field.getFieldCodification() == FieldCodificationType.BCD) {
				return  charset.isBcd( bar );
			}else{
				return charset.isNumeric( bar, field.getFieldCodification() ) ;
			}	
		}else
		if ( field.getFieldFormat() == FieldFormatType.AN ){
			return charset.isAn( bar, field.getFieldCodification() ) ;
		}else
		if ( field.getFieldFormat() == FieldFormatType.ANS ){
			return  charset.isAns( bar, field.getFieldCodification() ) ;
		}else
		if ( field.getFieldFormat() == FieldFormatType.BINARY ){
			return true ;
		}
		
		return false ;
	}
	
	/**
	 * Validates if the input byte array has a valid length format for a given field.
	 * <p>
	 * - For the field LengthFormat: <br>
	 * - ASCII, EBCDIC : checks if is properly coded <br>
	 * - BINARY  :  For BINARY always returns TRUE.  <br>
	 * @param bar
	 * 			input byte array is the field length (does not contains all field data only his length)
	 * @param field
	 * 			input {@link Field}
	 * @return boolean
	 */
	public static boolean hasvalidLengthFormat ( byte[]  bar, Field field ) {
		
		if ( (field.getLengthFormat() == LengthFormatType.EBCDIC) || (field.getLengthFormat() == LengthFormatType.ASCII) )  {
			Charset charset = Charset.getInstance();
			return charset.isNumeric( bar, field.getLengthFormat() ) ;
		}else
		if ( field.getLengthFormat() == LengthFormatType.BINARY ){
			return true;
		}
		return false ;
	}
	
	/**
	 * Returns an String representation of the input byte array according to the field Codification. 
	 * If the field codification is not found , raises an IllegalArgumentException.
	 * <p>
	 * @param bytearr
	 * 			input byte array 
	 * @param field
	 * 			input {@link Field}
	 * @return an string
	 * @throws IllegalArgumentException
	 */
	public static String toString ( byte[] bytearr, Field field ) throws IllegalArgumentException { 

		FieldFormatType fieldFormatType 			=  field.getFieldFormat() ;
		FieldCodificationType fieldCodification 	=  field.getFieldCodification() ;
		FieldCodificationType datacodificationType 	= field.getFieldCodification()  ;
		
		if ( (fieldCodification == FieldCodificationType.BCD) || (fieldFormatType == FieldFormatType.BINARY) )
			 return Binary.toHexStr(  bytearr ) ;

		if ( datacodificationType == FieldCodificationType.EBCDIC  ){
			 Charset charset = Charset.getInstance();
			 byte[] asciibyteArr = charset.ebcdic2ascii( bytearr ) ;
			 return Binary.toPrintableString ( asciibyteArr ) ; 
		}
		
		if ( datacodificationType == FieldCodificationType.ASCII  )
			 return Binary.toPrintableString ( bytearr ) ; 
		//
		throw new IllegalArgumentException("toString");
	}
	
	/**
	 * Returns an integer (as int) representation of the input byte array according to the field Codification. 
	 * If the field codification is not found , raises an IllegalArgumentException.
	 * <p>
	 * @param bar
	 * 			input byte array is the field length (does not contains all field data only his length) 
	 * @param field
	 * 			input {@link Field}
	 * @return integer field length
	 * @throws IllegalArgumentException
	 */
	public static int computeFieldLength(  byte[] bar , Field field ) throws IllegalArgumentException {
	
		LengthFormatType lft = field.getLengthFormat() ;
		if ( lft.equals( LengthFormatType.BINARY ) ) return Binary.toInt( bar );	
		if ( lft.equals( LengthFormatType.EBCDIC ) ) return Ebcdic.toInt( bar) ;
		if ( lft.equals( LengthFormatType.ASCII ) )  return Ascii.toInt( bar) ;

		throw new IllegalArgumentException("computeFieldLength");
	}	
	
	/**
	 * Adds the length (properly codified) for an input byte array according to a field length format.
	 * If field length format is not found , raises an IllegalArgumentException.
	 * <p>
	 * @param bytearr
	 * 			input byte array is the field data (does not contains his length) 
	 * @param field
	 * 			input {@link Field}
	 * @return codified field length + input field data
	 * @throws IllegalArgumentException
	 */
	public static byte[] addLength ( byte[] bytearr , Field field ){
		 
	    	byte[] barl = null ; 
	    	int datalength = bytearr.length ;;
	    	if ( field.getLengthFormat() == LengthFormatType.BINARY ){ 
	    		barl = Binary.int2byteArray( datalength );

	    	}else
	    	if (field.getLengthFormat() == LengthFormatType.EBCDIC){
	    		barl = Ebcdic.int2byteArray( datalength );
	    	}else
	    	if 	(field.getLengthFormat() == LengthFormatType.ASCII){
	    		barl = Ascii.int2byteArray( datalength );
	    	}else{
	    		throw new IllegalArgumentException("addLength");
	    	}

	    	int fieldlength = field.getFieldLength();
	    	byte[] baro = new byte[ fieldlength + datalength ];
	    	int pointer = 0 ;
	    	for (int i=0; i < fieldlength ; i++){
	    		baro[i] = barl[fieldlength - i - 1 ];
	    		pointer = i ; 
	    	}
	    	for (int i=0; i < datalength ; i++){
	    		baro[pointer + i + 1] = bytearr[i];
	    	}
	    	
	    	return baro;
	 }
}
