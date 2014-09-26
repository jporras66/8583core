package es.indarsoft.iso8583core.types;
/**
 * Field class that maps a filed data entry in <apl_dir>/config/*.xml file
 * <p>
 * <pre>
 * Attributes:
 * <br>
 * 	id				field id
 * 	lengthType			{@link LengthType } 
 * 	name				field name
 * 	fieldFormat			{@link FieldFormatType } 
 * 	fieldLength			field length
 * 	fieldCodification		{@link FieldCodificationType }
 * <br>
 * 	For Variable Length Data types :
 * <br>
 * 	lengthFormat			{@link LengthFormatType }
 * 	lengthOfLengthField		length for the length field 
 * 	minfieldLength			minimum length 
 * 	maxfieldLength			maximum length
 *  </pre>
 */
public final class Field {

	private int 					id ;
	private LengthType				lengthType;
	private String 					name ; 
	private FieldFormatType			fieldFormat ;
	private int 					fieldLength;
	private FieldCodificationType 	fieldCodification ;
	private LengthFormatType 		lengthFormat ;	
	private int 					lengthOfLengthField ;	
	private int 					minfieldLength ;
	private int 					maxfieldLength ;
	
	private Field( Builder builder ){
		
		id  					= builder.id ;                
		lengthType				= builder.lengthType;           
		name     				= builder.name;            
		fieldFormat				= builder.fieldFormat;          
		fieldLength 			= builder.fieldLength;         
		fieldCodification 		= builder.fieldCodification;   
		lengthFormat 			= builder.lengthFormat;	       
		lengthOfLengthField 	= builder.lengthOfLengthField; 	
		minfieldLength 			= builder.minfieldLength;        
		maxfieldLength 			= builder.maxfieldLength;      

	}

	public static class Builder{
		// Required parameters
		private int 					id ;
		private LengthType				lengthType;
		private String 					name ; 
		private FieldFormatType			fieldFormat ;
//		
		private int 					fieldLength			= 0;
		private FieldCodificationType 	fieldCodification 	= null;
		private LengthFormatType 		lengthFormat  		= null ;	
		private int 					lengthOfLengthField = 0;	
		private int 					minfieldLength 		= 0;
		private int 					maxfieldLength 		= 0;
		
		public Builder( ) {
			}

		public Builder id (int  id ) {
			this.id = id;
			return this ; 
		}	
		public Builder lengthType( LengthType lengthType ) {
			this.lengthType = lengthType ;
			return this ; 
		}		
		public Builder name( String name ) {
			this.name = name ;
			return this ; 
		}
		public Builder fieldFormat( FieldFormatType fieldFormat ) {
			this.fieldFormat = fieldFormat ;
			return this ; 
		}		
		public Builder fieldLength (int  fieldLength ) {
			this.fieldLength = fieldLength;
			return this ; 
		}				
		public Builder fieldCodification (FieldCodificationType fieldCodification ) {
			this.fieldCodification = fieldCodification;
			return this ; 
		}
		public Builder lengthFormat (LengthFormatType lengthFormat ) {
			this.lengthFormat = lengthFormat;
			return this ; 
		}
		public Builder lengthOfLengthField (int lengthOfLengthField   ) {
			this.lengthOfLengthField = lengthOfLengthField;
			return this ; 
		}
		public Builder minfieldLength (int minfieldLength   ) {
			this.minfieldLength = minfieldLength;
			return this ; 
		}
		public Builder maxfieldLength (int maxfieldLength   ) {
			this.maxfieldLength = maxfieldLength;
			return this ; 
		}
		
		public Field build() {
			return new Field(this);
			}

	}

	public int getId() {
		return id;
	}

	public LengthType getLengthType() {
		return lengthType;
	}

	public int getFieldLength() {
		return fieldLength;
	}

	public String getName() {
		return name;
	}

	public FieldFormatType getFieldFormat() {
		return fieldFormat;
	}

	public FieldCodificationType getFieldCodification() {
		return fieldCodification;
	}

	public LengthFormatType getLengthFormat() {
		return lengthFormat;
	}

	public int getLengthOfLengthField() {
		return lengthOfLengthField;
	}

	public int getMinfieldLength() {
		return minfieldLength;
	}




	public int getMaxfieldLength() {
		return maxfieldLength;
	}

	
    public int getFixedExpectedArrayLength(){
		/*
		 * FieldFormatType 	(NUMERIC, ANS, AN) are coded in EBCDIC or ASCII 	--> ( 1 byte x digit )
		 * 					BINARY --> ( 1 byte x digit )
		 * 					BCD    --> ( 1 byte x 2 digits )
		 * 
		 */		
		if ( getFieldFormat() 		== FieldFormatType.NUMERIC &&
			 getFieldCodification() == FieldCodificationType.BCD	){
			int datalength = getFieldLength() ; 
			if ( datalength % 2 != 0  ){
				return ( datalength / 2 ) + 1;
			}else{
				return ( datalength / 2 ) ;	
			}
		}else{
			int datalength = getFieldLength() ; 
			return datalength ;
		} 
    }

    public int getVarExpectedDataArrayLength(int length){
		/*
		 * FieldFormatType 	(NUMERIC, ANS, AN) are coded in EBCDIC or ASCII 	--> ( 1 byte x digit )
		 * 					BINARY --> ( 1 byte x digit )
		 * 					BCD    --> ( 1 byte x 2 digits )
		 * 
		 */	
    	//int datalength = length - getLengthOfLengthField();
    	int datalength = length ;
		if ( getFieldFormat() 		== FieldFormatType.NUMERIC &&
		     getFieldCodification() == FieldCodificationType.BCD	){
			 
			if ( datalength % 2 != 0  ){
				return ( datalength / 2 ) + 1;
			}else{
				return ( datalength / 2 ) ;	
			}
		}else{
			return datalength ;
		} 
    }


}
