package es.indarsoft.iso8583core.coretypesbcd;

import static org.junit.Assert.*;
import es.indarsoft.iso8583core.app.Application;
import es.indarsoft.iso8583core.app.ApplicationFactory;
import es.indarsoft.iso8583core.app.Config;
import es.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import es.indarsoft.iso8583core.coretypes.F035;
import es.indarsoft.utl.Binary;

import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class BcdTrack2LowerSeparatorTest {

	public String className = this.getClass().getSimpleName() + "." ;
	
	public String CONFIGFILE = "visasms.properties";
	public Config cfg = new Config( CONFIGFILE );	
	public Application  app	= ApplicationFactory.getApp( cfg ) ;
	CoreTypesFactory ctf = new CoreTypesFactory(app);
	
	public static byte[] 	track2arr 	= { (byte)0x0E, //length --> 14 bytes
											(byte)0x45, (byte)0x67, (byte)0x33, (byte) 0x66, 		// odd PAN 15 digits
											(byte)0x12, (byte)0x34, (byte)0x56, (byte) 0x7D, 		// separator D
											(byte)0x15, (byte)0x09, 								// expiration date
											(byte)0x20, (byte)0x19,									// serv code 201
											(byte)0x87, (byte)0x55 } ;								// cvv 987
	public static String 	track2str	= Binary.toHexStr( track2arr ) ;
	

	@Test
	public void testTrack2() {
		F035 track2 = ctf.getF035( track2arr ) ;
		String pan = track2.getPan() ;
		if ( pan.equals( "456733661234567")){
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
