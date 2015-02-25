package com.indarsoft.iso8583core.message;

import java.util.Arrays;
import java.util.Hashtable;
import org.apache.log4j.Logger;
import com.indarsoft.utl.Ascii;
import com.indarsoft.utl.Binary;
import com.indarsoft.utl.Ebcdic;
import com.indarsoft.utl.ArrayUtl;
import com.indarsoft.iso8583core.app.Application;
import com.indarsoft.iso8583core.coretypes.*;
import com.indarsoft.iso8583core.types.Field;
import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.FieldFormatType;
import com.indarsoft.iso8583core.types.LengthFormatType;
import com.indarsoft.iso8583core.types.LengthType;
import com.indarsoft.iso8583core.types.TypeMain;

public class IsoLoadFields {

	protected static Logger log = Logger.getLogger(IsoLoadFields.class.getName());
	private byte[] bytearr;
	private int startpointer 		= 0;
	private int endpointer 			= 0;
	private String bitmapStr 		= "";
	private Application app 		= null;
	private CoreTypesFactory ctf 	= null;

	protected IsoLoadFields(byte[] bytearr, Application app) {
		this.bytearr = bytearr;
		this.app = app;
		this.ctf = new CoreTypesFactory(app);
	}

	protected byte[] loadFieldDataArray(Field field) {

		byte[] bar = dataArray(bytearr, field, startpointer);
		endpointer = startpointer + bar.length;
		startpointer = endpointer;
		return bar;
	}
	
	protected static byte[] dataArray(byte[] bytearr, Field field, int startpointer) {

		byte[] bar = null;
		if (field.getLengthType() == LengthType.F) {
			bar = byteArrayFixedField(bytearr, field, startpointer);
		}

		if (field.getLengthType() == LengthType.V) {
			bar = byteArrayVarField(bytearr, field, startpointer);
		}
		return bar;
	}
	
	protected static byte[] byteArrayFixedField(byte[] bytearr, Field field, int startpointer) {

		int endpointer = startpointer + field.getFixedExpectedArrayLength();
		return Arrays.copyOfRange(bytearr, startpointer, endpointer);
	}

	protected static byte[] byteArrayVarField(byte[] bytearr, Field field,
			int startpointer) {

		int length = 0;
		int lengthdigits = field.getLengthOfLengthField();
		int endpointer = 0;

		byte[] lengtharr = Arrays.copyOfRange(bytearr, startpointer,
				startpointer + lengthdigits);

		if (field.getLengthFormat() == LengthFormatType.BINARY) {
			length = Binary.toInt(lengtharr);
		}
		if (field.getLengthFormat() == LengthFormatType.ASCII) {
			length = Ascii.toInt(lengtharr);
		}
		if (field.getLengthFormat() == LengthFormatType.EBCDIC) {
			length = Ebcdic.toInt(lengtharr);
		}
		boolean isodd = (length % 2 != 0);

		if (field.getFieldFormat() != FieldFormatType.BINARY
				&& field.getFieldCodification() == FieldCodificationType.BCD) {
			if (isodd)
				endpointer = startpointer + lengthdigits + (length / 2) + 1;
			if (!isodd)
				endpointer = startpointer + lengthdigits + (length / 2);
		} else {
			endpointer = startpointer + lengthdigits + length;
		}
		return Arrays.copyOfRange(bytearr, startpointer, endpointer);
	}


