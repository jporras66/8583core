package com.indarsoft.iso8583core.coretypes;

import static org.junit.Assert.*;

import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import com.indarsoft.iso8583core.coretypes.F035;

import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class EbcdicTrack2SeparatorTest {

	public String className = this.getClass().getSimpleName() + "." ;
	
	public String CONFIGFILE = "main.properties";
	public Config cfg = new Config( CONFIGFILE );
	public Application  app	= ApplicationFactory.getMain( cfg) ;
	CoreTypesFactory ctf = new CoreTypesFactory(app);
	
	public static byte[] 	track2arr 	= { (byte)0xF2, (byte)0xF9 ,							//length --> 29 bytes
											(byte)0xF4, (byte)0xF5, (byte)0xF6, (byte)0xF7, 	// pan	
											(byte)0xF3, (byte)0xF3, (byte)0xF6, (byte)0xF6,
											(byte)0xF1, (byte)0xF2, (byte)0xF3, (byte)0xF4, 	
											(byte)0xF5, (byte)0xF6, (byte)0xF7,
											(byte)0x0D,											// separator D
											(byte)0xF1, (byte)0xF5, (byte)0xF0, (byte)0xF9,  	// expiration date
											(byte)0xF2, (byte)0xF0, (byte)0xF1,					// serv code 201
											(byte)0xF9,	(byte)0xF8, (byte)0xF7,					// cvv 987				
											(byte)0xF5, (byte)0xF5 } ;								

	@Test
	public void testTrack2() {
		F035 track2 = ctf.getF035( track2arr ) ;
		String pan = track2.getPan();
		if ( pan.equals( "456733661234567")){
			System.out.println( className + "track2       : TRUE    - " + pan);
			System.out.println( className + "track2       : expdate   " + track2.getExpirationDate() ) ;
			System.out.println( className + "track2       : servcode  " + track2.getServiceCode() ) ;
			System.out.println( className + "track2       : discdata  " + track2.getDiscretionaryData() ) ;
			System.out.println( className + "track2       : all       " + track2.getTrack2() ) ;
			assertTrue( true) ;
		}else{ 
			System.out.println( className +  "track2      : FALSE - "+ pan);
			assertFalse( true) ;	
		}	
	}

}
