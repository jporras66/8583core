package com.indarsoft.iso8583core.primitives;

import static org.junit.Assert.*;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthType;
import com.indarsoft.iso8583core.types.TypeFixed;

import org.junit.BeforeClass;
import org.junit.Test;

public class TypeFixedAnAsciiTest {

	public String 	className 	= this.getClass().getSimpleName() + "." ;
	public static 	TypeFixed 	fixed 		= null ; 
	public static 	byte[] 	 	bytearr 	= 	{ (byte)0x30, (byte)0x31, (byte)0x32, (byte) 0x33, (byte) 0x41  } ;
	public static 	Field 		fieldAtr  	= null ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//
		fieldAtr = new Field.Builder().
				id(					999					).
				lengthType(			LengthType.F 		).
				name(				"999"				).
				fieldFormat(		FieldFormatType.AN	).
				fieldLength(		5					).
				fieldCodification(	FieldCodificationType.ASCII ).
				lengthFormat(		null	).
				lengthOfLengthField( 0 		).
				minfieldLength(		 0 		).
				maxfieldLength(		 0		).build() ;
//		
		fixed = new TypeFixed ( bytearr , fieldAtr ) ;
	}

	@Test
	public void getCodificationType() {
		
		
		if ( fixed.isValid()){
			FieldCodificationType result = fixed.getFieldCodification() ;
			if ( result.equals(  FieldCodificationType.ASCII  ) ){
				System.out.println(className + "getCodificationType  : TRUE - " + fixed.getFieldCodification() + " - " + fixed.getFieldFormat() ) ; 
				assertTrue( true) ;
			}else{
				System.out.println(className + "getCodificationType  : FALSE - "+ fixed.getFieldCodification() + " - " + fixed.getFieldFormat() ) ;
				assertFalse( true) ;
			}
		}else{
			System.out.println(className + "getCodificationType  : FALSE - "+ fixed.getStatusMsg() );
			assertFalse( true) ;
		}

	}

	@Test
	public void getDataLength () {
		
		int result = fixed.getDataLength() ;
		if ( fixed.isValid()){
			if ( result ==  5 ){
				System.out.println(className + "getDataLength        : TRUE - " + result);
				assertTrue( true) ;
			}else{
				System.out.println(className + "getDataLength        : FALSE - "+ result);
				assertFalse( true) ;
			}	
		}else{
			System.out.println(className + "getDataLength         : FALSE - "+ fixed.getStatusMsg() );
			assertFalse( true) ;
		}

	}
}
