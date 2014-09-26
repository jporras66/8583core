package es.indarsoft.iso8583core.coretypes;

import java.util.Arrays;
import es.indarsoft.utl.Bcd;
import es.indarsoft.utl.Binary;
import es.indarsoft.iso8583core.types.TypeVar;
import es.indarsoft.iso8583core.types.Field;
import es.indarsoft.iso8583core.types.FieldCodificationType;
import es.indarsoft.iso8583core.utl.Common;

/**
 * 	FIELD 35 Track2
 * 	
 */

public class F035 extends TypeVar {

	private final byte 	TRACK2_SEPARATOR = (byte) 0x0D ;  // for Visa & MC
	private int 		separatorPosition ; 
	private byte[] 		panArr ; 
	private byte[] 		expirationDateArr ;
	private byte[] 		serviceCodeArr ;
	private byte[]		discretionaryDataArr ;
//
	private String 		pan ; 
	private String 		expirationDate ;
	private String 		serviceCode ;
	private String		discretionaryData ;	
//	

//	
	private F035 (byte[] bytearr, Field field ) {
		
    	super( bytearr, field , false ) ; // invoke construtuctor without data validation
		
    	calculateData( );
    	validate () ;
	}
	
	/**   get static constructor
	 * 
	 * @param 	bytearr 
	 * @return	{@link F002 }
	 */			
    protected static F035 get ( byte[] bytearr , Field field ){
    	    	
    	return new F035 ( bytearr, field ) ;
    }
	
	private void calculateData(   ){
		
		Field field = super.getField() ;
		byte[] databararr =  Arrays.copyOfRange(  super.getBytearr() , field.getLengthOfLengthField() , super.getBytearr().length ) ; ; 
//		
		if ( field.getFieldCodification() == FieldCodificationType.BCD ){		// BCD Codification
			calculateDataBcd( databararr ) ;
		}else																	
		if ( field.getFieldCodification() == FieldCodificationType.EBCDIC ) {	// EBCDIC codification
			calculateDataEbcdic( databararr ) ;
		}

	}
	
	private boolean calculateDataBcd(byte[] databararr ) {
//
		boolean isvalid = findSeparator4Bcd(  databararr );	
		if ( ! isvalid  ) return false ;
//
		if ( this.separatorPosition % 2 != 0 ) {
			isvalid = calculateDataLowerSeparator ( databararr ) ;

		}else{
			isvalid = calculateDataUpperSeparator( databararr ) ;
		}
		return isvalid ; 
	}
	
