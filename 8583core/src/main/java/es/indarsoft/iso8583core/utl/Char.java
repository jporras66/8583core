package es.indarsoft.iso8583core.utl;

import org.apache.commons.lang3.builder.* ; 

/**
 *  Char class  is a character representation in ASCII, EBCDIC and html tag for a byte <br>
 *  <br>
 *  
 */
public class Char {

	private byte 	asciihexvalue 	; 
	private byte 	ebcdichexvalue  ;
	private byte 	mappedHexvalue 	;  
	private String	htmltag	;
	private String	description	;
	private char 	attribute   ; 
	
    /** 
     * @param hexValue byte 	<br>
     * mappedHexValue = 0x00  	<br>
	 * ebcdichexValue = 0x00 	<br>
	 * attribute = 'n' 			<br> 	
     *     
     */		
	public Char(byte hexValue) {

		this.asciihexvalue = hexValue ;
		this.mappedHexvalue = 0x00 ;
		this.ebcdichexvalue = 0x00 ;
		this.attribute = 'n' ;
	}
    /** 
     * @param 	asciihexValue byte <br>
     * @param 	mappedHexValue mapped byte <br>
     * @param 	ebcdichexValue translation byte <br>
     * @param 	htmlTag  <br>
     * @param 	description  <br>
     * @param 	attribute char <br>
     * 			-	none <br>
     * 			s	special <br>
     * 			a	alphanumeric <br>
     *    		n	numeric
     */		
	public Char(byte asciihexValue, byte ebcdichexValue , byte mappedHexValue, String	htmlTag, String description, char attribute ) {

		this.asciihexvalue 		= asciihexValue ;
		this.ebcdichexvalue 	= ebcdichexValue ;
		this.mappedHexvalue 	= mappedHexValue ;		
		this.htmltag 			= htmlTag ;
		this.description		= description ;
		this.attribute 			= attribute ;
	}

	public byte getAsciihexValue() {
		return asciihexvalue;
	}
	public byte getMappedHexValue() {
		return mappedHexvalue;
	}
	public byte getEbcdichexValue() {
		return ebcdichexvalue;
	}
	public String getHtmlTag() {
		return htmltag;
	}
	public String getDescription() {
		return description;
	}
	public char getAttribute() {
		return attribute;
	}
	public void setAsciihexValue(byte asciihexValue) {
		this.asciihexvalue = asciihexValue;
	}
	public void setMappedHexValue(byte mappedHexValue) {
		this.mappedHexvalue = mappedHexValue;
	}
	public void setEbcdichexValue(byte ebcdichexValue) {
		this.ebcdichexvalue = ebcdichexValue;
	}
	public void setHtmlTag(String htmlTag) {
		this.htmltag = htmlTag;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAttribute(char attribute) {
		this.attribute = attribute;
	}    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
	
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }      
}
