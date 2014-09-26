
package es.indarsoft.iso8583core.message;

import java.util.Hashtable;

import es.indarsoft.iso8583core.app.Application;
import es.indarsoft.iso8583core.types.TypeMain;

public class IsoMsgFactory {

	public static IsoMessage get (  byte[] bytearr,  Application app )  { 	
    	return new IsoMessage ( bytearr , app ) ;
    }  
    
	public static IsoMessage set (  Hashtable<Integer, TypeMain > htofield  )  {
    	return new IsoMessage ( htofield ) ;
    }	
    
	public static IsoMessage in2out (  byte[] bytearr, Application app  )  {
		IsoMessage  imsg = new IsoMessage ( bytearr, app ) ;
		Hashtable<Integer, TypeMain> htfield = imsg.getHtfield() ;
		IsoMessage omsg = new IsoMessage ( htfield ) ;
		return omsg ;
    }
	
}
