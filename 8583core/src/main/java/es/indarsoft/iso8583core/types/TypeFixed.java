
package es.indarsoft.iso8583core.types;

/**
 * TypeFixed : Primitive type fixed length.
 * 
 * <p>
 * This class describe a data type of an specific length and codification
 * 
 */
public class TypeFixed extends TypeMain  {

	protected final String className = this.getClass().getSimpleName() + "." ;
	private int dataLength; 
	/**
	 * Constructor for new TypeFixed.
	 * 
	 * @param bytearr value
	 * @param field see {@link Field} 
	 * 
	 */
	public TypeFixed ( byte[] bytearr , Field field  )   {   	
        
    	super( bytearr, field) ;
    	validation();
    }
    
    private void validation(){
    	/*
    	 *      Data Length validation  	
    	 */
    	    	this.dataLength = getBytearr().length  ;
    	    	int arrlength 	= getField().getFixedExpectedArrayLength( ) ;	
    	    	if ( this.dataLength != arrlength  ) {
    	    		super.setIsvalid( false );
    	    		super.setStatusMsg( className+"dataLength invalid. Length is : " + this.dataLength + " but expected is  :  " +  arrlength ) ;
    	    		return;
    	    	}
    	    	
    	/*
    	 *  test.codification validation        
    	*/ 
    	        
    	    	boolean isvalid = super.validateFieldDataFormat( ); 
    	    	if ( ! isvalid ){
    	    		super.setIsvalid(  false );
    	    		super.setStatusMsg ( className+"validateFieldDataFormatType invalid. Codification is : " + super.getFieldFormat().toString() ) ;
    	    		return;
    	    	}    	
    	
    }
	public int getDataLength() {
		return this.dataLength ;
	}
    
}
