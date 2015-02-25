package com.indarsoft.iso8583core.codification;

import static org.junit.Assert.*;
import com.indarsoft.iso8583core.utl.Char;

import org.junit.Test;

public class CharTest {

	public String className = this.getClass().getSimpleName() + "." ;
	
	byte abyte 	= (byte) 0xC0;	// 	Ascii
	byte mbyte	= (byte) 0x41;  //	Ascii mapped
	byte ebyte  = (byte) 0x64;	//	EBCDIC mapped
	String htmlTag = "&Agrave;" ;
	String description = "Latin capital letter A with grave"; 
	char attribute = 'Z';
	Char ach = new Char( abyte ,  ebyte , mbyte , htmlTag ,  description ,  attribute );
	Char bch = new Char( abyte ,  ebyte , mbyte , htmlTag ,  description ,  attribute );
	
	@Test
	public void testEquals() {
		
		boolean bol = ach.equals(bch) ; 				
		if ( bol ){
			System.out.printf(className+"testEquals              : TRUE \n" );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testEquals              : FALSE \n" );
			assertFalse( true) ;
		}				
	}
	
	@Test
	public void testHashCode() {
		
		int hasha = ach.hashCode() ;
		int hashb = bch.hashCode() ;
		
		if ( hasha == hashb ){
			System.out.printf(className+"testHashCode            : TRUE \n" );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testHashCode            : FALSE \n" );
			assertFalse( true) ;
		}				
	}
	
	@Test
	public void testGetHexValue() {
		
		byte ahex = ach.getAsciihexValue() ;				
		if ( ahex == abyte ){
			System.out.printf(className+"testGetHexValue         : OK  ascii hex %X - %X \n" , ahex , abyte );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testGetHexValue         : KO  ascii hex %X - %X \n" , ahex , abyte );
			assertFalse( true) ;
		}				
	}

	@Test
	public void testGetmappedHexValue() {
		
		byte ahex = ach.getMappedHexValue() ;				
		if ( ahex == mbyte ){
			System.out.printf(className+"testGetmappedHexValue   : OK  mapped hex %X - %X \n" , ahex , mbyte );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testGetmappedHexValue   : KO  mapped hex %X - %X \n" , ahex , mbyte );
			assertFalse( true) ;
		}	
	}

	@Test
	public void testGetEbcdic() {

		byte ahex = ach.getEbcdichexValue() ;				
		if ( ahex == ebyte ){
			System.out.printf(className+"testGetEbcdic           : OK  ebcdic2ascii hex %X - %X \n" , ahex , ebyte );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testGetEbcdic           : KO  ebcdic2ascii hex %X - %X \n" , ahex , ebyte );
			assertFalse( true) ;
		}	
	}

	@Test
	public void testGetHtmlTag() {

		String str = ach.getHtmlTag() ;				
		if ( str == htmlTag ){
			System.out.printf(className+"testGetHtmlTag          : OK  htmltag %s - %s \n" , str , htmlTag );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testGetHtmlTag          : KO  htmltag %s - %s \n" , str , htmlTag );
			assertFalse( true) ;
		}	
		
	}

	@Test
	public void testGetDescription() {

		String str = ach.getDescription() ;				
		if ( str == description ){
			System.out.printf(className+"testGetDescription      : OK  Description : %s - %s \n" , str , description );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testGetDescription      : KO  Description : %s - %s \n" , str , description );
			assertFalse( true) ;
		}	
		
	}

	@Test
	public void testGetAttribute() {

		char ch = ach.getAttribute() ;				
		if ( ch == attribute ){
			System.out.printf(className+"testGetAttribute        : OK  attribute : %c - %c \n" , ch , attribute );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testGetAttribute        : KO  attribute : %c - %c \n" , ch , attribute );
			assertFalse( true) ;
		}
		
	}

}
