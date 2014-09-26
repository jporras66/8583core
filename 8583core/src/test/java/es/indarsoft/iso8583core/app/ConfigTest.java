package es.indarsoft.iso8583core.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigTest {

	public String className = this.getClass().getSimpleName() + "." ;
	public String CONFIGFILE = "visasms.properties";

	@Test
	public void testApplication() {
		
		Config app = new Config( CONFIGFILE ) ;
		String homeDir =  app.getAppHomeDir() ;
		if ( ! homeDir.equals("") ){
			System.out.printf(className+"testApplication  : OK  ISO8583CORE_DIR  is - %s \n" , app.getAppHomeDir() );
			System.out.printf(className+"testApplication  : OK  CONFIG_DIR       is - %s \n" , app.getConfigDir() );
			System.out.printf(className+"testApplication  : OK  mainxmlfile      is - %s \n" , app.getMainXmlfilename() );
			System.out.printf(className+"testApplication  : OK  appxmlfile       is - %s \n" , app.getAppXmlfilename() );
			assertTrue( true) ;
		}else{
			System.out.printf(className+"testApplication  : KO  ISO8583CORE_DIR  is - %s \n" , app.getAppHomeDir() );
			System.out.printf(className+"testApplication  : KO  CONFIG_DIR       is - %s \n" , app.getConfigDir() );			
			System.out.printf(className+"testApplication  : KO  mainxmlfile      is - %s \n" , app.getMainXmlfilename() );
			System.out.printf(className+"testApplication  : KO  appxmlfile       is - %s \n" , app.getAppXmlfilename() );
			assertFalse( true) ;
		}	
	}
}
