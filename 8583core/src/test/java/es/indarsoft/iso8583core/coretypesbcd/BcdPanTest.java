package es.indarsoft.iso8583core.coretypesbcd;

import static org.junit.Assert.*;
import es.indarsoft.iso8583core.app.Application;
import es.indarsoft.iso8583core.app.ApplicationFactory;
import es.indarsoft.iso8583core.app.Config;
import es.indarsoft.iso8583core.coretypes.CoreTypesFactory;
import es.indarsoft.iso8583core.coretypes.F002;
import es.indarsoft.utl.Binary;

import org.junit.Test;

public class BcdPanTest {

	public String className = this.getClass().getSimpleName() + "." ;
	
	public String CONFIGFILE = "visasms.properties";
	public Config cfg = new Config( CONFIGFILE );	
	public Application  app	= ApplicationFactory.getApp( cfg ) ;
	CoreTypesFactory ctf = new CoreTypesFactory(app);
	
	@Test
	public void Isvalid() {
		byte[] 	panarr 		= { 0x13,0x01,0x23,0x45,0x67,(byte)0x89,0x01,0x23,0x45,0x67,(byte)0x89 } ;
		String	panstr 	= "01234567890123456789" ; // pan without length padded with leading 0
		
		F002 pan 	= ctf.getF002( panarr ) ;
		
		if ( pan.isValid() ){
			String result = pan.data2String() ;
			if ( result.equals(  panstr  ) ){
				System.out.println(className+"Isvalid               : TRUE - " + result);
				assertTrue( true) ;
			}else{
				System.out.println(className+"Isvalid               : FALSE - "+ result);
				assertFalse( true) ;
			}
		}else{
			System.out.println(className+"Isvalid               : FALSE - "+ pan.getStatusMsg() );
			assertFalse( true) ;
		}
	}

	@Test
	public void NotValidDataLength() {
		byte[] 	panarrnv 		= { 0x10,0x01,0x23,0x45,0x67 } ;
		String	panarrnvstr 	= Binary.toHexStr( panarrnv ) ;
		F002 pannv 	= ctf.getF002( panarrnv ) ;
		if ( ! pannv.isValid() ){
			System.out.println(className+"NotValidDataLength    : TRUE - "+ pannv.getStatusMsg() );
			assertTrue( true) ;

		}else{
			String result = pannv.data2String() ;
			if ( result.equals(  panarrnvstr  ) ){
				System.out.println(className+"NotValidDataLength    : FALSE - " + result);
				assertFalse( true) ;
			}else{
				System.out.println(className+"NotValidDataLength    : FALSE - "+ result);
				assertFalse( true) ;
			}
		}
	}

	@Test
	public void NotValidDataLength2() {
		byte[] 	panvaluenv 		= { 0x07,0x01,0x23,0x45,0x67 } ;
		String	panvaluestrnv 	= Binary.toHexStr( panvaluenv ) ;
		F002 pannv 	= ctf.getF002 ( panvaluenv ) ; 
		if ( ! pannv.isValid() ){
			System.out.println(className+"NotValidDataLength2   : TRUE - "+ pannv.getStatusMsg() );
			assertTrue( true) ;

		}else{
			String result = pannv.data2String() ;
			if ( result.equals(  panvaluestrnv  ) ){
				System.out.println(className+"NotValidDataLength2   : FALSE - " + result);
				assertFalse( true) ;
			}else{
				System.out.println(className+"NotValidDataLength2   : FALSE - "+ result);
				assertFalse( true) ;
			}
		}
	}

	@Test
	public void NotValidCodification() {
		byte[] 	panvaluenv 		= { 0x13,0x01,0x23,0x45,0x67,(byte)0x89,0x01,0x23,0x45,0x67,(byte)0x8F } ;
		String	panvaluestrnv 	= Binary.toHexStr( panvaluenv ) ;
		F002 pannv 	= ctf.getF002 ( panvaluenv ) ; 
		if ( ! pannv.isValid() ){
			System.out.println(className+"NotValidCodification  : TRUE - "+ pannv.getStatusMsg() );
			assertTrue( true) ;

		}else{
			String result = pannv.data2String() ;
			if ( result.equals(  panvaluestrnv  ) ){
				System.out.println(className+"NotValidCodification  : FALSE - " + result);
				assertFalse( true) ;
			}else{
				System.out.println(className+"NotValidCodification  : FALSE - "+ result);
				assertFalse( true) ;
			}
		}
	}
}
