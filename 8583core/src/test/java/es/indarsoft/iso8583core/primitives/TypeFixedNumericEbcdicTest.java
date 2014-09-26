package es.indarsoft.iso8583core.primitives;

import static org.junit.Assert.*;
import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.FieldCodificationType;
import es.indarsoft.iso8583core.types.FieldFormatType;
import es.indarsoft.iso8583core.types.LengthType;
import es.indarsoft.iso8583core.types.TypeFixed;

import org.junit.BeforeClass;
import org.junit.Test;

public class TypeFixedNumericEbcdicTest {

	public String 	className 	= this.getClass().getSimpleName() + "." ;
	public static 	TypeFixed 	fixed 		= null ; 
	public static 	byte[] 	 	bytearr 	= 	{ (byte)0xF0, (byte)0xF1, (byte)0xF2 } ;
	public static 	Field 		fieldAtr  	= null ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		fieldAtr = new Field.Builder().
				id(					999					).
				lengthType(			LengthType.F 		).
				name(				"999"				).
				fieldFormat(		FieldFormatType.NUMERIC	).
				fieldLength(		3		).
				fieldCodification(	FieldCodificationType.EBCDIC ).
				lengthFormat(		null	).
				lengthOfLengthField( 0 		).
				minfieldLength(		 0 		).
				maxfieldLength(		 0		).build() ;	
		
		fixed = new TypeFixed ( bytearr , fieldAtr ) ;
	}

	@Test
	public void getCodificationType() {
		
		FieldCodificationType result = fixed.getFieldCodification() ;
		if ( fixed.isValid()){
			if ( result.equals(  FieldCodificationType.EBCDIC  ) ){
				System.out.println(className + "getCodificationType  : TRUE - " + fixed.getFieldCodification() + " - " + fixed.getFieldFormat());
				assertTrue( true) ;
			}else{
				System.out.println(className + "getCodificationType  : FALSE - "+ fixed.getFieldCodification() + " - " + fixed.getFieldFormat());
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
			if ( result ==  3 ){
				System.out.println(className + "getDataLength        : TRUE - " + result);
				assertTrue( true) ;
			}else{
				System.out.println(className + "getDataLength        : FALSE - "+ result);
				assertFalse( true) ;
			}	
		}else{
			System.out.println(className + "getDataLength        : FALSE - "+ fixed.getStatusMsg() );
			assertFalse( true) ;
		}

	}
}