	protected TypeMain getBitmappedFieldId(int fieldid) {

		// Field field = app.getAppData().getField( fieldid ) ;
		/*
		 * if ( field != null ) { log.debug ( "Id() - Field id : " +
		 * field.getId() + "-" + field.getLengthType() +"-"+ field.getName() );
		 * }else{ log.debug ( "Id() - Field id : " + fieldid + "-" +
		 * "Not configured xml" ); }
		 */
		switch (fieldid) {
		case 2:
			return loadF002();
		case 3:
			return loadF003();
		case 4:
			return loadF004();
		case 5:
			return loadF005();
		case 7:
			return loadF007();
		case 9:
			return loadF009();
		case 10:
			return loadF010();
		case 11:
			return loadF011();			
		case 12:
			return loadF012();
		case 13:
			return loadF013();
		case 14:
			return loadF014();
		case 15:
			return loadF015();
		case 16:
			return loadF016();
		case 17:
			return loadF017();			
		case 18:
			return loadF018();
		case 19:
			return loadF019();
		case 20:
			return loadF020();
		case 21:
			return loadF021();			
		case 22:
			return loadF022();
		case 23:
			return loadF023();
		case 25:
			return loadF025();
		case 28:
			return loadF028();
		case 31:
			return loadF031();			
		case 32:
			return loadF032();
		case 33:
			return loadF033();
		case 35:
			return loadF035();
		case 37:
			return loadF037();
		case 38:
			return loadF038();
		case 39:
			return loadF039();
		case 41:
			return loadF041();
		case 42:
			return loadF042();
		case 43:
			return loadF043();
		case 44:
			return loadF044();
		case 48:
			return loadF048();
		case 49:
			return loadF049();
		case 50:
			return loadF050();
		case 51:
			return loadF051();
		case 52:
			return loadF052();
		case 53:
			return loadF053();
		case 54:
			return loadF054();
		case 55:
			return loadF055();
		case 60:
			return loadF060();
		case 61:
			return loadF061();
		case 63:
			return loadF063();
		case 90:
			return loadF090();
		case 95:
			return loadF095();
		case 125:
			return loadF125();
		case 126:
			return loadF126();
		default:
			log.debug("getBitmappedFieldId can not find filedid" + fieldid );
			return null;
		}
	}

	protected Hashtable<Integer, TypeMain> getBitmappedFields() {

		Hashtable<Integer, TypeMain> htotmp = new Hashtable<Integer, TypeMain>();
		for (int i = 1; i < this.bitmapStr.length(); i++) {
			if (this.bitmapStr.charAt(i) == '1') {
				TypeMain data = getBitmappedFieldId(i + 1);
				htotmp.put(data.getFieldId(), data);
			}
		}
		return htotmp;
	}

	private F000 loadF000() {

		Field field = app.getAppBean().getField(0);
		byte[] bar = loadFieldDataArray(field);
		F000 data = ctf.getF000(bar);

		return data;
	}

	private F001 loadF001( F001.Ordinal ordinal ) {

		Field field = app.getAppBean().getField(1);
		byte[] bar = loadFieldDataArray(field);
		F001 data = ctf.getF001(bar, ordinal);
		log.debug( " F001 : " + Binary.toHexStr(bar) ) ;
		return data;
	}

	private F002 loadF002() {

		Field field = app.getAppBean().getField(2);
		byte[] bar = loadFieldDataArray(field);
		F002 data = ctf.getF002(bar);
		log.debug(" F002 : " + data.toString());

		return data;
	}

	private F003 loadF003() {

		Field field = app.getAppBean().getField(3);
		byte[] bar = loadFieldDataArray(field);
		F003 data = ctf.getF003(bar);
		log.debug(" F003 : " + data.toString());

		return data;
	}

	private F004 loadF004() {

		Field field = app.getAppBean().getField(4);
		byte[] bar = loadFieldDataArray(field);
		F004 data = ctf.getF004(bar);
		log.debug(" F004 : " + data.toString());

		return data;
	}

	private F005 loadF005() {

		Field field = app.getAppBean().getField(5);
		byte[] bar = loadFieldDataArray(field);
		F005 data = ctf.getF005(bar);
		log.debug(" F005 : " + data.toString());

		return data;
	}

	private F007 loadF007() {

		Field field = app.getAppBean().getField(7);
		byte[] bar = loadFieldDataArray(field);
		F007 data = ctf.getF007(bar);
		log.debug(" F007 : " + data.toString());

		return data;
	}

	private F009 loadF009() {

		Field field = app.getAppBean().getField(9);
		byte[] bar = loadFieldDataArray(field);
		F009 data = ctf.getF009(bar);
		log.debug(" F009 : " + data.toString());

		return data;
	}

	private F010 loadF010() {

		Field field = app.getAppBean().getField(10);
		byte[] bar = loadFieldDataArray(field);
		F010 data = ctf.getF010(bar);
		log.debug(" F010 : " + data.toString());

		return data;
	}
	private F011 loadF011() {

		Field field = app.getAppBean().getField(11);
		byte[] bar = loadFieldDataArray(field);
		F011 data = ctf.getF011(bar);
		log.debug(" F011 : " + data.toString());

		return data;
	}

