package com.indarsoft.iso8583core.primitives;

import static org.junit.Assert.*;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthType;
import com.indarsoft.iso8583core.types.TypeFixed;

import org.junit.BeforeClass;
import org.junit.Test;

public class TypeFixedBinaryTest {

	public String 	className 	= this.getClass().getSimpleName() + "." ;
	public static 	TypeFixed 	binaryfix 		= null ; 
	public static 	byte[] 	 	bytearr 	= 	{ (byte)0xFF, (byte)0xFF, (byte)0xFE   } ;
	public static 	Field 		fieldAtr  	= null ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		fieldAtr = new Field.Builder().
				id(					999					).
				lengthType(			LengthType.F 		).
				name(				"999"				).
				fieldFormat(		FieldFormatType.BINARY	).
				fieldLength(		bytearr.length		).
				fieldCodification(	FieldCodificationType.EBCDIC ).
				lengthFormat(		null	).
				lengthOfLengthField( 0 		).
				minfieldLength(		 0 		).
				maxfieldLength(		 0		).build() ;	
		
		binaryfix = new TypeFixed ( bytearr , fieldAtr ) ;
	}

	@Test
	public void getCodificationType() {
		
		
		if ( binaryfix.isValid()  ){
			FieldFormatType result = binaryfix.getFieldFormat() ;
			if ( result.equals(  FieldFormatType.BINARY  ) ){
				System.out.println(className + "getCodificationType  : TRUE - " + binaryfix.getFieldCodification() + " - " + binaryfix.getFieldFormat() ) ;
				assertTrue( true) ;
			}else{
				System.out.println(className + "getCodificationType  : FALSE - "+ binaryfix.getFieldCodification() + " - " + binaryfix.getFieldFormat() ) ;
				assertFalse( true) ;
			}
		}else{
			System.out.println(className + "getCodificationType  : FALSE - "+ binaryfix.getStatusMsg() );
			assertFalse( true) ;
		}

	}

	@Test
	public void getDataLength () {
		
		int result = binaryfix.getDataLength() ;
		if ( binaryfix.isValid()){
			if ( result ==  bytearr.length ){
				System.out.println(className + "getDataLength        : TRUE - " + result);
				assertTrue( true) ;
			}else{
				System.out.println(className + "getDataLength        : FALSE - "+ result);
				assertFalse( true) ;
			}	
		}else{
			System.out.println(className + "getDataLength        : FALSE - "+ binaryfix.getStatusMsg() );
			assertFalse( true) ;
		}

	}
}
