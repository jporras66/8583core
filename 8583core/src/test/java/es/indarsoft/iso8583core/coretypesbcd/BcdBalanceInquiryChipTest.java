package es.indarsoft.iso8583core.coretypesbcd;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;

import es.indarsoft.iso8583core.app.*;
import es.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import es.indarsoft.iso8583core.message.IsoMessage;
import es.indarsoft.iso8583core.message.IsoMsgFactory;
import es.indarsoft.utl.Binary;
import es.indarsoft.utl.Utl;


@SuppressWarnings("unused")
public class BcdBalanceInquiryChipTest {

	static Logger 	log = Logger.getLogger( BcdBalanceInquiryChipTest.class.getName() );
	String sep = File.separator;
	String pwd = Utl.getPwd() ;
	
	public static CoreTypesFactory 	ctf 		= null ;
	public static Application  app		= null ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		String CONFIGFILE = "visasms.properties";
		Config cfg = new Config( CONFIGFILE );
		app	= ApplicationFactory.getApp( cfg ) ;
		AppBean appdata = app.getAppBean() ;
		if ( appdata.getAppName().equals("VISASMS") ) {
			 ctf = new CoreTypesFactory( app );
			 System.out.println("setUpBeforeClass  : TRUE  - " + appdata.getAppName() ) ; 
		}else{
			 System.out.println("setUpBeforeClass  : FALSE - " + appdata.getAppName() ) ;
		}		
	}
	
	@Test
	public void request() {
		
		String filename = Utl.getPwd()+ sep+"data"+ sep + "balance_inquiry_chip_request.hex";
		log.debug( "Start Processing : " + filename) ;
//		
		byte bar[] = Utl.loadBinary( filename ) ;
		System.out.println( "array is  : " + Binary.toHexStr( bar  ) );
		log.debug( "End Processing : " + filename) ;
//
		IsoMessage msg = IsoMsgFactory.get( bar, app );
		assertTrue( true) ;
	}

	/*@Test
	public void response() {
		
		String filename = Utl.getPwd()+ sep+"data"+ sep + "balance_inquiry_chip_response.hex";
		log.debug( "Start Processing : " + filename) ;
//		
		byte bar[] = Utl.loadBinary( filename ) ;
		System.out.println( "array is  : " + Binary.toHexStr( bar  ) );
		log.debug( "End Processing : " + filename) ;
//
		Message msg = MsgFactory.get( bar, app );
	}*/

}
