
package com.indarsoft.iso8583core.app;

//import org.apache.log4j.Logger;

/**
 * Static factory for Applications.
 * 
 * @author fjavier.porras@gmail.com
 *
 */
public class ApplicationFactory {

	//static Logger log = Logger.getLogger( ApplicationFactory.class.getName() );
    
	/**
	 * Returns a new Application instance loaded from a XML file.
	 * <p>
	 * @param cfg
	 * 			Configuration {@link Config}.
	 * @return new instance
	 * @throws IllegalArgumentException
	 */
	public static Application getMain ( Config cfg ) throws IllegalArgumentException {
		
		String mainxmlfile = cfg.getMainXmlfilename();	
		
		if ( mainxmlfile == null || mainxmlfile.equals("")) 
			throw new IllegalArgumentException("invalid xmlfile value") ;
    	
		return Application.getMainInstance( mainxmlfile ) ;
    }

	public static Application getApp ( Config cfg ) throws IllegalArgumentException  {
    	
		String mainxmlfile 	= cfg.getMainXmlfilename();
		String appxmlfile 	= cfg.getAppXmlfilename();
		
		if ( mainxmlfile == null || mainxmlfile.equals("")) 
			throw new IllegalArgumentException("invalid xmlfile value") ;
		
		if ( appxmlfile == null || appxmlfile.equals("")) 
			throw new IllegalArgumentException("invalid appxmlfile value") ;
    	
		return Application.getAppInstance( appxmlfile, mainxmlfile ) ;
    }
	
}
