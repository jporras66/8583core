package com.indarsoft.iso8583core.app;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.log4j.Logger;

import com.indarsoft.iso8583core.app.AppBean;
import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.utl.Utl;

import org.junit.Test;

public class VisaSmsAppTest {

	static Logger log = Logger.getLogger( VisaSmsAppTest.class.getName() );
	public String 	className 	= this.getClass().getSimpleName() + "." ;
//
	String sep = File.separator;
	String pwd = Utl.getPwd() ;
//	
	@Test
	public void appXml() {
		
		String CONFIGFILE = "visasms.properties";
		Config cfg = new Config( CONFIGFILE );
		Application  app	= ApplicationFactory.getApp( cfg ) ;
		AppBean appdata = app.getAppBean() ;
		if ( appdata.getAppName().equals("VISASMS") ) {
			 System.out.println(className + "appXml  : TRUE  - " + appdata.getAppName() ) ; 
			 displayData ( appdata );
			 assertTrue( true) ;
		}else{
			 System.out.println(className + "appXml  : FALSE - " + appdata.getAppName() ) ;
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