	private F012 loadF012() {

		Field field = app.getAppBean().getField(12);
		byte[] bar = loadFieldDataArray(field);
		F012 data = ctf.getF012(bar);
		log.debug(" F012 : " + data.toString());

		return data;
	}

	private F013 loadF013() {

		Field field = app.getAppBean().getField(13);
		byte[] bar = loadFieldDataArray(field);
		F013 data = ctf.getF013(bar);
		log.debug(" F013 : " + data.toString());

		return data;
	}

	private F014 loadF014() {

		Field field = app.getAppBean().getField(14);
		byte[] bar = loadFieldDataArray(field);
		F014 data = ctf.getF014(bar);
		log.debug(" F014 : " + data.toString());

		return data;
	}

	private F015 loadF015() {

		Field field = app.getAppBean().getField(15);
		byte[] bar = loadFieldDataArray(field);
		F015 data = ctf.getF015(bar);
		log.debug(" F015 : " + data.toString());

		return data;
	}

	private F016 loadF016() {

		Field field = app.getAppBean().getField(16);
		byte[] bar = loadFieldDataArray(field);
		F016 data = ctf.getF016(bar);
		log.debug(" F016 : " + data.toString());

		return data;
	}
	
	private F017 loadF017() {

		Field field = app.getAppBean().getField(17);
		byte[] bar = loadFieldDataArray(field);
		F017 data = ctf.getF017(bar);
		log.debug(" F017 : " + data.toString());

		return data;
	}	

	private F018 loadF018() {

		Field field = app.getAppBean().getField(18);
		byte[] bar = loadFieldDataArray(field);
		F018 data = ctf.getF018(bar);
		log.debug(" F018 : " + data.toString());

		return data;
	}

	private F019 loadF019() {

		Field field = app.getAppBean().getField(19);
		byte[] bar = loadFieldDataArray(field);
		F019 data = ctf.getF019(bar);
		log.debug(" F019 : " + data.toString());

		return data;
	}

	private F020 loadF020() {

		Field field = app.getAppBean().getField(20);
		byte[] bar = loadFieldDataArray(field);
		F020 data = ctf.getF020(bar);
		log.debug(" F020 : " + data.toString());

		return data;
	}

	private F021 loadF021() {

		Field field = app.getAppBean().getField(21);
		byte[] bar = loadFieldDataArray(field);
		F021 data = ctf.getF021(bar);
		log.debug(" F021 : " + data.toString());

		return data;
	}	
	
	private F022 loadF022() {

		Field field = app.getAppBean().getField(22);
		byte[] bar = loadFieldDataArray(field);
		F022 data = ctf.getF022(bar);
		log.debug(" F022 : " + data.toString());

		return data;
	}

	private F023 loadF023() {

		Field field = app.getAppBean().getField(23);
		byte[] bar = loadFieldDataArray(field);
		F023 data = ctf.getF023(bar);
		log.debug(" F023 : " + data.toString());

		return data;
	}

	private F025 loadF025() {

		Field field = app.getAppBean().getField(25);
		byte[] bar = loadFieldDataArray(field);
		F025 data = ctf.getF025(bar);
		log.debug(" F025 : " + data.toString());

		return data;
	}

	private F028 loadF028() {

		Field field = app.getAppBean().getField(28);
		byte[] bar = loadFieldDataArray(field);
		F028 data = ctf.getF028(bar);
		log.debug(" F028 : " + data.toString());

		return data;
	}

	private F031 loadF031() {

		Field field = app.getAppBean().getField(31);
		byte[] bar = loadFieldDataArray(field);
		F031 data = ctf.getF031(bar);
		log.debug(" F031 : " + data.toString());

		return data;
	}
	
	private F032 loadF032() {

		Field field = app.getAppBean().getField(32);
		byte[] bar = loadFieldDataArray(field);
		F032 data = ctf.getF032(bar);
		log.debug(" F032 : " + data.toString());

		return data;
	}	

