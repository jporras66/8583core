package com.indarsoft.iso8583core.message;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.message.IsoMessage;
import com.indarsoft.iso8583core.message.IsoMsgFactory;
import com.indarsoft.iso8583core.types.TypeMain;
import com.indarsoft.utl.Utl;
import com.indarsoft.utl.Binary;

import org.junit.Test;

public class Iso8583WithdrawalMagstripeTest {

	static Logger 	log = Logger.getLogger( Iso8583WithdrawalMagstripeTest.class.getName() );
	
	public String CONFIGFILE = "main.properties";
	public Config cfg = new Config( CONFIGFILE );
	public Application  app	= ApplicationFactory.getMain( cfg ) ;

	@Test
	public void request() {
		String sep = File.separator;
		String filename = Utl.getPwd()+ sep+"data"+ sep + "request_200.hex";
		log.debug( "Start Processing : " + filename) ;
//		
		byte bar[] = Utl.loadBinary( filename ) ;
		System.out.println( "array is  : " + Binary.toHexStr( bar  ) );
//	
		IsoMessage msg = IsoMsgFactory.get( bar, app ) ;
		@SuppressWarnings("unused")
		Hashtable<Integer, TypeMain> htobj = msg.getHtfield() ;	
//
		log.debug( "End Processing : " + filename) ;
		assertTrue( true) ;
	}
	
	@Test	
	public void response() {
		
		String sep = File.separator;
		String filename = Utl.getPwd()+ sep+"data"+ sep + "response_210.hex";
		log.debug( "Start Processing : " + filename) ;
//		
		byte bar[] = Utl.loadBinary( filename ) ;
		System.out.println( "array is  : " + Binary.toHexStr( bar  ) );
//	
		IsoMessage msg = IsoMsgFactory.get( bar, app ) ;
		@SuppressWarnings("unused")
		Hashtable<Integer, TypeMain> htobj = msg.getHtfield() ;
//
		log.debug( "End Processing : " + filename) ;
		assertTrue( true) ;
	}


}
