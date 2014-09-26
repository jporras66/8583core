package es.indarsoft.iso8583core.primitives;

import static org.junit.Assert.*;
import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.FieldCodificationType;
import es.indarsoft.iso8583core.types.FieldFormatType;
import es.indarsoft.iso8583core.types.LengthType;
import es.indarsoft.iso8583core.types.TypeFixed;

import org.junit.BeforeClass;
import org.junit.Test;

public class TypeFixedBcdTest {

	public String 	className 	= this.getClass().getSimpleName() + "." ;
	public static 	TypeFixed 	bcdfix 		= null ; 
	public static 	byte[] 	 	bytearr 	= 	{ (byte)0x03, (byte)0x31, (byte)0x32   } ;
	public static 	Field 		fieldAtr  	= null ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		fieldAtr = new Field.Builder().
				id(					999					).
				lengthType(			LengthType.F 		).
				name(				"999"				).
				fieldFormat(		FieldFormatType.NUMERIC	).
				fieldLength(		5					).
				fieldCodification(	FieldCodificationType.BCD ).
				lengthFormat(		null ).
				lengthOfLengthField( 0 		).
				minfieldLength(		 0 		).
				maxfieldLength(		 0		).build() ;
		
		bcdfix = new TypeFixed ( bytearr , fieldAtr ) ;
	}

	@Test
	public void getCodificationType() {
		
		
		if ( bcdfix.isValid()  ){
			FieldFormatType result = bcdfix.getFieldFormat() ;
			if ( result.equals(  FieldFormatType.NUMERIC  ) ){
				System.out.println(className + "getCodificationType  : TRUE - " + bcdfix.getFieldCodification() + " - " + bcdfix.getFieldFormat() ) ;
				assertTrue( true) ;
			}else{
				System.out.println(className + "getCodificationType  : FALSE - "+  bcdfix.getFieldCodification() + " - " + bcdfix.getFieldFormat() ) ;
				assertFalse( true) ;
			}
		}else{
			System.out.println(className + "getCodificationType  : FALSE - "+ bcdfix.getStatusMsg() );
			assertFalse( true) ;
		}

	}

	@Test
	public void getDataLength () {
		
		int result = bcdfix.getDataLength() ;
		if ( bcdfix.isValid()){
			if ( result ==  bytearr.length  ){
				System.out.println(className + "getDataLength        : TRUE - " + bcdfix.getFieldFormat() ) ;
				assertTrue( true) ;
			}else{
				System.out.println(className + "getDataLength        : FALSE - " + bcdfix.getFieldFormat() ) ;
				assertFalse( true) ;
			}	
		}else{
			System.out.println(className + "getDataLength        : FALSE - "+ bcdfix.getStatusMsg() );
			assertFalse( true) ;
		}

	}
}