	private F033 loadF033() {

		Field field = app.getAppBean().getField(33);
		byte[] bar = loadFieldDataArray(field);
		F033 data = ctf.getF033(bar);
		log.debug(" F033 : " + data.toString());

		return data;
	}

	private F035 loadF035() {

		Field field = app.getAppBean().getField(35);
		byte[] bar = loadFieldDataArray(field);
		F035 data = ctf.getF035(bar);
		log.debug(" F035 : " + data.getTrack2());

		return data;
	}

	private F037 loadF037() {

		Field field = app.getAppBean().getField(37);
		byte[] bar = loadFieldDataArray(field);
		F037 data = ctf.getF037(bar);
		log.debug(" F037 : " + data.toString());

		return data;
	}

	private F038 loadF038() {

		Field field = app.getAppBean().getField(38);
		byte[] bar = loadFieldDataArray(field);
		F038 data = ctf.getF038(bar);
		log.debug(" F038 : " + data.toString());

		return data;
	}

	private F039 loadF039() {

		Field field = app.getAppBean().getField(39);
		byte[] bar = loadFieldDataArray(field);
		F039 data = ctf.getF039(bar);
		log.debug(" F039 : " + data.toString());

		return data;
	}

	private F041 loadF041() {

		Field field = app.getAppBean().getField(41);
		byte[] bar = loadFieldDataArray(field);
		F041 data = ctf.getF041(bar);
		log.debug(" F041 : " + data.toString());

		return data;
	}

	private F042 loadF042() {

		Field field = app.getAppBean().getField(42);
		byte[] bar = loadFieldDataArray(field);
		F042 data = ctf.getF042(bar);
		log.debug(" F042 : " + data.toString());

		return data;
	}

	private F043 loadF043() {

		Field field = app.getAppBean().getField(43);
		byte[] bar = loadFieldDataArray(field);
		F043 data = ctf.getF043(bar);
		log.debug(" F043 : " + data.toString());

		return data;
	}

	private F044 loadF044() {

		Field field = app.getAppBean().getField(44);
		byte[] bar = loadFieldDataArray(field);
		F044 data = ctf.getF044(bar);
		log.debug(" F044 : " + data.toString());

		return data;
	}

	private F048 loadF048() {
		Field field = app.getAppBean().getField(48);
		byte[] bar = loadFieldDataArray(field);
		F048 data = ctf.getF048(bar);
		log.debug(" F048 : " + data.toString());

		return data;
	}

	private F049 loadF049() {
		Field field = app.getAppBean().getField(49);
		byte[] bar = loadFieldDataArray(field);
		F049 data = ctf.getF049(bar);
		log.debug(" F049 : " + data.toString());

		return data;
	}

	private F050 loadF050() {
		Field field = app.getAppBean().getField(50);
		byte[] bar = loadFieldDataArray(field);
		F050 data = ctf.getF050(bar);
		log.debug(" F050 : " + data.toString());

		return data;
	}

	private F051 loadF051() {
		Field field = app.getAppBean().getField(51);
		byte[] bar = loadFieldDataArray(field);
		F051 data = ctf.getF051(bar);
		log.debug(" F051 : " + data.toString());

		return data;
	}

	private F052 loadF052() {
		Field field = app.getAppBean().getField(52);
		byte[] bar = loadFieldDataArray(field);
		F052 data = ctf.getF052(bar);
		log.debug(" F052 : " + data.toString());

		return data;
	}

	private F053 loadF053() {
		Field field = app.getAppBean().getField(53);
		byte[] bar = loadFieldDataArray(field);
		F053 data = ctf.getF053(bar);
		log.debug(" F053 : " + data.toString());

		return data;
	}

	private F054 loadF054() {
		Field field = app.getAppBean().getField(54);
		byte[] bar = loadFieldDataArray(field);
		F054 data = ctf.getF054(bar);
		log.debug(" F054 : " + data.toString());

		return data;
	}

	private F055 loadF055() {
		Field field = app.getAppBean().getField(55);
		byte[] bar = loadFieldDataArray(field);
		F055 data = ctf.getF055(bar);
		log.debug(" F055 : " + data.toString());

		return data;
	}

	private F060 loadF060() {
		Field field = app.getAppBean().getField(60);
		byte[] bar = loadFieldDataArray(field);
		F060 data = ctf.getF060(bar);
		log.debug(" F060 : " + data.toString());

		return data;
	}

