package com.indarsoft.iso8583core.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.indarsoft.utl.Utl;

/**
 * Configuration File for the {@link Application}.
 * <p>
 * <pre>
 * Configuration files (<filename>.properties) must be stored in <APLDIR>/config directory.
 * </pre>
 * @author fjavier.porras@gmail.com
 *
 */
public final class Config {

	static Logger log = Logger.getLogger( Config.class.getName() );	
	private static String sep = File.separator;
	private String ISO8583CORE_DIR = "";
	private String CONFIG_DIR = "" ;
	private String CONFIGFILE = "";
	private String mainxmlfile ="";
	private String appxmlfile  ="";
	private String msg = "";
	/**
	 * Constructor.
	 * <p>
	 * @param apldir
	 * 			<APLDIR> directory.
	 * @param configfile
	 * 			Configuration files (<filename>.properties) must be stored in <APLDIR>/config directory.
	 * @throws IllegalArgumentException
	 */
	public Config( String apldir, String configfile ) throws IllegalArgumentException {
		
		CONFIGFILE = configfile;
		ISO8583CORE_DIR = apldir ;
		CONFIG_DIR = ISO8583CORE_DIR + sep + "config";
		File configDir = new File(CONFIG_DIR);
		if(!configDir.exists()){
			msg = configDir +" not found";
			log.debug( msg  ) ;			
		}
		if ( ! loadConfigFile() ) throw new IllegalArgumentException("Config file");
	}
	
	/**
	 * Constructor.
	 * <p>
	 * @param configfile
	 * 			Configuration file (<filename>.properties) must be stored in <APLDIR>/config directory.				
	 */
	public Config( String configfile ){
			
		this ( Utl.getPwd(), configfile );
	}
	
	/**
	 * Loads Config File.
	 * <p>
	 * @return boolean. If FALSE and error has arrived loading config file.
	 */
	private boolean loadConfigFile ( ){
	    
		InputStream input = null;
    	try {
     
    		File f = new File( CONFIG_DIR, CONFIGFILE );
    		if(f.exists()){
    			input = new FileInputStream( f );
    		}else{
    			msg = CONFIG_DIR+sep+CONFIGFILE+" not found" ;
    			log.debug( msg ) ;
    			return false ;
    		}
        	Properties prop = new Properties( );
    		prop.load(input);
    		/*
    		 * check if iso8583xmlfile property and file pointed are available
    		 * If not, logs message and return false.
    		 *  
    		 */
    		String str1 = prop.getProperty("mainxmlfile") ;
    		if ( str1 == null || str1.equals("")){
    			msg = "mainxmlfile property not found in " + CONFIG_DIR + sep + CONFIGFILE;
    			log.debug( msg ) ;
    			return false ;	
    		}
    		String str2 	= CONFIG_DIR+ sep + str1 ;
    		File fc1 = new File(str2);
    		if(!fc1.exists()){
    			msg = str2 + " file not found" ;
    			log.debug( msg ) ;
    			return false;
    		}
    		mainxmlfile = str2 ;
    		/*
    		 * check if iso8583xmlfile property and file pointed are available 
    		 * If not, logs message and continue.
    		 * 
    		 */
    		String str3 = prop.getProperty("appxmlfile") ;
    		if ( str3 == null || str3.equals("") ){
    			msg = "appxmlfile property not found in " + CONFIG_DIR + sep + CONFIGFILE;
        		log.debug( msg ) ;			
    		}else{
    			String str4 = CONFIG_DIR+ sep + str3 ;
        		File fc2 = new File(str4);
        		if(!fc2.exists()){
        			msg = appxmlfile + " file not found" ;
        			log.debug( msg ) ;			
        		}else{
        			appxmlfile = CONFIG_DIR+ sep + str3 ;
        		}
    		}
//    		
    	} catch (IOException ex) {
    		log.debug( ex.getMessage() ) ;
    		ex.printStackTrace();
    		return false;
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    	    		log.debug( e.getMessage() ) ;
    				e.printStackTrace();
    	    		return false;
    			}
       		}
    	}
    	return true;
     }
		
	public String getMainXmlfilename() {
		return mainxmlfile;
	}

	public String getAppXmlfilename() {
		return appxmlfile;
	}

	public String getAppHomeDir() {
		return ISO8583CORE_DIR;
	}

	public String getConfigDir() {
		return CONFIG_DIR;
	}
	
	public String getMsg() {
		return msg;
	}	

}
