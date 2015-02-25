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


public class Iso8583In2OutTest {

	public String className = this.getClass().getSimpleName() + "." ;
	static Logger log = Logger.getLogger( Iso8583In2OutTest.class.getName() );

	public String CONFIGFILE = "main.properties";
	public Config cfg = new Config( CONFIGFILE );
	public Application  app	= ApplicationFactory.getMain( cfg ) ;
	
	@Test
	public void in2out() {
		
		String sep = File.separator;
		String filename = Utl.getPwd()+ sep+"data"+ sep + "request_200.hex";
		log.debug( "Start Processing : " + filename) ;
//		
		byte bar[] = Utl.loadBinary( filename ) ;
		System.out.println( "array is  : " + Binary.toHexStr( bar  ) );
//	
		IsoMessage msg = IsoMsgFactory.in2out ( bar , app );
//
		log.debug( "End Processing : " + filename) ;
		String inputstr = Binary.toHexStr( bar );
		String msgstr 	= Binary.toHexStr( msg.getBytes() );
		if ( msgstr.equals( inputstr  )) {
			System.out.println( className + "in2out : TRUE   " );
			System.out.println( className + "in2out : input  - " + inputstr );
			System.out.println( className + "in2out : msgstr - " + msgstr );
			assertTrue( true) ;
		}else{
			System.out.println( className + "in2out : FALSE   " );
			System.out.println( className + "in2out : input  - " + inputstr );
			System.out.println( className + "in2out : msgstr - " + msgstr );			
			assertFalse( true) ;
		}
		
	}



}
