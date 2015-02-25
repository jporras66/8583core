package com.indarsoft.iso8583core.primitives;

import static org.junit.Assert.*;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthFormatType;
import com.indarsoft.iso8583core.types.LengthType;
import com.indarsoft.iso8583core.types.TypeVar;
import com.indarsoft.iso8583core.utl.Charset;
import com.indarsoft.utl.Binary;





import org.junit.BeforeClass;
import org.junit.Test;

public class TypeVAsciiTest {
	
	public String className = this.getClass().getSimpleName() + "." ;
	public static Charset 		cs = Charset.getInstance() ; // singelton 
	public static TypeVar 		varascii 		= null ; 
	public static String 		asciistr 		= "611234567809ABCDEFGHIJKLMNOPQRSTUWXYZabcdegfhijklmnopqrstuvwxyz" ;
	public static byte[] 		ebcdicarrbyte 	= cs.ascii2ebcdic( asciistr ) ;
	public static String 		ebcdicstr 		= Binary.toPrintableString( ebcdicarrbyte ) ;
	public static byte[] 		asciiarrbyte 	= asciistr.getBytes() ;
	public static 	Field 		fieldAtr  	= null ;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		
	
		fieldAtr = new Field.Builder().
				id(					999					).
				lengthType(			LengthType.V 		).
				name(				"999"				).
				fieldFormat(		FieldFormatType.AN	).
				fieldLength(		0					).
				fieldCodification(	FieldCodificationType.ASCII ).
				lengthFormat(		LengthFormatType.ASCII	).
				lengthOfLengthField( 2		).
				minfieldLength(		 10		).
				maxfieldLength(		 98  	).build() ;
		
		varascii = new TypeVar ( asciiarrbyte , fieldAtr ) ;		 
	}


	@Test
	public void getByteArr() {
		
		byte [] bytearr = varascii.getBytearr() ;
		String result = Binary.toPrintableString( bytearr ) ;
		if ( result.equals(  asciistr  ) ){
			System.out.println( className + "getByteArr              : TRUE - " + result);
			assertTrue( true) ;
		}else{
			System.out.println(className + "getByteArr               : FALSE - "+ result);
			assertFalse( true) ;
		}	
	}
	
	@Test
	public void getCodificationType() {
		
		FieldCodificationType result = varascii.getFieldCodification() ;
		if ( result.equals(  FieldCodificationType.ASCII  ) ){
			System.out.println(className + "getCodificationType     : TRUE - " + result);
			assertTrue( true) ;
		}else{
			System.out.println(className + "getCodificationType     : FALSE - "+ result);
			assertFalse( true) ;
		}
	}
	
	@Test
	public void getDataStr () {
		
		String result = varascii.data2String();
		if ( result.equals( asciistr.substring( 2) )){
			System.out.println(className + "getDataStr              : TRUE - " + result );
			assertTrue( true) ;
		}else{
			System.out.println(className + "getDataStr              : FALSE - "+ result );
			assertFalse( true) ;
		}	
	}	
		
}
