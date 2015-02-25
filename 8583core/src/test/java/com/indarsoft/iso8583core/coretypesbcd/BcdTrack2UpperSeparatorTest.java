package com.indarsoft.iso8583core.coretypesbcd;

import static org.junit.Assert.*;
import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import com.indarsoft.iso8583core.coretypes.F035;
import com.indarsoft.utl.Binary;

import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class BcdTrack2UpperSeparatorTest {

	public String className = this.getClass().getSimpleName() + "." ;
	
	public String CONFIGFILE = "visasms.properties";
	public Config cfg = new Config( CONFIGFILE );	
	public Application  app	= ApplicationFactory.getApp( cfg ) ;
	CoreTypesFactory ctf = new CoreTypesFactory(app);
	
	public static byte[] 	track2arr 	= { (byte)0x11, 										// length --> 16 bytes
											(byte)0x45, (byte)0x67, (byte)0x33, (byte)0x66, 	// odd PAN 12 digits
											(byte)0x12, (byte)0x34,	(byte)0xD1,					// separator D
											(byte)0x51, (byte)0x11, (byte)0x01,					// exp date 1511 , service code 101
											(byte)0x38, (byte)0x88, (byte)0x81,					// dki 3  pvv 8888
											(byte)0x23, (byte)0x00, (byte)0x00 } ;				// cvv 987													
																							
	public static String 	track2str	= Binary.toHexStr( track2arr ) ;
	

	@Test
	public void testTrack2() {
		F035 track2 = ctf.getF035( track2arr ) ;
		String pan = track2.getPan() ;
		if ( pan.equals( "456733661234")){
			System.out.println( className + "track2       : TRUE    - " + pan);
			System.out.println( className + "track2       : expdate   " + track2.getExpirationDate() ) ;
			System.out.println( className + "track2       : servcode  " + track2.getServiceCode() ) ;
			System.out.println( className + "track2       : discdata  " + track2.getDiscretionaryData() ) ;
			System.out.println( className + "track2       : all       " + track2.getTrack2() ) ;
			assertTrue( true) ;
		}else{ 
			System.out.println( className +  "testPan      : FALSE - "+ pan);
			assertFalse( true) ;	
		}	
	}

}
