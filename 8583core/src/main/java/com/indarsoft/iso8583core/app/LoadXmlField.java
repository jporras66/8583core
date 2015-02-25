package com.indarsoft.iso8583core.app;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Stack;

import com.indarsoft.utl.Utl;

import org.apache.log4j.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthFormatType;
import com.indarsoft.iso8583core.types.LengthType;

public class LoadXmlField extends DefaultHandler {

	static Logger log = 				Logger.getLogger( LoadXmlField.class.getName() );
	private Stack<String> 				elementStack = new Stack<String>();
	private Field 						field;
	private String 						appname ="";
	private FieldFormatType 			fieldFormatType;
	private FieldCodificationType 		fieldCodificationType;
	private LengthFormatType 			lengthFormatType;
	private Hashtable<Integer, Field> 	htf = new Hashtable<Integer, Field>(); 

	public AppBean parseIso8583Xml(String iso8583Xmlfilename ) {
	
		// get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse(iso8583Xmlfilename, this);
		} catch (SAXException se) {
			log.error ( "SAXException :  "  + se.getMessage() ) ;
			return null ; 
		} catch (ParserConfigurationException pce) {
			log.error ( "ParserConfigurationException :  "  + pce.getMessage() ) ;
			return null ; 
		} catch (IOException ie) {
			log.error ( "ParserConfigurationException :  "  + ie.getMessage() ) ;
			return null ; 
		}
		
		if ( appname == null ) {
			throw new IllegalArgumentException("Invalid APPNAME");
		}
		/*if ( fieldFormatType == null ) {
			throw new IllegalArgumentException("Invalid fieldFormatType");
		}*/
		if ( fieldCodificationType == null ) {
			throw new IllegalArgumentException("Invalid fieldCodificationType");
		}
		if ( lengthFormatType == null) {
			throw new IllegalArgumentException("Invalid lengthFormatType");
		}
		AppBean appdata = AppBean.getInstance( appname , fieldFormatType, fieldCodificationType, lengthFormatType, htf);
		return appdata ;
	}
	
