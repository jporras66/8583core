package com.indarsoft.iso8583core.coretypesbcd;

import static org.junit.Assert.*;
import com.indarsoft.utl.Binary;
import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import com.indarsoft.iso8583core.coretypes.F000;

import org.junit.Test;

public class BcdF0Mti {

	public String className = this.getClass().getSimpleName() + "." ;
	
	public static F000 	mti   = null ;
	public static F000		mtinv = null ;
	public static byte[] 	mtiarr 			= { 0x02, 0x00 } ;
	public static byte[] 	mtiarrnv 		= { 0x35, 0x00 } ;	
	public static String	mtivaluestr 	= Binary.toHexStr( mtiarr ) ;
	public static String	mtivaluestrnv 	= Binary.toHexStr( mtiarrnv ) ;
	
	public String CONFIGFILE = "visasms.properties";
	public Config cfg = new Config( CONFIGFILE );	
	public Application  app	= ApplicationFactory.getApp( cfg ) ;
	CoreTypesFactory ctf = new CoreTypesFactory(app);
	
	@Test
	public void isValid() {
		
		mti 	= ctf.getF000( mtiarr ) ;
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
		
		mtinv 	= ctf.getF000( mtiarrnv ) ;
		
		if ( ! mtinv.isValid() ){
			System.out.println(className+"isNotValid : TRUE - "  + mtivaluestrnv );
			assertTrue( true) ;
		}else{
			System.out.println(className+"isNotValid : FALSE - " + mtivaluestrnv );
			assertFalse( true) ;
		}

		
	}	

}
