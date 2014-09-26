package es.indarsoft.iso8583core.codification;

import static org.junit.Assert.*;
import java.io.File;
import es.indarsoft.iso8583core.types.FieldCodificationType;
import es.indarsoft.iso8583core.utl.Char;
import es.indarsoft.iso8583core.utl.Charset;
import es.indarsoft.utl.Binary;

import org.junit.Test;

public class CharsetTest {

	public String className = this.getClass().getSimpleName() + "." ;
	public String sep = File.separator;
	public Charset      charset  = Charset.getInstance();
//	
	public byte abyte 	= (byte) 0xC0;	// 	Ascii
	public byte mbyte	= (byte) 0x41;  //	Ascii mapped
	public byte ebyte  	= (byte) 0x64;	//	EBCDIC mapped
	public String htmlTag 				= "&Agrave;" ;
	public String description 			= "Latin capital letter A with grave";
	public char attribute 				= '-';
//
	public static String 	asciiStr 		=  "01234567809ABCDEFGHIJKLMNOPQRSTUWXYZabcdegfhijklmnopqrstuvwxyz" ;
	public byte[] 			ebcdicbyteArr 	=  charset.ascii2ebcdic( asciiStr ) ;
	public String 			ebcdicStr 		=  Binary.toPrintableString( ebcdicbyteArr ) ;
	public static byte[] 	asciibyteArr= asciiStr.getBytes() ;
	public static FieldCodificationType codificationType 		= FieldCodificationType.ASCII ;	
//	
	
	@Test
	public void asciiByteArray2ebcdic() {

		byte[] abta = asciiStr.getBytes() ;
		byte[] aebta = charset.ascii2ebcdic( abta ) ;
			
		if ( aebta.length == 62 ){
			System.out.printf(className+"asciiByteArray2ebcdic       : OK  length - ascii  is %d %s \n" , abta.length, abta );
			System.out.printf(className+"asciiByteArray2ebcdic       : OK  length - ebcidc is %d %s \n" , aebta.length, aebta );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testAsciiByteArray2ebcdic   : KO  length - ascii  is %d %s \n" , abta.length, abta );
			System.out.printf(className+"testAsciiByteArray2ebcdic   : KO  length - ebcidc is %d %s \n" , aebta.length, aebta );
			assertFalse( true) ;
		}	
	}

	@Test
	public void asciiString2ebcdic() {

		byte[] aebta = charset.ascii2ebcdic( asciiStr ) ;
			
		if ( aebta.length == 62 ){
			System.out.printf(className+"asciiString2ebcdic          : OK  length - ascii  is %d %s \n" , asciiStr.length(), asciiStr );
			System.out.printf(className+"asciiString2ebcdic          : OK  length - ebcidc is %d %s \n" , aebta.length, aebta );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"asciiString2ebcdic          : KO  length - ascii  is %d %s \n" , asciiStr.length(), asciiStr );
			System.out.printf(className+"asciiString2ebcdic          : KO  length - ebcidc is %d %s \n" , aebta.length, aebta );
			assertFalse( true) ;
		}		
	}

	@Test
	public void ebcdic2ascii() {

		byte[] abta = asciiStr.getBytes() ;
		byte[] aebta = charset.ascii2ebcdic( abta ) ;
		byte[] acta  = charset.ebcdic2ascii( aebta ) ;
		String asciiStr2 = new String( acta ) ;
		
		if ( aebta.length == 62 ){
			System.out.printf(className+"ebcdic2ascii                : OK  length - ascii  is %d %s \n" , asciiStr.length(), asciiStr );
			System.out.printf(className+"ebcdic2ascii                : OK  length - ebcidc is %d %s \n" , aebta.length, aebta );
			System.out.printf(className+"ebcdic2ascii                : OK  length - ascii  is %d %s \n" , asciiStr2.length(), asciiStr2 );			
			assertTrue( true) ;
		}else{
			System.out.printf(className+"ebcdic2ascii                : KO  length - ascii  is %d %s \n" , asciiStr.length(), asciiStr );
			System.out.printf(className+"ebcdic2ascii                : KO  length - ebcidc is %d %s \n" , aebta.length, aebta );
			System.out.printf(className+"ebcdic2ascii                : OK  length - ascii  is %d %s \n" , asciiStr2.length(), asciiStr2 );		
			assertFalse( true) ;
		}	
		
		
	}

	@Test
	public void getCharTypeItem() {

		Char ach = new Char( abyte, ebyte, mbyte, htmlTag, description, attribute ) ;
		int i = (int) abyte & 0xff ;
		Char bch  = charset.getCharArc(i);
		
		if ( bch.equals(ach) ){
			System.out.printf(className+"getCharTypeItem             : OK  object hashCode is %d - %d \n" , ach.hashCode() , bch.hashCode() );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"getCharTypeItem             : KO  object hashCode is %d - %d \n" , ach.hashCode() , bch.hashCode() );
			assertFalse( true) ;
		}
	}

	
	@Test
	public void isAns() {
		
		boolean bol 	= charset.isAns( ebcdicbyteArr  ) ;
		if ( bol ){
			System.out.println(className+"isAns                       : TRUE " + asciiStr);
			assertTrue( true) ;
		}else{
			System.out.println(className+"isAns                       : FALSE " + asciiStr);
			assertFalse( true) ;
		}	
	}
	
	@Test
	public void isAnsAscii() {
		
		boolean bol 	= charset.isAns( asciibyteArr , FieldCodificationType.ASCII ) ;
		if ( bol ){
			System.out.println(className+"isAnsAscii                  : TRUE " + asciiStr);
			assertTrue( true) ;
		}else{
			System.out.println(className+"isAnsAscii                  : FALSE " + asciiStr);
			assertFalse( true) ;
		}	
	} 	
	@Test
	public void isNotAlpha() {
		
		boolean bol 	= charset.isAlpha( ebcdicbyteArr ) ;
		if ( ! bol ){
			System.out.println(className+"isNotAlpha                  : TRUE " + asciiStr);
			assertTrue( true) ;
		}else{
			System.out.println(className+"isNotAlpha                  : FALSE " + asciiStr);
			assertFalse( true) ;
		}	
	}	

	@Test	
	public void isNotAlphaAscii() {
		
		boolean bol 	= charset.isAlpha( asciibyteArr , FieldCodificationType.ASCII) ;
		if ( ! bol ){
			System.out.println(className+"isNotAlphaAscii             : TRUE " + asciiStr);
			assertTrue( true) ;
		}else{
			System.out.println(className+"isNotAlphaAscii             : FALSE " + asciiStr);
			assertFalse( true) ;
		}	
	}	
	
	@Test
	public void isNotNumeric() {
		
		boolean bol 	= charset.isNumeric(  ebcdicbyteArr ) ;
		if ( ! bol ){
			System.out.println(className+"isNotNumeric                : TRUE " + asciiStr);
			assertTrue( true) ;
		}else{
			System.out.println(className+"isNotNumeric                : FALSE " + asciiStr);
			assertFalse( true) ;
		}	
	}		
	
	@Test
	public void isNotNumericAscii() {
		
		boolean bol 	= charset.isNumeric(  asciibyteArr ,  FieldCodificationType.ASCII) ;
		if ( ! bol ){
			System.out.println(className+"isNotNumericAscii           : TRUE " + asciiStr);
			assertTrue( true) ;
		}else{
			System.out.println(className+"isNotNumericAscii           : FALSE " + asciiStr);
			assertFalse( true) ;
		}	
	}	
	
}
