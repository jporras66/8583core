package es.indarsoft.iso8583core.message;

import es.indarsoft.utl.ArrayUtl;

import java.util.Arrays;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import es.indarsoft.iso8583core.app.Application;
import es.indarsoft.iso8583core.coretypes.*;
import es.indarsoft.iso8583core.types.TypeMain;

public class IsoMessage {

	protected static Logger log = Logger.getLogger( IsoMessage.class.getName() );	
	private byte[] 	bytearr ;
	private Hashtable<Integer, TypeMain > htfield ;
		
	protected IsoMessage ( byte[] bytearr , Application app) {
		this.bytearr = bytearr ;
		IsoLoadFields lf = new IsoLoadFields( bytearr, app ) ;
		this.htfield = lf.putAll ( ) ;
	}
	
	protected IsoMessage ( Hashtable<Integer, TypeMain > ihtfield ) {	
		htfield = deepCopy ( ihtfield ) ;
		setPrimaryBitmap()  ;
		setBytes() ;
	}
	
	public Hashtable<Integer, TypeMain> getHtfield() {
		Hashtable<Integer, TypeMain > ohtfield = deepCopy ( htfield );
		return ohtfield;
	}
	
	public byte[] getBytes() {
		return bytearr;
	}
	
	private void setBytes(){
		/**
		 * Order keys from hashtable htfield
		 */
		int size =  htfield.size() ;
		int [] ordered = new int[ size ] ;
		int i = 0 ; 
	    for( int key : htfield.keySet() ) { 
	    	ordered[i] = key ;
	        i++;
	    }
	    Arrays.sort(  ordered );
	    //
		byte[] ab = new byte[0] ;
		int index = 0;
		for ( int k=0;k<size;k++ ){
			TypeMain tpm = htfield.get( ordered[k] ) ;
			index = index + tpm.getBytearr().length;
			ab = ArrayUtl.concat(  ab , tpm.getBytearr() ) ;
		}
		bytearr = Arrays.copyOf( ab , index );
	}
	
	private byte[] setPrimaryBitmap() {
		
		byte[] bitmaparr = new byte[ 64 ];
		for (int i=0; i< 64 ;i++){
			bitmaparr[i] = 0x00 ;
		}
//			
		for ( int key : htfield.keySet() ){
			if ( key > 1 ) 							bitmaparr[key] 	= 0x01 ;	// only bitmapped present fields
			if ( key > 65  && bitmaparr[0] == '0') 	{
				bitmaparr[0] 	= 0x01 ;										// secondary bitmap must be present
				break;
			}
		}
		return bitmaparr ;
	}
	
	@SuppressWarnings("unused")
	private byte[] setSecondaryBitmap() {
		
		byte[] bitmaparr = new byte[ 64 ];
		for (int i=0; i< 64 ;i++){
			bitmaparr[i] = 0x00 ;
		}
//			
		for ( int key : htfield.keySet() ){
			if ( key > 65 ) 	bitmaparr[key] 	= 0x01 ;	// only bitmapped present fields
		}
		return bitmaparr ;
	}
	
	public F000 getF000(){
		
		F000 field = ( F000 ) htfield.get( 0 ) ;
		return field ; 
	}
	
	public F003 getF003(){
		
		F003 field = ( F003 ) htfield.get( 3 ) ;
		return field ; 
	}
	
	private static Hashtable<Integer, TypeMain > deepCopy( Hashtable<Integer, TypeMain > input  ) {
		int size =  input.size() ;
		Hashtable<Integer, TypeMain> out = new Hashtable<Integer, TypeMain > ( size );
	    for( int key : input.keySet() ) {
	    	TypeMain typemain = input.get(key  ) ;
	        out.put( key , typemain );
	    }
	    return out;
	}	
}