	private boolean calculateDataEbcdic(byte[] databararr ) {
//
		Field field = super.getField();
		boolean isvalid = findSeparator(  databararr );	
		if ( ! isvalid  ) return false ;
//
//		pan : 	read bytes until separator position
//
		this.panArr 	= Arrays.copyOfRange(  databararr , 0, this.separatorPosition  ) ;
		this.pan 		= Common.toString( panArr,  field ) ;
//
//		expirationDate : 	4 bytes to read from starting pointer
//
		int startpointer = this.separatorPosition + 1 ;
		int endpointer 	= startpointer + 4 ;
		if ( databararr.length < endpointer  ){ 			// bytes does not content enough data
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readExpirationDate not found : " + super.data2String() );
			return false;
		}		
		this.expirationDateArr 	= Arrays.copyOfRange(  databararr , startpointer  , endpointer ) ;
		this.expirationDate		= Common.toString( expirationDateArr,  field ) ;
//
//		serviceCode : 	3 bytes to read from starting pointer
//
		startpointer 	= endpointer ;
		endpointer 		= startpointer + 3 ;
		if ( databararr.length < endpointer  ){ 			// bytes does not content enough data
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readserviceCode not found : " + super.data2String() );
			return false;
		}	
		this.serviceCodeArr 	= Arrays.copyOfRange(  databararr , startpointer , endpointer ) ;
		this.serviceCode		= Common.toString( serviceCodeArr,  field ) ;
//
//		discretionaryData :	3 bytes to read from starting pointer, at least for cvv
//
		startpointer 	= endpointer ;
		endpointer 		= startpointer + 3 ;
		if ( databararr.length < endpointer  ){ 			// bytes does not content enough data
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readserviceCode not found : " + super.data2String() );
			return false;
		}	
		this.discretionaryDataArr 	= Arrays.copyOfRange(  databararr , startpointer , databararr.length ) ;
		this.discretionaryData		= Common.toString( discretionaryDataArr,  field ) ;
//		
		return isvalid ; 
	}
	/**
	 * Return the separator's position for BCD test.codification 
	 * IMPORTANT : 1 byte --> 2 BCD positions
	 * 	
	 * @param 	bytes byte array
	 * @return  boolean
	 */
	private boolean findSeparator4Bcd(  byte[] bytes  ){
		
		for ( int i=0 ; i<bytes.length; i++){
			byte intermediate = (byte) ( ( bytes[i] & (byte) 0xF0 ) >>> 4 );
			byte uppernibble  = (byte) ( intermediate & (byte) 0x0F  );
			byte lowernibble = 	(byte) ( ( bytes[i] & (byte) 0x0F ) );
			if ( uppernibble == TRACK2_SEPARATOR ){
				this.separatorPosition 	= i * 2 ;
				return true ;
			}
			if ( lowernibble == TRACK2_SEPARATOR ){
				this.separatorPosition 	= i * 2 + 1;
				return true ; 
			}
		}
		super.setIsvalid( false );
		super.setStatusMsg( super.className+ "findSeparator4Bcd not found : " + super.data2String() );
		return false ;
	}
	/**
	 * Return the separator's position for EBCDIC & ASCII test.codification 
	 * IMPORTANT : 1 byte --> 1 position
	 * 
	 * @param 	bytes byte array
	 * @return	boolean
	 * 
	 */
	private boolean findSeparator( byte[] bytes  ){
		
		for ( int i=0 ; i < bytes.length; i++){
			if ( bytes[i] == TRACK2_SEPARATOR ) {
				this.separatorPosition =  i ; 
				return true;
			}
		}		
		super.setIsvalid( false );
		super.setStatusMsg( super.className+ "findSeparator not found : " + super.data2String() );
		return false ;
	}
	
	private boolean calculateDataUpperSeparator( byte[] bytes){	
//
		Field field = super.getField();
		int bcdDigitsNumber = bytes.length * 2 - 1 	;		// total data array length * 2 - Separator (D)
		int remainingDigitsNumber = bcdDigitsNumber ;
//
//		read nibbles for pan (until separator position) 
//		
		this.panArr		= Arrays.copyOfRange(  bytes , 0, this.separatorPosition / 2 ) ;
		this.pan 		= Common.toString( panArr,  field ) ;
		remainingDigitsNumber = remainingDigitsNumber - this.separatorPosition  ;
		// System.out.println("pan : " + pan ) ;
//
//		4 Nibbles ( 2 bytes) to read from starting pointer, for expirationDate
//		
		int startpointer 	= this.separatorPosition/2 ;
		int numnibbles 		=  4 ;					
		if ( bytes.length < startpointer + 2  ){				// array data does not content enough data
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readExpirationDate not found : " + super.data2String() );
			return false;
		}
		this.expirationDateArr = Bcd.CopyBcdArrWithoutFirstNibble( bytes , startpointer , numnibbles ) ;
		this.expirationDate	   = Common.toString( expirationDateArr,  field ) ;
		
		remainingDigitsNumber = remainingDigitsNumber - 4 ; 
		// System.out.println("readExpirationDate : " + expirationDate ) ;
//
//		3 Nibbles ( 2 bytes) to read from starting pointer, for serviceCode
//		
		numnibbles =  3 ;
		startpointer = startpointer + 2 ;
		if ( bytes.length < startpointer + 2  ){ 				// array data does not content enough data
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readServiceCode not found : " + super.data2String() );
			return false;
		}	
		this.serviceCodeArr = Bcd.CopyBcdArrWithoutFirstNibble( bytes ,  startpointer ,  numnibbles  );
		this.serviceCode    = Common.toString( serviceCodeArr,  field ).substring( 1 ) ;		//disccard first nibble
		
		remainingDigitsNumber = remainingDigitsNumber - 3 ; 
		// System.out.println("readServiceCode : " + serviceCode ) ;
//
//		read remaining nibbles (remainingDigitsNumber) , at least to read CVV (2 bytes)
//			 
		startpointer = startpointer + 2 ;
		if ( bytes.length < startpointer + 2  ){
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readDiscretionaryData not found : " + super.data2String() );
			return false;
		}		
		this.discretionaryDataArr = Arrays.copyOfRange(  bytes , startpointer, bytes.length  ) ;
		this.discretionaryData	  = Common.toString( discretionaryDataArr,  field ) ;
		// System.out.println("readDiscretionaryData : " + discretionaryData ) ;	
//		
		return true ;
	}
	
