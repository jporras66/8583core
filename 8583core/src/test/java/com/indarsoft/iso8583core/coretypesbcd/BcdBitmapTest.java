package com.indarsoft.iso8583core.coretypesbcd;

import static org.junit.Assert.*;
import com.indarsoft.utl.Binary;

import org.junit.Test;

import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import com.indarsoft.iso8583core.coretypes.F001;

public class BcdBitmapTest {

	public String className = this.getClass().getSimpleName() + "." ;
	
	public String CONFIGFILE = "visasms.properties";
	public Config cfg = new Config( CONFIGFILE );	
	public Application  app	= ApplicationFactory.getApp( cfg ) ;
	CoreTypesFactory ctf = new CoreTypesFactory(app);
	
	public static byte[] bytearr = { (byte)0xA3, (byte) 0x86, 0x4D, 0x12, (byte) 0x8E, (byte)  0x09, (byte) 0x81, 0x61 } ;
	
	@Test
	public void isValid() {
		byte[] 	bitmaparr 	= bytearr; 
		String	bitmapstr 	= Binary.toHexStr( bitmaparr ) ;
		F001 bitmap 		= ctf.getF001( bitmaparr , F001.Ordinal.FIRST ) ;
		
		if ( bitmap.isValid() ){
			String result = bitmap.toString() ;
			if ( result.equals(  bitmapstr  ) ){
				System.out.println( className + "isValid       : TRUE - " + result);
				assertTrue( true) ;
			}else{
				System.out.println( className +  "isValid      : FALSE - "+ result);
				assertFalse( true) ;
			}
		}else{
			System.out.println( className + "isValid      : FALSE - " + bitmap.getStatusMsg() );
			assertFalse( true) ;
		}
	}

	@Test
	public void getBitmapStr() {
		byte[] 	bitmaparr 	= bytearr; 
		String	bitmapstr 	= "1010001110000110010011010001001010001110000010011000000101100001";
		F001 bitmap 		= ctf.getF001( bitmaparr, F001.Ordinal.FIRST ) ;
		if ( bitmap.getBitmapStr().equals( bitmapstr) ){
			String result = bitmap.getBitmapStr();
			if ( result.equals(  bitmapstr  ) ){
				System.out.println( className +  "getBitmapStr  : TRUE - " + result);
				assertTrue( true) ;
			}else{
				System.out.println( className +  "getBitmapStr  : FALSE - "+ result);
				assertFalse( true) ;
			}
		}else{
			System.out.println(className +  "getBitmapStr  : FALSE - " + bitmap.getStatusMsg() );
			assertFalse( true) ;
		}
	}
	@Test
	public void getSecondBitmapStr() {
		byte[] bytearr = { 	(byte)0xA3, (byte) 0x86, 0x4D, 0x12, (byte) 0x8E, (byte)  0x09, (byte) 0x81, 0x61, 
							(byte)0x23, (byte) 0x86, 0x4D, 0x12, (byte) 0x8E, (byte)  0x09, (byte) 0x81, 0x61 } ;
		byte[] 	bitmaparr 	= bytearr; 
		String	bitmapstr 	= "1010001110000110010011010001001010001110000010011000000101100001";
		String  secondStr   = "0010001110000110010011010001001010001110000010011000000101100001";
		String  str = bitmapstr + secondStr ;
		F001 bitmap 		= ctf.getF001( bitmaparr, F001.Ordinal.SECOND ) ;
		if ( bitmap.getBitmapStr().equals( str) ){
			String result = bitmap.getBitmapStr();
			if ( result.equals(  str  ) ){
				System.out.println( className +  "getSecondBitmapStr  : TRUE - " + result);
				assertTrue( true) ;
			}else{
				System.out.println( className +  "getSecondBitmapStr  : FALSE - "+ result);
				assertFalse( true) ;
			}
		}else{
			System.out.println(className +  "getBitmapStr  : FALSE - " + bitmap.getStatusMsg() );
			assertFalse( true) ;
		}
	}
	
	@Test
	public void hasFieldNumber() {
		byte[] 	bitmaparr = bytearr; 
		F001 bitmap 		= ctf.getF001( bitmaparr, F001.Ordinal.FIRST ) ;
		int fieldnumber = 3 ; 
		if ( bitmap.hasFieldNumber(fieldnumber) ){
			if ( bitmap.hasFieldNumber( fieldnumber )){
				System.out.println(className +  "hasFieldNumber: TRUE - fieldnumber : " + fieldnumber + " - "+ bitmap.toString() );
				assertTrue( true) ;
			}else{
				System.out.println(className +  "hasFieldNumber: FALSE - fieldnumber : " + fieldnumber + " - "+ bitmap.toString() );
				assertFalse( true) ;
			}
		}else{
			System.out.println(className +  "hasFieldNumber : FALSE - " + bitmap.getStatusMsg() );
			assertFalse( true) ;
		}
	}
}