/** 
 *  First load default values & all fields defined at APP level 
 *  Second read all fields defined at iso8583 level. Existing fields loaded yet are not UPDATED !!!
 * 	
 * @param 	appXmlfilename
 * @return	AppData
 */
	public AppBean parseAppXml(String appXmlfilename , String iso8583Xmlfilename) {

		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse(appXmlfilename, this);
		} catch (SAXException se) {
			log.error ( "SAXException :  "  + se.getMessage() ) ;
			return null ; 
		} catch (ParserConfigurationException pce) {
			log.error ( "ParserConfigurationException :  "  + pce.getMessage() ) ;
			return null ; 
		} catch (IOException ie) {
			log.error ( "ParserConfigurationException :  "  + ie.getMessage() ) ;
			return null ; 
		}
		
		return parseIso8583Xml( iso8583Xmlfilename ) ;
		
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// reset

		if (qName.equalsIgnoreCase("APP")) {
			saveApp(qName, attributes);
			this.elementStack.push(qName);
			return;
		}

		if (qName.equalsIgnoreCase("field")) {
			int length = attributes.getLength();
			this.elementStack.push(qName);
			this.field = saveField(qName, attributes);
			if (length < 2) {
				log.debug ( "invalid field" + qName + attributes.toString() ) ;
				return;
			}
			
			/*if ( appdata.getField( this.field.getId() ) == null ){ // if not exist ---> 	insert
				appdata.putField( this.field ); 
			}*/
			if ( htf.get( this.field.getId() ) == null ){ // if not exist ---> 	insert
				 htf.put(this.field.getId(),  this.field ); 
			}
 
			return;
		}
		//
		if (qName.equalsIgnoreCase("defaultfieldFormat")) {
			this.elementStack.push(qName);
			return;
		}
		
		if (qName.equalsIgnoreCase("defaultFieldCodification")) {
			this.elementStack.push(qName);
			return;
		}

		if (qName.equalsIgnoreCase("defaultLengthFormat")) {
			this.elementStack.push(qName);
			return;
		}

		if (qName.equalsIgnoreCase("Value")) {
			this.elementStack.push(qName);
			return;
		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
	
		if( ( "value".equalsIgnoreCase( qName ) ) ){
			@SuppressWarnings("unused")
			String str = elementStack.pop() ;
			return ;
		}
		
		if( ( "defaultfieldFormat".equalsIgnoreCase( qName ) ) ){
			@SuppressWarnings("unused")
			String str = elementStack.pop() ;
			return ;
		}
		
		if( ( "defaultFieldCodification".equalsIgnoreCase( qName ) ) ){
			@SuppressWarnings("unused")
			String str = elementStack.pop() ;
			return ;
		}
		
		if( ( "defaultLengthFormat".equalsIgnoreCase( qName ) ) ){
			@SuppressWarnings("unused")
			String str = elementStack.pop() ;
			return ;
		}
		
		if( ( "field".equalsIgnoreCase( qName ) ) ){
			@SuppressWarnings("unused")
			String str 	= elementStack.pop() ;
			return ;
		}
		
		if( ( "APP".equalsIgnoreCase( qName ) ) ){
			@SuppressWarnings("unused")
			String str = elementStack.pop() ;
			return ;
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String value = new String(ch, start, length).trim();
		if (value.length() == 0)
			return; // ignore white space

		String cep = currentElementParent();
		String ce = currentElement();

		if (("defaultfieldFormat".equalsIgnoreCase(cep))
				&& ("value".equalsIgnoreCase(ce))) {
			
			//if ( appdata.getDefaultfieldFormat() == null ){
			//	appdata.setDefaultfieldFormat( FieldFormatType.getInstance(value) );
			if ( fieldFormatType == null ){
				fieldFormatType = FieldFormatType.getInstance(value) ;				
			}
			
			return;
		}
		
		if (("defaultLengthFormat".equalsIgnoreCase(cep))
				&& ("value".equalsIgnoreCase(ce))) {
			
			//if ( appdata.getDefaultLengthFormat() == null){
			//	appdata.setDefaultLengthFormat( LengthFormatType.getInstance(value) );
			if ( lengthFormatType == null){
				lengthFormatType = LengthFormatType.getInstance(value) ;				
			}
			
			return;
		}
		if (("defaultFieldCodification".equalsIgnoreCase(cep))
				&& ("value".equalsIgnoreCase(ce))) {
			
			//if ( appdata.getDefaultDataCodification() == null ) {
			//	appdata.setDefaultDataCodification ( FieldCodificationType.getInstance(value) );	
			if ( fieldCodificationType == null ) {
				fieldCodificationType = FieldCodificationType.getInstance(value) ;				
			}
			
			return;
		}
	}

	private String currentElement() {
		String str = this.elementStack.peek();
		return str;
	}

	private String currentElementParent() {
		if (this.elementStack.size() < 2)
			return null;
		return this.elementStack.get(this.elementStack.size() - 2);
	}

	private void saveApp(String qName, Attributes attributes) {
		int length = attributes.getLength();
		for (int i = 0; i < length; i++) {
			String name = attributes.getQName(i);
			String value = attributes.getValue(i);
			
			//if (name.equalsIgnoreCase("APLNAME") && appdata.getAppName().isEmpty() )
			if (name.equalsIgnoreCase("APLNAME") && appname.isEmpty() )				
				//appdata.setAppName(value);
				appname = value ;
			;
		}
	}

	private Field saveField(String qName, Attributes attributes) {
//
		 int 					id = 0;
		 LengthType				lengthType = null  ;
		 String 				name  = "";
		 FieldFormatType		fieldFormat = null; 
		 int 					fieldLength = 0 ;
		 FieldCodificationType 	fieldCodification = null ; 
		 LengthFormatType 		lengthFormat = null ;
		 int 					lengthOfLengthField = 0 ; 	
		 int 					minfieldLength = 0 ;
		 int 					maxfieldLength = 0;	
//		
		int length = attributes.getLength();
		//
		for (int i = 0; i < length; i++) {
			String nameval = attributes.getQName(i);
			String value = attributes.getValue(i);

			if (nameval.equalsIgnoreCase("id"))
				if (value.substring(0, 1).equals("-")) {
					String str = value.substring(1);
					id = Integer.parseInt(str) * -1;
				} else {
					id = Integer.parseInt(value) ;
				}

			if (nameval.equalsIgnoreCase("lengthType"))
				lengthType =  LengthType.getInstance(value) ;
			if (nameval.equalsIgnoreCase("fieldLength"))
				fieldLength =  Integer.parseInt(value) ;
			if (nameval.equalsIgnoreCase("name"))
				name =  value ;			
			if (nameval.equalsIgnoreCase("fieldFormat"))
				fieldFormat = FieldFormatType.getInstance(value) ;
			if (nameval.equalsIgnoreCase("fieldCodification"))
				fieldCodification = FieldCodificationType.getInstance(value) ;
//		
			if (nameval.equalsIgnoreCase("lengthFormat"))
				lengthFormat =  LengthFormatType.getInstance(value)  ;
			if (nameval.equalsIgnoreCase("lengthOfLengthField"))
				lengthOfLengthField = Integer.parseInt(value)  ; 
			if (nameval.equalsIgnoreCase("minfieldLength"))
				minfieldLength = Integer.parseInt(value) ;
			if (nameval.equalsIgnoreCase("maxfieldLength"))
				maxfieldLength = Integer.parseInt(value) ;
		}
		
		/* if fieldCodification == null :
		 * 
		 * 		if fieldFormtaType ==  NUMERIC, AN, ANS ---> assign default appdata.getDefaultDataCodification()
		 */
		if ( ( fieldCodification == null) && 
			   (  fieldFormat== FieldFormatType.NUMERIC
			   || fieldFormat == FieldFormatType.AN  
			   || fieldFormat == FieldFormatType.ANS ) 	) {
			//fieldCodification = appdata.getDefaultDataCodification() ;
			fieldCodification = this.fieldCodificationType ;
		}
		/*
		 * For variable length field:
		 * 
		 * If lengthFormat == null  ---> assign appdata.getDefaultLengthFormat()
		 */		
		if ( (lengthType == LengthType.V) && (lengthFormat == null) ) {
			//lengthFormat =  appdata.getDefaultLengthFormat();
			lengthFormat =  this.lengthFormatType;
		}
		
//
		Field field = new Field.Builder().
						id(					id				).
						lengthType(			lengthType		).
						name(				name			).
						fieldFormat(		fieldFormat		).
						fieldLength(		fieldLength		).
						fieldCodification(	fieldCodification).
						lengthFormat(		lengthFormat	).
						lengthOfLengthField(lengthOfLengthField).
						minfieldLength(		minfieldLength	).
						maxfieldLength(		maxfieldLength	).build() ;
//		
		/*if ( log.isDebugEnabled()  ) {
			displayField( field ) ;
		}*/
		return field;
	}

	@SuppressWarnings("unused")
	private void displayField( Field field ){

		log.debug ( "field name -------- : " + field.getName() ) ;
		log.debug ( "id                  : " + field.getId() ) ;
		log.debug ( "lengthType          : " + field.getLengthType() ) ;
		log.debug ( "fieldLength         : " + field.getFieldLength() ) ;
		log.debug ( "fieldFormat         : " + field.getFieldFormat() ) ;
		log.debug ( "fieldCodification   : " + field.getFieldCodification() ) ;
		log.debug ( "lengthFormat        : " + field.getLengthFormat() ) ;
		log.debug ( "lengthOfLengthField : " + field.getLengthOfLengthField() ) ;
		log.debug ( "minfiledLength      : " + field.getMinfieldLength() ) ;
		log.debug ( "maxfiledLength      : " + field.getMaxfieldLength() ) ;	
		
	}
	public static void main(String[] args) {
		LoadXmlField spe = new LoadXmlField();
		String separator = File.separator;
		String pwd = Utl.getPwd() ;
		String xmlfilename = pwd + separator + "config" + separator + "iso8583core.xml";
		log.debug ( "iso8583Xmlfilename ----------> : " + xmlfilename) ;
		spe.parseIso8583Xml( xmlfilename );
	}

}