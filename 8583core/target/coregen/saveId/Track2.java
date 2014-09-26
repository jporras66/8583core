package es.indarsoft.iso8583core.coretypes.save;

import java.util.Arrays;

import es.indarsoft.iso8583core.codification.types.Field;
import es.indarsoft.iso8583core.codification.types.FieldCodificationType;
import es.indarsoft.iso8583core.primitives.TypeVar;

/**
 * 	FIELD 35—Track2
 * 	
 */

public class Track2 extends TypeVar {

	private String className = this.getClass().getSimpleName() + "." ;
	private final byte TRACK2_SEPARATOR = (byte) 0x0D ;  // for Visa & MC
	
	private int 		separatorPosition ; 
	private byte[] 		panarr ; 
	private F2PrimaryAccountNumber pan ;
	@SuppressWarnings("unused")
	private byte[] 		exprirationDate ;
	@SuppressWarnings("unused")
	private ServiceCode serviceCode ;
//	
	/**  Track2 constructor
	 * 
	 * @param byte[] bytearr
	 * @param {@link Field } field
	 * 
	 */	
	protected Track2 (byte[] bytearr , Field field ) {
		
    	super( bytearr, field ) ;
		
    	computeData( );
	}	
	
	private void computeData(   ){
		
		Field field = super.getField() ;
		if ( field.getFieldCodification() == FieldCodificationType.BCD ){
			findSeparator4BCD(  super.getBytearr(), field.getLengthOfLengthField()  );
		}else{
			findSeparator(  super.getBytearr(), field.getLengthOfLengthField() );
		}
		
		if ( this.separatorPosition == 0 ){
			super.setIsvalid( false );
			super.setMsg( className+ "separator not found : " + super.getDataStr() );
		}
		
		this.pan = CoreTypesFactory.getF2PrimaryAccountNumber( panarr )	 ;
		
	}
/**
 * Return the separator's position for BCD test.codification 
 * IMPORTANT : 1 byte --> 2 BCD positions
 * 	
 * @param 	byte[] bytearr
 * @param 	{@link Field } field
 * 
 */
	private void findSeparator4BCD(  byte[] bar, int lenghthoflengthfield  ){
		
		for ( int i=lenghthoflengthfield; i<bar.length; i++){
			byte uppernibble = (byte) ( ( bar[i] & (byte) 0xF0 ) >> 4 );
			byte lowernibble = (byte) ( ( bar[i] & (byte) 0x0F ) );
			if ( uppernibble == TRACK2_SEPARATOR ){
				this.separatorPosition = i * 2 ;
				this.panarr = fillEvenPanArr( bar , lenghthoflengthfield , i );
				break ;
			}
			if ( lowernibble == TRACK2_SEPARATOR ){
				this.separatorPosition = i * 2 + 1;
				this.panarr = fillOddBcdPanArr( bar , lenghthoflengthfield, i + 1 );
				break ; 
			}
		}
	}
/**
 * Return the separator's position for EBCDIC & ASCII test.codification 
 * IMPORTANT : 1 byte --> 1 position
 * 
 * @param 	byte[] bytearr
 * @param 	{@link Field } field
 * @return	int
 * 
 */
	private void findSeparator( byte[] bar, int lenghthoflengthfield  ){
		
		for ( int i=lenghthoflengthfield ; i<bar.length; i++){
			if ( bar[i] == TRACK2_SEPARATOR ) {
				this.separatorPosition =  i ; 
				fillEvenPanArr( bar , lenghthoflengthfield , i );
			}
		}
		
	}
	
	private byte[] fillEvenPanArr( byte[] bytearr, int lenghthoflengthfield , int numbytes ){
		
		byte bar[] = new byte[19];
		for (int i=lenghthoflengthfield+1; i < numbytes  ; i++){
			bar[i] = bytearr[i] ;
		}
		
		return Arrays.copyOfRange(  bar , 0, numbytes ) ;
	}
	
	private byte[] fillOddBcdPanArr(  byte[] bytearr, int lenghthoflengthfield,  int numbytes ){
		
		byte bar[] = new byte[19];
		byte uppernibble = (byte) ( ( bytearr[ lenghthoflengthfield ] & (byte) 0xF0 ) >> 4 );
		byte lowernibble = (byte) ( ( bytearr[ lenghthoflengthfield ] & (byte) 0x0F ) );
		byte abyte = (byte) ( 0x00  | uppernibble );
//		
		bar[0] = abyte;	//first nibble must be binary 0000 for Even Pan

//		
		for (int i=lenghthoflengthfield+1; i < numbytes  ; i++){
			byte bbyte = 0x00 ; 
			bbyte 		= (byte) ( ( 0x0F & lowernibble ) << 4 );
			uppernibble = (byte) ( ( bytearr [i] & (byte) 0xF0 ) >> 4 );
			bbyte 		= (byte) ( bbyte | uppernibble ); 
			bar[i-1]		= bbyte;
//			
			lowernibble = (byte) ( ( bytearr [i] & (byte) 0x0F ) );
		}
		
		return Arrays.copyOfRange(  bar , 0, numbytes ) ;
//		
	}
	
	public F2PrimaryAccountNumber getPan() {
		return pan;
	}
	
}
