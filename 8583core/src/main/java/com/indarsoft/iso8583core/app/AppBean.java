package com.indarsoft.iso8583core.app;

import java.util.Hashtable;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthFormatType;

/**
 * Bean for an application.
 * <p>
 * <pre>
 * Attributes :
 * - appName				Application Name
 * - FieldFormatType		{@link FieldFormatType}
 * - FieldCodificationType	{@link FieldCodificationType}
 * - LengthFormatType		{@link LengthFormatType}
 * - htfield				hash table of fields {@link Field}
 * </pre>
 * @author fjavier.porras@gmail.com
 *
 */
public class AppBean {

	private String appName = "" ;
	private FieldFormatType				defaultfieldFormat;
	private FieldCodificationType 		defaultDataCodification;
	private LengthFormatType 			defaultLengthFormat;
	private Hashtable<Integer, Field> 	htfield = new Hashtable<Integer, Field>() ;
	
	private AppBean(){
	}
	/**
	 * Static Constructor. Creates a new instance.
	 * <p>
	 * @param appname
	 * 			application name
	 * @param fft
	 * 			FieldFormatType		{@link FieldFormatType}
	 * @param fct
	 * 			FieldCodificationType	{@link FieldCodificationType}
	 * @param lft
	 * 			LengthFormatType		{@link LengthFormatType}
	 * @param htf
	 * 			hash table of fields {@link Field}
	 * @return	new instance
	 */
	protected static AppBean getInstance (  String  appname, FieldFormatType fft,  FieldCodificationType fct,
											LengthFormatType lft, Hashtable<Integer, Field> htf ){
		AppBean apb = new AppBean();
		apb.setAppName( appname );
		apb.setDefaultDataCodification( fct );
		apb.setDefaultfieldFormat( fft ) ; 
		apb.setDefaultLengthFormat(lft );
		apb.htfield = deepCopy( htf );
		return apb ;
	}
	
	/**
	 * Copy Constructor for AppBean.
	 * <p>
	 * @param a
	 * 			input AppBean
	 * @return	new instance
	 */
	protected static AppBean copy ( AppBean a ){
		AppBean apb = new AppBean();
		apb.setAppName( a.getAppName() );
		apb.setDefaultDataCodification( a.getDefaultDataCodification() );
		apb.setDefaultfieldFormat( a.getDefaultfieldFormat() ) ; 
		apb.setDefaultLengthFormat( a.getDefaultLengthFormat() );
		apb.htfield = deepCopy( a.htfield );
		return apb ;
	}
	
	public String getAppName() {
		return appName;
	}

	protected void putField (Field field ) {
		htfield.put ( field.getId()  , field ) ;
	}
	
	public Field getField (int fieldId ) {
//
		Field field = null ; 
		if ( htfield.containsKey(fieldId  )  ){
			field = new Field.Builder().
					id(     		htfield.get( fieldId ).getId() 			).
					lengthType( 	htfield.get( fieldId ).getLengthType() 	).
					name ( 			htfield.get( fieldId ).getName() 		).
					fieldFormat ( 	htfield.get( fieldId ).getFieldFormat() ).
					fieldLength( 	htfield.get( fieldId ).getFieldLength() ).
					fieldCodification( htfield.get( fieldId ).getFieldCodification() ).
					lengthFormat( 	htfield.get( fieldId ).getLengthFormat() ).
					lengthOfLengthField( htfield.get( fieldId ).getLengthOfLengthField() ).
					minfieldLength( htfield.get( fieldId ).getMinfieldLength() 	).
					maxfieldLength( htfield.get( fieldId ).getMaxfieldLength() 	).build() ;
	//
		}

		return field;
	}
	
	protected void setAppName(String a) {
		appName = a;
	}

	public FieldCodificationType getDefaultDataCodification() {
		return defaultDataCodification;
	}
	
	public LengthFormatType getDefaultLengthFormat() {
		return defaultLengthFormat;
	}

	protected void setDefaultDataCodification (FieldCodificationType dataCodificationType) {
		defaultDataCodification = dataCodificationType;
	}

	protected void setDefaultLengthFormat( LengthFormatType a) {
		defaultLengthFormat = a;
	}

	public FieldFormatType getDefaultfieldFormat() {
		return defaultfieldFormat;
	}

	protected void setDefaultfieldFormat(FieldFormatType a) {
		defaultfieldFormat = a;
	}
	
	public Hashtable<Integer, Field > getHtfield() {
		return deepCopy( htfield);
	}
	
	private static Hashtable<Integer, Field> deepCopy( Hashtable<Integer, Field> input  ) {
		int size =  input.size() ;
		Hashtable<Integer, Field> out = new Hashtable<Integer, Field > ( size );
	    for( int key : input.keySet() ) {
	    	Field f = input.get(key  ) ;
	        out.put( key , f );
	    }
	    return out;
	}
	
}
