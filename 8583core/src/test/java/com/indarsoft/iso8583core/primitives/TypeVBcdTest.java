package com.indarsoft.iso8583core.primitives;

import static org.junit.Assert.*;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthFormatType;
import com.indarsoft.iso8583core.types.LengthType;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.utl.Binary;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * 2.2.8 Padding Unused Positions  (Visa SMS Tech Spec vol 1 - page 48)
 * 
 * The following conventions apply to fixed-length fields when the data entered does not fill
 * the field:
 * 
 *   If the field is numeric, left zero-fill is required.
 *   If the field is not numeric, right space-fill is required.
 *   Odd-length numeric values, in both fixed and variable-length fields, must contain a leading
 *   
 *   zero. There is, however, one exception to this rule: the coding in FixedField 22�POS Entry
 *   Mode Code has a trailing rather than a leading zero.
 * 
 */
public class TypeVBcdTest {

	public String className = this.getClass().getSimpleName() + "." ;
	public static TypeVar 		varbcd	 	= null ; 
	public static byte[] 		bcdarrbyte 	= 	{ 0x13, 0x01, 0x23, 0x45, 0x67, (byte) 0x89, 0x01, 0x23, 0x45, 0x67, (byte) 0x89 } ;
	public static String 		bcdstring	=   Binary.toHexStr( bcdarrbyte ) ; 
	public static 	Field 		fieldAtr  	= null ;
	
	@BeforeClass
	public static void setUpBeforeClass() {
				
		fieldAtr = new Field.Builder().
				id(					999					).
				lengthType(			LengthType.V 		).
				name(				"999"				).
				fieldFormat(		FieldFormatType.NUMERIC	).
				fieldLength(		0					).
				fieldCodification(	FieldCodificationType.BCD ).
				lengthFormat(		LengthFormatType.BINARY	).
				lengthOfLengthField( 1		).
				minfieldLength(		 10		).
				maxfieldLength(		 98  	).build() ;
		
		varbcd = new TypeVar ( bcdarrbyte , fieldAtr ) ;		 
	}

	@Test
	public void getByteArr() {
		
		byte [] bytearr = varbcd.getBytearr() ;
		String result = Binary.toHexStr( bytearr ) ;
		if ( result.equals(  bcdstring  ) ){
			System.out.println( className + "getByteArr              : TRUE - " + result);
			assertTrue( true) ;
		}else{
			System.out.println(className + "getByteArr               : FALSE - "+ result);
			assertFalse( true) ;
		}	
	}
	
	@Test
	public void getFieldFormatType() {
		
		FieldFormatType result = varbcd.getFieldFormat() ;
		if ( result.equals(  FieldFormatType.NUMERIC  ) ){
			System.out.println(className + "getFieldFormatType : TRUE - " + result);
			assertTrue( true) ;
		}else{
			System.out.println(className + "getFieldFormatType : FALSE - "+ result);
			assertFalse( true) ;
		}
	}
	
	@Test
	public void getLengthFormatType() {
		
		LengthFormatType result = varbcd.getLengthFormat() ;
		if ( result.equals(  LengthFormatType.BINARY   ) ){
			System.out.println(className + "getLengthFormatType     : TRUE - " + result);
			assertTrue( true) ;
		}else{
			System.out.println(className + "getLengthFormatType     : FALSE - "+ result);
			assertFalse( true) ;
		}
	}
	
	@Test
	public void data2String () {
		
		String result = varbcd.data2String();
		String data   = bcdstring.substring( 2) ;
		if ( result.equals( data  ) ){
			System.out.println(className + "data2String              : TRUE - " + result );
			assertTrue( true) ;
		}else{
			System.out.println(className + "data2String              : FALSE - "+ result );
			assertFalse( true) ;
		}	
	}	
	

}
