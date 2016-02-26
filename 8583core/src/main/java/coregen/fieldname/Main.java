package coregen.fieldname;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.indarsoft.utl.Utl;
import com.indarsoft.iso8583core.app.AppBean;
import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.app.ApplicationFactory;
import com.indarsoft.iso8583core.app.Config;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.LengthType;
/**
 * Java source generator for package com.indarsoft.iso8583core.coretypes.
 * <p>
 * <pre>
 * &lt;APLDIR&gt;/coregen: with the following structure
 * 			template: Stored templates to generate java classes ( CoretypesFactory.java and Fxxx data types ).
 * 			save    : Java classes in this directory are copied unchanged.
 * 			tmp     : Directory to store generated Java classes.
 * &lt;APLDIR&gt;/config :
 * 			Stores different *.properties and *.xml files 
 * 
 * Before execute review :
 * 
 * 		&lt;APLDIR&gt; : Base directory where the directory structure &lt;APLDIR&gt;/coregen and config is expected  
 *          DIR = "C:"+sep+"DATOS"+sep+"E"+sep+"workspace"+sep+"8583core";
 *      CONFIGFILE 	: 
 *      	CONFIGFILE = "main.properties";
 *      	This file containts the configuration XML file for ISO8583 (standard ).
 *</pre>        
 * @author fjavier.porras@gmail.com
 *
 */
public class Main {

	private static String sep 			= File.separator;
	private static String PATH			= Utl.getPwd();
	private static String INPUTPATH  	= PATH+sep+"coregen"+sep+"template" + sep  ;
	private static String SAVED      	= PATH+sep+"coregen"+sep+"save" + sep  ;
	private static String OUTPUTPATH 	= PATH+sep+"coregen"+sep+"tmp"+sep;
	private String fixedTemplate  		= INPUTPATH + "coretypes_fixed_template.txt";
	private String varTemplate  		= INPUTPATH + "coretypes_var_template.txt";
	StringBuffer sbuf 					= new StringBuffer();
	StringBuffer ftbuf 					= new StringBuffer();
//	
	public static void main(String[] args) {
			
		Main gntyp = new Main() ;
		
		String CONFIGFILE = "main.properties";
		String APL_DIR = "C:"+sep+"DATOS"+sep+"E"+sep+"workspace"+sep+"8583core";
		
		Config cfg = new Config( APL_DIR , CONFIGFILE );
		
		Application app = ApplicationFactory.getMain( cfg ) ;
		AppBean		appdata = app.getAppBean();
//			
		gntyp.factoryHeader( "coretypes_factory_header_template",".txt");
		gntyp.factoryTemplate( "coretypes_factory_template",".txt");
//			
		for ( int i= 0; i<129; i++){
			Field field = appdata.getField( i );
			if ( ! ( field == null  ||  field.getId() == 36 ||
				 ( field.getId() > 55   && field.getId() <= 59  ) ||			// generate Field 55
				 ( field.getId() > 61   && field.getId() < 63)    ||			// generate Field 61 Reserved Private
				 ( field.getId() >= 105 && field.getId() <= 112)  ||
				 ( field.getId() >= 114 && field.getId() <= 123)  || field.getId() == 127)  ) 
			{
				System.out.println( "processing fieldid : " + field.getId() );
				if (field.getId()  == 0) gntyp.copyFile("F0Mti",".java");
				else
				if (field.getId()  == 1) gntyp.copyFile("F1Bitmap",".java");
				else
				if (field.getId()  == 2) gntyp.copyFile("F2PrimaryAccountNumber",".java");
				else
				if (field.getId()  == 35) gntyp.copyFile("F35Track2",".java");
				else{
					if (field.getLengthType() == LengthType.F) {
						String tmp = capitalize ( field.getName() );
						tmp	= tmp.replaceAll(",", "");
						tmp	= tmp.replaceAll("\\.", "");
						tmp	= tmp.replaceAll(" ", "");
						String outputFilename = "F"+field.getId()+tmp ;
						gntyp.generateTypeFixed( gntyp.fixedTemplate, outputFilename,field.getId(), ".java");
					}else
					if ( field.getLengthType() == LengthType.V ){
						String tmp = capitalize ( field.getName() );
						tmp	= tmp.replaceAll(",", "");
						tmp	= tmp.replaceAll("\\.", "");
						tmp	= tmp.replaceAll(" ", "");
						String outputFilename = "F"+field.getId()+tmp ;
						gntyp.generateTypeVar( gntyp.varTemplate, outputFilename,field.getId(), ".java");
					}else{
						System.out.println( "Not processed fieldid : " + field.getId() );
					}
				}		
			}
		}
			gntyp.factoryFooter();
			gntyp.generateFactory( "CoreTypesFactory",".java");
	}
	
