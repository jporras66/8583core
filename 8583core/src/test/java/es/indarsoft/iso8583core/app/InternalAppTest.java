package es.indarsoft.iso8583core.app;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.log4j.Logger;

import es.indarsoft.iso8583core.app.AppBean;
import es.indarsoft.iso8583core.app.Application;
import es.indarsoft.iso8583core.app.ApplicationFactory;
import es.indarsoft.iso8583core.app.Config;
import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.utl.Utl;

import org.junit.Test;

public class InternalAppTest {

	static Logger 	log = Logger.getLogger( InternalAppTest.class.getName() ) ;
	public String 	className 	= this.getClass().getSimpleName() + "." ;

//
	String sep = File.separator;
	String pwd = Utl.getPwd() ;
//	
	@Test
	public void internalAppXml() {

		String CONFIGFILE = "internal.properties";
		Config cfg = new Config( CONFIGFILE );
		Application  app	= ApplicationFactory.getMain( cfg ) ;
		AppBean appdata = app.getAppBean() ;
		if ( appdata.getAppName().equals("INTERNALCORE") ) {
			 System.out.println(className + "internalAppXml  : TRUE  - " + appdata.getAppName() ) ;  
			 displayData ( appdata );
			 assertTrue( true) ;
		}else{
			 System.out.println(className + "internalAppXml  : FALSE - " + appdata.getAppName() ) ;
			 assertFalse( true) ;
		}	
	}
	
	private void displayData( AppBean appdata ){
		
		if ( ! log.isDebugEnabled()  ) {
			return ;
		}
		
		log.debug ( " APPNAME                 " + appdata.getAppName() ) ;
		log.debug ( " DefaultfieldFormat      " + appdata.getDefaultfieldFormat() ) ;
		log.debug ( " DefaultDataCodification " + appdata.getDefaultDataCodification() ) ;
		log.debug ( " DefaultLengthFormat     " + appdata.getDefaultLengthFormat() ) ;
		
		for (int id = -2;  id <= 128 ; id ++) {
			 Field field = appdata.getField(  id ) ;
			 if ( field != null ){
					log.debug ( "field name -------- : " + field.getName() ) ;
					log.debug ( "id                  : " + field.getId() ) ;
					log.debug ( "lengthType          : " + field.getLengthType() ) ;
					log.debug ( "fieldLength         : " + field.getFieldLength() ) ;
					log.debug ( "fieldFormat         : " + field.getFieldFormat() ) ;
					log.debug ( "fieldCodification   : " + field.getFieldCodification() ) ;
					log.debug ( "lengthFormat        : " + field.getLengthFormat() ) ;
					log.debug ( "lengthOfLengthField : " + field.getLengthOfLengthField() ) ;
					log.debug ( "minfiledLength      : " + field.getMinfieldLength() ) ;
					log.debug ( "maxfiledLength      : " + field.getMaxfieldLength() ) ;
			 }
		}

	}	

}
