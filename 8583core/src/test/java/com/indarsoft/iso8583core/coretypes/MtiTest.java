package com.indarsoft.iso8583core.coretypes;

import static org.junit.Assert.*;

import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import com.indarsoft.iso8583core.coretypes.F000;

import org.junit.Test;

public class MtiTest {

	public String className = this.getClass().getSimpleName() + "." ;
	
	public String CONFIGFILE = "main.properties";
	public Config cfg = new Config( CONFIGFILE );
	public Application  app	= ApplicationFactory.getMain( cfg) ;
	CoreTypesFactory ctf = new CoreTypesFactory(app);
	
	public static byte[] 	mtiarr 			= { (byte)0xF0, (byte)0xF2, (byte)0xF0, (byte)0xF0 } ;
	public static byte[] 	mtiarrnv 		= { (byte)0xF9, (byte)0xF9, (byte)0xF0, (byte)0xF0 } ;	
	public static String	mtivaluestr 	= "0200" ;
	public static String	mtivaluestrnv 	= "9900" ;
//	
	@Test
	public void isValid() {
		

		F000 mti 	= ctf.getF000( mtiarr  ) ;
		String result = mti.toString() ;
		if ( result.equals(  mtivaluestr  ) ){
			System.out.println(className+"isValid    : TRUE - " + result);
			assertTrue( true) ;
		}else{
			System.out.println(className+"isValid    : FALSE - "+ result);
			assertFalse( true) ;
		}
	}
	
	@Test
	public void isNotValid() {
		
		F000 mtinv 	= ctf.getF000( mtiarrnv ) ;
		
		if ( ! mtinv.isValid() ){
			System.out.println(className+"isNotValid : TRUE - "  + mtivaluestrnv + " - "+ mtinv.getStatusMsg());
			assertTrue( true) ;
		}else{
			System.out.println(className+"isNotValid : FALSE - " + mtivaluestrnv + " - "+ mtinv.getStatusMsg() );
			assertFalse( true) ;
		}

		
	}	

}