	private void generateTypeFixed( String filename, String text, int fieldid, String extension ){
		
		Path templatepath 	= Paths.get( filename );
		Path outputfilename = Paths.get( OUTPUTPATH + text + extension );
		
		Charset charset = StandardCharsets.UTF_8;
		String  fieldidstr = String.valueOf(  fieldid ) ;
		String content="";
		try {
			content = new String( Files.readAllBytes(templatepath), charset );
			content = content.replaceAll("<CLASSNAME>", text );
			content = content.replaceAll("<FIELDID>", fieldidstr );
			addFactory ( text , fieldid );
			Files.write( outputfilename , content.getBytes(charset) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void generateTypeVar( String filename, String text, int fieldid, String extension){
		
		Path templatepath 	= Paths.get( filename );
		Path outputfilename = Paths.get( OUTPUTPATH + text + extension );
		
		Charset charset = StandardCharsets.UTF_8;
		String  fieldidstr = String.valueOf(  fieldid ) ;
		String content="";
		try {
			content = new String( Files.readAllBytes(templatepath), charset );
			content = content.replaceAll("<CLASSNAME>", text );
			content = content.replaceAll("<FIELDID>", fieldidstr );
			addFactory ( text , fieldid );
			Files.write( outputfilename , content.getBytes(charset) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void generateFactory( String text, String extension){
		
		Path outputfilename = Paths.get( OUTPUTPATH + text + extension );
		Charset charset = StandardCharsets.UTF_8;

		try {
			String tmp = sbuf.toString().trim(); 
			Files.write( outputfilename , tmp.getBytes(charset) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String capitalize(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
        sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
        }          
      return sb.toString().trim();
    }  
	
	private void addFactory ( String classname , int fieldid ) {
		
		String fieldidstr = Integer.toString( fieldid );
		if ( fieldid == 1 || fieldid == 2 ) return  ; 
		String dummy  	= ftbuf.toString() ;
		String dummy2 	= dummy.replaceAll("<FIELID>", fieldidstr );
		String outstr 	= dummy2.replaceAll("<CLASSNAME>", classname );
	    //
	    
		sbuf.append( outstr ) ;
		
	}
	
	private void  factoryHeader(  String filename, String extension ){
		
		Path templatepath 	= Paths.get( INPUTPATH  + sep + filename + extension );
		Charset charset = StandardCharsets.UTF_8;
		String content="";
		try {
			content = new String( Files.readAllBytes(templatepath), charset );
			sbuf.append ( content );
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private void  factoryTemplate(  String filename, String extension ){
		
		Path templatepath 	= Paths.get( INPUTPATH  + sep + filename + extension );
		Charset charset = StandardCharsets.UTF_8;
		String content="";
		try {
			content = new String( Files.readAllBytes(templatepath), charset );
			ftbuf.append ( content );
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private void  factoryFooter(){
		
		String ff = "}" + "\n";
		sbuf.append ( ff );
	}	

		private void copyFile( String filename, String extension) {
			
			Path templatepath 	= Paths.get( SAVED  + sep + filename + extension );
			Path outputfilename = Paths.get( OUTPUTPATH + sep + filename + extension );
			
			Charset charset = StandardCharsets.UTF_8;
			String content="";
			try {
				content = new String( Files.readAllBytes(templatepath), charset );
				Files.write( outputfilename , content.getBytes(charset) );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
}