	private F061 loadF061() {
		Field field = app.getAppBean().getField(61);
		byte[] bar = loadFieldDataArray(field);
		F061 data = ctf.getF061(bar);
		log.debug(" F061 : " + data.toString());

		return data;
	}

	private F063 loadF063() {
		Field field = app.getAppBean().getField(63);
		byte[] bar = loadFieldDataArray(field);
		F063 data = ctf.getF063(bar);
		log.debug(" F063 : " + data.toString());

		return data;
	}

	private F090 loadF090() {
		Field field = app.getAppBean().getField(90);
		byte[] bar = loadFieldDataArray(field);
		F090 data = ctf.getF090(bar);
		log.debug(" F090 : " + data.toString());

		return data;
	}

	private F095 loadF095() {
		Field field = app.getAppBean().getField(95);
		byte[] bar = loadFieldDataArray(field);
		F095 data = ctf.getF095(bar);
		log.debug(" F095 : " + data.toString());

		return data;
	}

	private F125 loadF125() {
		Field field = app.getAppBean().getField(125);
		byte[] bar = loadFieldDataArray(field);
		F125 data = ctf.getF125(bar);
		log.debug(" F125 : " + data.toString());

		return data;
	}

	private F126 loadF126() {
		Field field = app.getAppBean().getField(126);
		byte[] bar = loadFieldDataArray(field);
		F126 data = ctf.getF126(bar);
		log.debug(" F126 : " + data.toString());

		return data;
	}

	protected Hashtable<Integer, TypeMain> notbitmappedFields() {

		Hashtable<Integer, TypeMain> htfieldtmp = new Hashtable<Integer, TypeMain>();

		F000 mti = loadF000();
		htfieldtmp.put(mti.getFieldId(), mti);
		log.debug(" MTI  : " + mti.toString());
		//
		F001 bitmap = loadF001(F001.Ordinal.FIRST);
		htfieldtmp.put(bitmap.getFieldId(), bitmap);
		//
		this.bitmapStr = bitmap.getBitmapStr();
		log.debug(" F001 : " + bitmap.getBitmapStr());
		//
		if (bitmap.hasAnotherBitmap()) {
			F001 secondbitmap = loadF001(F001.Ordinal.SECOND);
			this.bitmapStr = bitmapStr + secondbitmap.getBitmapStr();
			htfieldtmp.put(secondbitmap.getFieldId(), secondbitmap);
			log.debug(" F001 secondBitmap : " + secondbitmap.getBitmapStr());
			//
			byte[] bar = ArrayUtl.concat(bitmap.getBytearr(),
					secondbitmap.getBytearr());
			// bitmap = F001.get( bar, F001.Ordinal.SECOND ) ;
			bitmap = ctf.getF001(bar, F001.Ordinal.SECOND);
			this.bitmapStr = bitmap.getBitmapStr();
			log.debug(" F001 : " + bitmap.getBitmapStr());

			if (secondbitmap.hasAnotherBitmap()) {
				F001 thirdbitmap = loadF001(F001.Ordinal.THIRD);
				this.bitmapStr = bitmapStr + thirdbitmap.getBitmapStr();
				htfieldtmp.put(thirdbitmap.getFieldId(), thirdbitmap);
				log.debug(" F001 thirdbitmap : " + thirdbitmap.getBitmapStr());
				//
				bar = ArrayUtl.concat(secondbitmap.getBytearr(),
						thirdbitmap.getBytearr());
				// bitmap = F001.get( bar, F001.Ordinal.THIRD ) ;
				bitmap = ctf.getF001(bar, F001.Ordinal.THIRD);
				this.bitmapStr = bitmap.getBitmapStr();
				log.debug(" F001 : " + bitmap.getBitmapStr());
			}
		}
		return htfieldtmp;
	}

	protected Hashtable<Integer, TypeMain> putAll() {

		Hashtable<Integer, TypeMain> htfield = notbitmappedFields();
		htfield.putAll(getBitmappedFields());

		return htfield;
	}

	public Application getApp() {
		return app;
	}
	
	public String getBitmapStr() {
		return bitmapStr;
	}

}
