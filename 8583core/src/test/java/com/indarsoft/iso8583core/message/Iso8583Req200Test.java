package com.indarsoft.iso8583core.message;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.log4j.Logger;

import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.message.IsoMessage;
import com.indarsoft.iso8583core.message.IsoMsgFactory;
import com.indarsoft.utl.Utl;
import com.indarsoft.utl.Binary;

import org.junit.Test;


public class Iso8583Req200Test {

	static Logger 	log = Logger.getLogger( Iso8583Req200Test.class.getName() );
	
	public String CONFIGFILE = "main.properties";
	public Config cfg = new Config( CONFIGFILE );
	public Application  app	= ApplicationFactory.getMain( cfg ) ;
	
	@Test
	public void read() {
		
		String sep = File.separator;
		String filename = Utl.getPwd()+ sep+"data"+ sep + "request_200.hex";
		log.debug( "Start Processing : " + filename) ;
//		
		byte bar[] = Utl.loadBinary( filename ) ;
		System.out.println( "array is  : " + Binary.toHexStr( bar  ) );
//	
		@SuppressWarnings("unused")
		IsoMessage msg = IsoMsgFactory.get( bar , app) ;
//
		log.debug( "End Processing : " + filename) ;
		assertTrue( true) ;
	}



}