	private boolean calculateDataLowerSeparator( byte[] bytes){
//
		Field field = super.getField();
		int bcdDigitsNumber = bytes.length * 2 - 1 	;		// total data array length * 2 - Separator (D)
		int remainingDigitsNumber = bcdDigitsNumber ;
//
//		read nibbles for pan (until separator position) 
//		
		this.panArr 	= Bcd.CopyBcdArrWithoutLastNibble ( bytes , 0  , this.separatorPosition );
		this.pan 		= Common.toString( panArr,  field ).substring( 1 ) ;
		// System.out.println("pan : " + pan ) ;		
		remainingDigitsNumber = remainingDigitsNumber - this.separatorPosition  ;
//
//		4 Nibbles ( 2 bytes) to read from starting pointer, for expirationDate
//		
		int startpointer 	= this.separatorPosition/2 + 1 ; 
		int endpointer 	= startpointer + 2 ;			//	2 Bytes to read
		if ( bytes.length < endpointer  ){ 				// 	bytes does not content enough data
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readExpirationDate not found : " + super.data2String() );
			return false;
		}
		this.expirationDateArr = Arrays.copyOfRange(  bytes , startpointer , endpointer ) ;
		this.expirationDate	   = Common.toString( expirationDateArr,  field ) ;
		remainingDigitsNumber = remainingDigitsNumber - 4 ; 
		// System.out.println("readExpirationDate : " + expirationDate ) ;
//
//	3 Nibbles ( 2 bytes) to read from starting pointer, for serviceCode
//		
		int numnibbles =  3 ;
		startpointer = startpointer + 2 ;
		if ( bytes.length < startpointer + 2  ){ 			// data array does not content enough data
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readServiceCode not found : " + super.data2String() );
			return false;
		}		
		this.serviceCodeArr = Bcd.CopyBcdArrWithoutLastNibble ( bytes , startpointer  ,  numnibbles  ) ;
		this.serviceCode    = Common.toString( serviceCodeArr,  field ).substring( 1 ) ;		//disccard first nibble
		remainingDigitsNumber = remainingDigitsNumber - 3 ; 
		// System.out.println("readServiceCode : " + serviceCode ) ;

//
//		read remaining nibbles (remainingDigitsNumber) , at least to read CVV (2 bytes)
//			 
		startpointer = startpointer + 1 ;
		if ( bytes.length < startpointer + 2  ){
			super.setIsvalid( false );
			super.setStatusMsg( super.className+ "readDiscretionaryData not found : " + super.data2String() );
			return false;
		}		
		this.discretionaryDataArr = Bcd.CopyBcdArrWithoutFirstNibble( bytes , startpointer  ,  remainingDigitsNumber  ) ;
		this.discretionaryData	  = Common.toString( discretionaryDataArr,  field ).substring(1 );
//		
		return true ;
	}
	
	private void validate (){
		
		super.validateLength();
		if  ( ! super.isValid()) return ; 
		
		if ( ! validateDataFormat ( panArr) 			|| 
			 ! validateDataFormat ( expirationDateArr)	||
			 ! validateDataFormat ( serviceCodeArr)    	||
			 ! validateDataFormat ( discretionaryDataArr)
			 ){
    		super.setIsvalid( false );
    		super.setStatusMsg( className+"validateDataFormat invalid "  ) ;
    		return;
		}

	}
		
	private boolean validateDataFormat ( byte[] bar ){

		Field field = super.getField();
		return Common.isValid( bar,  field ) ;
		
	}
	
	public String getPan() {
		return pan ;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public String getDiscretionaryData() {
		return discretionaryData;
	}
	
	public String getTrack2(){
		return pan+Binary.toHexStr(TRACK2_SEPARATOR).substring(1)+expirationDate+serviceCode+discretionaryData ;
	}
}
