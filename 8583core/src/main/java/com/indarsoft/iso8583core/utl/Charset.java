package com.indarsoft.iso8583core.utl;

import com.indarsoft.iso8583core.types.FieldCodificationType;
import com.indarsoft.iso8583core.types.LengthFormatType;
import com.indarsoft.utl.Bcd;

/**
 * Charset is an AsciiExtendedTable, implemented as as Singleton <br>
 * Ascii Extended Table (ISO 8859-1) <br>
 * Accii Mapped Table for hex bytearr above 191 (MASTERCARD Customer Interface
 * Specification) <br>
 * EBCDIC (Code Page 1047) Translation <br>
 * 
 */
public class Charset {

	/**
	 * arc array of Char contains table of ascii to ebcdic translation.
	 * <p>
	 * - array index is the corresponding ascii character. <br>
	 * - array value is the corresponding Char-ebcdic character. <br>
	 * 
	 */
	protected final Char[] arc = new Char[256];
	/**
	 * erc array of Char contains table of ebcdic to ascii translation .
	 * <p>
	 * - array index is the corresponding ebcdic character <br>
	 * - array value is the corresponding Char-ascci character <br>
	 * 
	 */
	protected final Char[] erc = new Char[256];
	/**
	 * For singleton.
	 */
	private static Charset instance = null;

	/**
	 * Static Constructor (as a Singleton) .
	 * 
	 */
	public static Charset getInstance() {

		if (instance == null) {
			instance = new Charset();
		}
		return instance;
	}

	/**
	 * Private Constructor.
	 * <p>
	 * Loads translation table between Ascii and Ebcdic.
	 */
	private Charset() {

		load();
		for (int i = 0; i < 256; i++) {
			Char ach = arc[i];
			byte ehex = ach.getEbcdichexValue();
			erc[(int) ehex & 0xFF] = ach;
		}

	}

	/**
	 * gets the Ebcdic translation for an byte array of Ascii hex values.
	 * <p>
	 * 
	 * @param asciibyteArr
	 *            byte array of Ascii hex values
	 * @return byte array of Ebcdic hex values
	 * 
	 */
	public byte[] ascii2ebcdic(byte[] asciibyteArr) {
		int ARRSIZE = asciibyteArr.length;
		byte[] ebcdicbyteArr = new byte[ARRSIZE];
		for (int i = 0; i < ARRSIZE; i++) {
			int index = (int) asciibyteArr[i] & 0xFF;
			Char ech = arc[index];
			byte ehex = ech.getEbcdichexValue();
			ebcdicbyteArr[i] = ehex;
		}
		return ebcdicbyteArr;
	}

	/**
	 * gets the Ebcdic translation for an Ascii String.
	 * 
	 * @param asciiStr
	 *            Ascii string
	 * @return byte array of Ebcdic hex values
	 * 
	 */
	public byte[] ascii2ebcdic(String asciiStr) {
		byte[] asciibyteArr = asciiStr.getBytes();
		byte[] ebcdicbyteArr = ascii2ebcdic(asciibyteArr);
		return ebcdicbyteArr;
	}

	/**
	 * get the Ascii translation for an byte array of Ebcdic hex values.
	 * 
	 * @param ebcdicbyteArr
	 *            byte array of Ebcdic
	 * @return byte array of Ascii hex values
	 * 
	 */
	public byte[] ebcdic2ascii(byte[] ebcdicbyteArr) {
		int ARRSIZE = ebcdicbyteArr.length;
		byte[] asciibyteArr = new byte[ARRSIZE];
		for (int i = 0; i < ARRSIZE; i++) {
			Char ach = erc[(int) ebcdicbyteArr[i] & 0xFF];
			byte ahex = ach.getAsciihexValue();
			asciibyteArr[i] = ahex;
		}
		return asciibyteArr;
	}

	/**
	 * gets the Ascii traslation for an ebcdic string.
	 * <p>
	 * 
	 * @param ebcdicStr
	 *            string
	 * @return byte array of Ascii hex values
	 */
	public byte[] ebcdic2ascii(String ebcdicStr) {
		byte[] ebcdicbyteArr = ebcdicStr.getBytes();
		byte[] asciibyteArr = ebcdic2ascii(ebcdicbyteArr);
		return asciibyteArr;
	}

	/**
	 * gets object in position i.
	 * <p>
	 * 
	 * @param i
	 *            integer position to be get from arc.
	 * @return {@link Char }
	 * 
	 */
	public Char getCharArc(int i) {
		return arc[i];
	}

	/**
	 * gets object in position i.
	 * <p>
	 * 
	 * @param i
	 *            integer position to be get from erc.
	 * @return {@link Char }
	 * 
	 */
	public Char getCharErc(int i) {
		return arc[i];
	}

	/**
	 * check if the Ebcdic byte is alpha.
	 * <p>
	 * 
	 * @param ebcdicbyte
	 *            byte to be checked
	 * @return boolean
	 */
	private boolean isAlpha(byte ebcdicbyte) {

		Char c = erc[ebcdicbyte & 0xFF];
		if (c.getAttribute() == 'a') { // Attribute 'a' is Alpha
			return true;
		}
		return false;
	}

	/**
	 * Check if the Ebcdic byte array param is alpha.
	 * <p>
	 * 
	 * @param ebcdicbytearr
	 *            Ebcdic byte array to be checked
	 * @return boolean
	 */
	public boolean isAlpha(byte[] ebcdicbytearr) {

		for (int i = 0; i < ebcdicbytearr.length; i++) {
			byte abyte = ebcdicbytearr[i];
			boolean isvalid = isAlpha(abyte);
			if (!isvalid)
				return false;
		}
		return true;
	}

	/**
	 * Check if the byte array param is alpha.
	 * <p>
	 * 
	 * @param bytearr
	 *            Ebcdic byte array to be checked
	 * @param fct
	 *            {@link FieldCodificationType}
	 * @return boolean
	 */
	public boolean isAlpha(byte[] bytearr, FieldCodificationType fct) {

		if (fct.equals(FieldCodificationType.EBCDIC))
			return isAlpha(bytearr);
		if (fct.equals(FieldCodificationType.ASCII))
			return isAlpha(ascii2ebcdic(bytearr));
		return false;
	}

	/**
	 * check if the ebcdic byte param is AN , alpha or numeric.
	 * <p>
	 * 
	 * @param ebcdicbyte
	 * @return boolean
	 */
	private boolean isAn(byte ebcdicbyte) {

		Char c = erc[ebcdicbyte & 0xFF];
		char atr = c.getAttribute();
		if (atr == 'a' || atr == 'n') {
			return true;
		}
		return false;
	}

	/**
	 * check if the Ebcdic byte array param is An
	 * <p>
	 * 
	 * @param ebcdicbytearr
	 * @return boolean
	 * 
	 */
	public boolean isAn(byte[] ebcdicbytearr) {

		for (int i = 0; i < ebcdicbytearr.length; i++) {
			byte abyte = ebcdicbytearr[i];
			boolean isvalid = isAn(abyte);
			if (!isvalid)
				return false;
		}
		return true;
	}

	/**
	 * Check if the byte array param is An.
	 * <p>
	 * 
	 * @param bytearr
	 * @param dct
	 *            {@link FieldCodificationType}
	 * @return boolean
	 */
	public boolean isAn(byte[] bytearr, FieldCodificationType dct) {

		if (dct.equals(FieldCodificationType.EBCDIC))
			return isAn(bytearr);
		if (dct.equals(FieldCodificationType.ASCII))
			return isAn(ascii2ebcdic(bytearr));
		return false;
	}

	/**
	 * check if the ebcdic byte param is alpha , numeric or special.
	 * <p>
	 * 
	 * @param ebcdicbyte
	 *            byte
	 * @return boolean
	 */
	private boolean isAns(byte ebcdicbyte) {

		Char c = erc[ebcdicbyte & 0xFF];
		char atr = c.getAttribute();
		if (atr == 'a' || atr == 'n' || atr == 's') {
			return true;
		}
		return false;
	}

	/**
	 * check if the ebcdic byte array param is alpha , numeric or special.
	 * <p>
	 * 
	 * @param ebcdicbytearr
	 * @return boolean
	 */
	public boolean isAns(byte[] ebcdicbytearr) {

		for (int i = 0; i < ebcdicbytearr.length; i++) {
			byte abyte = ebcdicbytearr[i];
			boolean isvalid = isAns(abyte);
			if (!isvalid)
				return false;
		}
		return true;
	}

	/**
	 * check if the byte array param is alpha , numeric or special.
	 * <p>
	 * 
	 * @param bytearr
	 * @param dct
	 *            {@link FieldCodificationType}
	 * @return boolean
	 */
	public boolean isAns(byte[] bytearr, FieldCodificationType dct) {

		if (dct.equals(FieldCodificationType.EBCDIC))
			return isAns(bytearr);
		if (dct.equals(FieldCodificationType.ASCII))
			return isAns(ascii2ebcdic(bytearr));
		return false;
	}

	/**
	 * Check if the byte param is coded in BCD.
	 * <p>
	 * 
	 * @param bcdbyte
	 * @return boolean
	 */
	public boolean isBcd(byte bcdbyte) {

		return Bcd.isBcd(bcdbyte);
	}

	/**
	 * check if the byte array param is codec in BCD
	 * 
	 * @param bcdbytearr
	 * @return boolean
	 */
	public boolean isBcd(byte[] bcdbytearr) {
		return Bcd.isBcd(bcdbytearr);
	}

	/**
	 * Check if the ebcdic byte param is numeric.
	 * <p>
	 * 
	 * @param ebcdicbyte
	 * @return boolean
	 * 
	 */
	private boolean isNumeric(byte ebcdicbyte) {

		Char c = erc[ebcdicbyte & 0xFF];
		if (c.getAttribute() == 'n') { // Attribute 'n' is numeric
			return true;
		}
		return false;
	}

	/**
	 * Check if the ebcdic byte array param is Numeric.
	 * <p>
	 * 
	 * @param ebcdicbytearr
	 * @return boolean
	 */
	public boolean isNumeric(byte[] ebcdicbytearr) {

		for (int i = 0; i < ebcdicbytearr.length; i++) {
			byte abyte = ebcdicbytearr[i];
			boolean isvalid = isNumeric(abyte);
			if (!isvalid)
				return false;
		}
		return true;
	}

	/**
	 * Check if the byte array param is Numeric.
	 * <p>
	 * 
	 * @param bytearr
	 * @param dct
	 *            {@link FieldCodificationType}
	 * @return boolean
	 */
	public boolean isNumeric(byte[] bytearr, FieldCodificationType dct) {

		if (dct.equals(FieldCodificationType.EBCDIC))
			return isNumeric(bytearr);
		if (dct.equals(FieldCodificationType.ASCII))
			return isNumeric(ascii2ebcdic(bytearr));
		return false;
	}

	/**
	 * Check if the byte array is alpha , numeric or special.
	 * <p>
	 * 
	 * @param bytearr
	 *            byte array
	 * @param lct
	 *            {@link LengthFormatType }
	 * @return boolean
	 */
	public boolean isNumeric(byte[] bytearr, LengthFormatType lct) {

		if (lct.equals(LengthFormatType.EBCDIC))
			return isNumeric(bytearr);
		if (lct.equals(LengthFormatType.ASCII))
			return isNumeric(ascii2ebcdic(bytearr));
		return false;
	}

	/**
	 * check if the ebcdic byte param is special
	 * <p>
	 * 
	 * @param ebcdicbyte
	 *            byte
	 * @return boolean
	 */
	private boolean isSpecial(byte ebcdicbyte) {

		Char c = erc[ebcdicbyte & 0xFF];
		if (c.getAttribute() == 's') { // Attribute 's' is special
			return true;
		}
		return false;
	}

	/**
	 * Check if the Ebcdic byte array param is special.
	 * <p>
	 * 
	 * @param ebcdicbytearr
	 *            Ebcdic byte array
	 * @return boolean
	 */
	public boolean isSpecial(byte[] ebcdicbytearr) {

		for (int i = 0; i < ebcdicbytearr.length; i++) {
			byte abyte = ebcdicbytearr[i];
			boolean isvalid = isSpecial(abyte);
			if (!isvalid)
				return false;
		}
		return true;
	}

	/**
	 * Load ASCII Ascii Extended Table (ISO 8859-1) <br>
	 * Ascii Mapped Table for hex bytearr above 191 (MASTERCARD Customer
	 * Interface Specification) <br>
	 * EBCDIC (Code Page 1047) Translation
	 */
	private void load() {

		arc[0] = new Char((byte) 0x00, (byte) 0x00, (byte) 0x00, "",
				"Null char", '-');
		arc[1] = new Char((byte) 0x01, (byte) 0x01, (byte) 0x01, "",
				"Start of Heading", '-');
		arc[2] = new Char((byte) 0x02, (byte) 0x02, (byte) 0x02, "",
				"Start of Text", '-');
		arc[3] = new Char((byte) 0x03, (byte) 0x03, (byte) 0x03, "",
				"End of Text", '-');
		arc[4] = new Char((byte) 0x04, (byte) 0x37, (byte) 0x04, "",
				"End of Transmission", '-');
		arc[5] = new Char((byte) 0x05, (byte) 0x2D, (byte) 0x05, "", "Enquiry",
				'-');
		arc[6] = new Char((byte) 0x06, (byte) 0x2E, (byte) 0x06, "",
				"Acknowledgment", '-');
		arc[7] = new Char((byte) 0x07, (byte) 0x2F, (byte) 0x07, "", "Bell",
				'-');
		arc[8] = new Char((byte) 0x08, (byte) 0x16, (byte) 0x08, "",
				"Back Space", '-');
		arc[9] = new Char((byte) 0x09, (byte) 0x05, (byte) 0x09, "",
				"Horizontal Tab", '-');
		arc[10] = new Char((byte) 0xA, (byte) 0x25, (byte) 0xA, "",
				"Line Feed", '-');
		arc[11] = new Char((byte) 0xB, (byte) 0xB, (byte) 0xB, "",
				"Vertical Tab", '-');
		arc[12] = new Char((byte) 0xC, (byte) 0xC, (byte) 0xC, "", "Form Feed",
				'-');
		arc[13] = new Char((byte) 0xD, (byte) 0xD, (byte) 0xD, "",
				"Carriage Return", '-');
		arc[14] = new Char((byte) 0xE, (byte) 0xE, (byte) 0xE, "",
				"Shift Out / X-On", '-');
		arc[15] = new Char((byte) 0xF, (byte) 0xF, (byte) 0xF, "",
				"Shift In / X-Off", '-');
		arc[16] = new Char((byte) 0x10, (byte) 0x10, (byte) 0x10, "",
				"Data Line Escape", '-');
		arc[17] = new Char((byte) 0x11, (byte) 0x11, (byte) 0x11, "",
				"Device Control 1 (oft. XON)", '-');
		arc[18] = new Char((byte) 0x12, (byte) 0x12, (byte) 0x12, "",
				"Device Control 2", '-');
		arc[19] = new Char((byte) 0x13, (byte) 0x13, (byte) 0x13, "",
				"Device Control 3 (oft. XOFF)", '-');
		arc[20] = new Char((byte) 0x14, (byte) 0x3C, (byte) 0x14, "",
				"Device Control 4", '-');
		arc[21] = new Char((byte) 0x15, (byte) 0x3D, (byte) 0x15, "",
				"Negative Acknowledgement", '-');
		arc[22] = new Char((byte) 0x16, (byte) 0x32, (byte) 0x16, "",
				"Synchronous Idle", '-');
		arc[23] = new Char((byte) 0x17, (byte) 0x26, (byte) 0x17, "",
				"End of Transmit Block", '-');
		arc[24] = new Char((byte) 0x18, (byte) 0x18, (byte) 0x18, "", "Cancel",
				'-');
		arc[25] = new Char((byte) 0x19, (byte) 0x19, (byte) 0x19, "",
				"End of Medium", '-');
		arc[26] = new Char((byte) 0x1A, (byte) 0x3F, (byte) 0x1A, "",
				"Substitute", '-');
		arc[27] = new Char((byte) 0x1B, (byte) 0x27, (byte) 0x1B, "", "Escape",
				'-');
		arc[28] = new Char((byte) 0x1C, (byte) 0x1C, (byte) 0x1C, "",
				"File Separator", '-');
		arc[29] = new Char((byte) 0x1D, (byte) 0x1D, (byte) 0x1D, "",
				"Group Separator", '-');
		arc[30] = new Char((byte) 0x1E, (byte) 0x1E, (byte) 0x1E, "",
				"Record Separator", '-');
		arc[31] = new Char((byte) 0x1F, (byte) 0x1F, (byte) 0x1F, "",
				"Unit Separator", '-');
		arc[32] = new Char((byte) 0x20, (byte) 0x40, (byte) 0x20, "", "Space",
				's');
		arc[33] = new Char((byte) 0x21, (byte) 0x5A, (byte) 0x21, "",
				"Exclamation mark", 's');
		arc[34] = new Char((byte) 0x22, (byte) 0x7F, (byte) 0x22, "&quot;",
				"Double quotes (or speech marks)", 's');
		arc[35] = new Char((byte) 0x23, (byte) 0x7B, (byte) 0x23, "", "Number",
				's');
		arc[36] = new Char((byte) 0x24, (byte) 0x5B, (byte) 0x24, "", "Dollar",
				's');
		arc[37] = new Char((byte) 0x25, (byte) 0x6C, (byte) 0x25, "",
				"Procenttecken", 's');
		arc[38] = new Char((byte) 0x26, (byte) 0x50, (byte) 0x26, "&amp;",
				"Ampersand", 's');
		arc[39] = new Char((byte) 0x27, (byte) 0x7D, (byte) 0x27, "",
				"Single quote", 's');
		arc[40] = new Char((byte) 0x28, (byte) 0x4D, (byte) 0x28, "",
				"Open parenthesis (or open bracket)", 's');
		arc[41] = new Char((byte) 0x29, (byte) 0x5D, (byte) 0x29, "",
				"Close parenthesis (or close bracket)", 's');
		arc[42] = new Char((byte) 0x2A, (byte) 0x5C, (byte) 0x2A, "",
				"Asterisk", 's');
		arc[43] = new Char((byte) 0x2B, (byte) 0x4E, (byte) 0x2B, "", "Plus",
				's');
		arc[44] = new Char((byte) 0x2C, (byte) 0x6B, (byte) 0x2C, "", "Comma",
				's');
		arc[45] = new Char((byte) 0x2D, (byte) 0x60, (byte) 0x2D, "", "Hyphen",
				's');
		arc[46] = new Char((byte) 0x2E, (byte) 0x4B, (byte) 0x2E, "",
				"Period, dot or full stop", 's');
		arc[47] = new Char((byte) 0x2F, (byte) 0x61, (byte) 0x2F, "",
				"Slash or divide", 's');
		arc[48] = new Char((byte) 0x30, (byte) 0xF0, (byte) 0x30, "", "Zero",
				'n');
		arc[49] = new Char((byte) 0x31, (byte) 0xF1, (byte) 0x31, "", "One",
				'n');
		arc[50] = new Char((byte) 0x32, (byte) 0xF2, (byte) 0x32, "", "Two",
				'n');
		arc[51] = new Char((byte) 0x33, (byte) 0xF3, (byte) 0x33, "", "Three",
				'n');
		arc[52] = new Char((byte) 0x34, (byte) 0xF4, (byte) 0x34, "", "Four",
				'n');
		arc[53] = new Char((byte) 0x35, (byte) 0xF5, (byte) 0x35, "", "Five",
				'n');
		arc[54] = new Char((byte) 0x36, (byte) 0xF6, (byte) 0x36, "", "Six",
				'n');
		arc[55] = new Char((byte) 0x37, (byte) 0xF7, (byte) 0x37, "", "Seven",
				'n');
		arc[56] = new Char((byte) 0x38, (byte) 0xF8, (byte) 0x38, "", "Eight",
				'n');
		arc[57] = new Char((byte) 0x39, (byte) 0xF9, (byte) 0x39, "", "Nine",
				'n');
		arc[58] = new Char((byte) 0x3A, (byte) 0x7A, (byte) 0x3A, "", "Colon",
				's');
		arc[59] = new Char((byte) 0x3B, (byte) 0x5E, (byte) 0x3B, "",
				"Semicolon", 's');
		arc[60] = new Char((byte) 0x3C, (byte) 0x4C, (byte) 0x3C, "&lt;",
				"Less than (or open angled bracket)", 's');
		arc[61] = new Char((byte) 0x3D, (byte) 0x7E, (byte) 0x3D, "", "Equals",
				's');
		arc[62] = new Char((byte) 0x3E, (byte) 0x6E, (byte) 0x3E, "&gt;",
				"Greater than (or close angled bracket)", 's');
		arc[63] = new Char((byte) 0x3F, (byte) 0x6F, (byte) 0x3F, "",
				"Question mark", 's');
		arc[64] = new Char((byte) 0x40, (byte) 0x7C, (byte) 0x40, "",
				"At symbol", 's');
		arc[65] = new Char((byte) 0x41, (byte) 0xC1, (byte) 0x41, "",
				"Uppercase A", 'a');
		arc[66] = new Char((byte) 0x42, (byte) 0xC2, (byte) 0x42, "",
				"Uppercase B", 'a');
		arc[67] = new Char((byte) 0x43, (byte) 0xC3, (byte) 0x43, "",
				"Uppercase C", 'a');
		arc[68] = new Char((byte) 0x44, (byte) 0xC4, (byte) 0x44, "",
				"Uppercase D", 'a');
		arc[69] = new Char((byte) 0x45, (byte) 0xC5, (byte) 0x45, "",
				"Uppercase E", 'a');
		arc[70] = new Char((byte) 0x46, (byte) 0xC6, (byte) 0x46, "",
				"Uppercase F", 'a');
		arc[71] = new Char((byte) 0x47, (byte) 0xC7, (byte) 0x47, "",
				"Uppercase G", 'a');
		arc[72] = new Char((byte) 0x48, (byte) 0xC8, (byte) 0x48, "",
				"Uppercase H", 'a');
		arc[73] = new Char((byte) 0x49, (byte) 0xC9, (byte) 0x49, "",
				"Uppercase I", 'a');
		arc[74] = new Char((byte) 0x4A, (byte) 0xD1, (byte) 0x4A, "",
				"Uppercase J", 'a');
		arc[75] = new Char((byte) 0x4B, (byte) 0xD2, (byte) 0x4B, "",
				"Uppercase K", 'a');
		arc[76] = new Char((byte) 0x4C, (byte) 0xD3, (byte) 0x4C, "",
				"Uppercase L", 'a');
		arc[77] = new Char((byte) 0x4D, (byte) 0xD4, (byte) 0x4D, "",
				"Uppercase M", 'a');
		arc[78] = new Char((byte) 0x4E, (byte) 0xD5, (byte) 0x4E, "",
				"Uppercase NUMERIC", 'a');
		arc[79] = new Char((byte) 0x4F, (byte) 0xD6, (byte) 0x4F, "",
				"Uppercase O", 'a');
		arc[80] = new Char((byte) 0x50, (byte) 0xD7, (byte) 0x50, "",
				"Uppercase P", 'a');
		arc[81] = new Char((byte) 0x51, (byte) 0xD8, (byte) 0x51, "",
				"Uppercase Q", 'a');
		arc[82] = new Char((byte) 0x52, (byte) 0xD9, (byte) 0x52, "",
				"Uppercase R", 'a');
		arc[83] = new Char((byte) 0x53, (byte) 0xE2, (byte) 0x53, "",
				"Uppercase S", 'a');
		arc[84] = new Char((byte) 0x54, (byte) 0xE3, (byte) 0x54, "",
				"Uppercase T", 'a');
		arc[85] = new Char((byte) 0x55, (byte) 0xE4, (byte) 0x55, "",
				"Uppercase U", 'a');
		arc[86] = new Char((byte) 0x56, (byte) 0xE5, (byte) 0x56, "",
				"Uppercase V", 'a');
		arc[87] = new Char((byte) 0x57, (byte) 0xE6, (byte) 0x57, "",
				"Uppercase W", 'a');
		arc[88] = new Char((byte) 0x58, (byte) 0xE7, (byte) 0x58, "",
				"Uppercase X", 'a');
		arc[89] = new Char((byte) 0x59, (byte) 0xE8, (byte) 0x59, "",
				"Uppercase Y", 'a');
		arc[90] = new Char((byte) 0x5A, (byte) 0xE9, (byte) 0x5A, "",
				"Uppercase Z", 'a');
		arc[91] = new Char((byte) 0x5B, (byte) 0xAD, (byte) 0x5B, "",
				"Opening bracket", 's');
		arc[92] = new Char((byte) 0x5C, (byte) 0xE0, (byte) 0x5C, "",
				"Backslash", 's');
		arc[93] = new Char((byte) 0x5D, (byte) 0xBD, (byte) 0x5D, "",
				"Closing bracket", 's');
		arc[94] = new Char((byte) 0x5E, (byte) 0x5F, (byte) 0x5E, "",
				"Caret - circumflex", 's');
		arc[95] = new Char((byte) 0x5F, (byte) 0x6D, (byte) 0x5F, "",
				"Underscore", 's');
		arc[96] = new Char((byte) 0x60, (byte) 0x79, (byte) 0x60, "",
				"Grave accent", 's');
		arc[97] = new Char((byte) 0x61, (byte) 0x81, (byte) 0x61, "",
				"Lowercase a", 'a');
		arc[98] = new Char((byte) 0x62, (byte) 0x82, (byte) 0x62, "",
				"Lowercase b", 'a');
		arc[99] = new Char((byte) 0x63, (byte) 0x83, (byte) 0x63, "",
				"Lowercase c", 'a');
		arc[100] = new Char((byte) 0x64, (byte) 0x84, (byte) 0x64, "",
				"Lowercase d", 'a');
		arc[101] = new Char((byte) 0x65, (byte) 0x85, (byte) 0x65, "",
				"Lowercase e", 'a');
		arc[102] = new Char((byte) 0x66, (byte) 0x86, (byte) 0x66, "",
				"Lowercase f", 'a');
		arc[103] = new Char((byte) 0x67, (byte) 0x87, (byte) 0x67, "",
				"Lowercase g", 'a');
		arc[104] = new Char((byte) 0x68, (byte) 0x88, (byte) 0x68, "",
				"Lowercase h", 'a');
		arc[105] = new Char((byte) 0x69, (byte) 0x89, (byte) 0x69, "",
				"Lowercase i", 'a');
		arc[106] = new Char((byte) 0x6A, (byte) 0x91, (byte) 0x6A, "",
				"Lowercase j", 'a');
		arc[107] = new Char((byte) 0x6B, (byte) 0x92, (byte) 0x6B, "",
				"Lowercase k", 'a');
		arc[108] = new Char((byte) 0x6C, (byte) 0x93, (byte) 0x6C, "",
				"Lowercase l", 'a');
		arc[109] = new Char((byte) 0x6D, (byte) 0x94, (byte) 0x6D, "",
				"Lowercase m", 'a');
		arc[110] = new Char((byte) 0x6E, (byte) 0x95, (byte) 0x6E, "",
				"Lowercase n", 'a');
		arc[111] = new Char((byte) 0x6F, (byte) 0x96, (byte) 0x6F, "",
				"Lowercase o", 'a');
		arc[112] = new Char((byte) 0x70, (byte) 0x97, (byte) 0x70, "",
				"Lowercase p", 'a');
		arc[113] = new Char((byte) 0x71, (byte) 0x98, (byte) 0x71, "",
				"Lowercase q", 'a');
		arc[114] = new Char((byte) 0x72, (byte) 0x99, (byte) 0x72, "",
				"Lowercase r", 'a');
		arc[115] = new Char((byte) 0x73, (byte) 0xA2, (byte) 0x73, "",
				"Lowercase s", 'a');
		arc[116] = new Char((byte) 0x74, (byte) 0xA3, (byte) 0x74, "",
				"Lowercase t", 'a');
		arc[117] = new Char((byte) 0x75, (byte) 0xA4, (byte) 0x75, "",
				"Lowercase u", 'a');
		arc[118] = new Char((byte) 0x76, (byte) 0xA5, (byte) 0x76, "",
				"Lowercase v", 'a');
		arc[119] = new Char((byte) 0x77, (byte) 0xA6, (byte) 0x77, "",
				"Lowercase w", 'a');
		arc[120] = new Char((byte) 0x78, (byte) 0xA7, (byte) 0x78, "",
				"Lowercase x", 'a');
		arc[121] = new Char((byte) 0x79, (byte) 0xA8, (byte) 0x79, "",
				"Lowercase y", 'a');
		arc[122] = new Char((byte) 0x7A, (byte) 0xA9, (byte) 0x7A, "",
				"Lowercase z", 'a');
		arc[123] = new Char((byte) 0x7B, (byte) 0xC0, (byte) 0x7B, "",
				"Opening brace", 's');
		arc[124] = new Char((byte) 0x7C, (byte) 0x4F, (byte) 0x7C, "",
				"Vertical bar", 's');
		arc[125] = new Char((byte) 0x7D, (byte) 0xD0, (byte) 0x7D, "",
				"Closing brace", 's');
		arc[126] = new Char((byte) 0x7E, (byte) 0xA1, (byte) 0x7E, "",
				"Equivalency sign - tilde", 's');
		arc[127] = new Char((byte) 0x7F, (byte) 0x07, (byte) 0x7F, "",
				"Delete", '-');
		arc[128] = new Char((byte) 0x80, (byte) 0x04, (byte) 0x80, "&euro;",
				"Euro sign", '-');
		arc[129] = new Char((byte) 0x81, (byte) 0x06, (byte) 0x81, "", "", '-');
		arc[130] = new Char((byte) 0x82, (byte) 0x08, (byte) 0x82, "&sbquo;",
				"Single low-9 quotation mark", '-');
		arc[131] = new Char((byte) 0x83, (byte) 0x09, (byte) 0x83, "&fnof;",
				"Latin small letter f with hook", '-');
		arc[132] = new Char((byte) 0x84, (byte) 0xA, (byte) 0x84, "&bdquo;",
				"Double low-9 quotation mark", '-');
		arc[133] = new Char((byte) 0x85, (byte) 0x15, (byte) 0x85, "&hellip;",
				"Horizontal ellipsis", '-');
		arc[134] = new Char((byte) 0x86, (byte) 0x14, (byte) 0x86, "&dagger;",
				"Dagger", '-');
		arc[135] = new Char((byte) 0x87, (byte) 0x17, (byte) 0x87, "&Dagger;",
				"Double dagger", '-');
		arc[136] = new Char((byte) 0x88, (byte) 0x1A, (byte) 0x88, "&circ;",
				"Modifier letter circumflex accent", '-');
		arc[137] = new Char((byte) 0x89, (byte) 0x1B, (byte) 0x89, "&permil;",
				"Per mille sign", '-');
		arc[138] = new Char((byte) 0x8A, (byte) 0x20, (byte) 0x8A, "&Scaron;",
				"Latin capital letter S with caron", '-');
		arc[139] = new Char((byte) 0x8B, (byte) 0x21, (byte) 0x8B, "&lsaquo;",
				"Single left-pointing angle quotation", '-');
		arc[140] = new Char((byte) 0x8C, (byte) 0x22, (byte) 0x8C, "&OElig;",
				"Latin capital ligature OE", '-');
		arc[141] = new Char((byte) 0x8D, (byte) 0x23, (byte) 0x8D, "", "", '-');
		arc[142] = new Char((byte) 0x8E, (byte) 0x24, (byte) 0x8E, "",
				"Latin captial letter Z with caron", '-');
		arc[143] = new Char((byte) 0x8F, (byte) 0x28, (byte) 0x8F, "", "", '-');
		arc[144] = new Char((byte) 0x90, (byte) 0x29, (byte) 0x90, "", "", '-');
		arc[145] = new Char((byte) 0x91, (byte) 0x2A, (byte) 0x91, "&lsquo;",
				"Left single quotation mark", '-');
		arc[146] = new Char((byte) 0x92, (byte) 0x2B, (byte) 0x92, "&rsquo;",
				"Right single quotation mark", '-');
		arc[147] = new Char((byte) 0x93, (byte) 0x2C, (byte) 0x93, "&ldquo;",
				"Left double quotation mark", '-');
		arc[148] = new Char((byte) 0x94, (byte) 0x30, (byte) 0x94, "&rdquo;",
				"Right double quotation mark", '-');
		arc[149] = new Char((byte) 0x95, (byte) 0x31, (byte) 0x95, "&bull;",
				"Bullet", '-');
		arc[150] = new Char((byte) 0x96, (byte) 0x33, (byte) 0x96, "&ndash;",
				"En dash", '-');
		arc[151] = new Char((byte) 0x97, (byte) 0x34, (byte) 0x97, "&mdash;",
				"Em dash", '-');
		arc[152] = new Char((byte) 0x98, (byte) 0x35, (byte) 0x98, "&tilde;",
				"Small tilde", '-');
		arc[153] = new Char((byte) 0x99, (byte) 0x36, (byte) 0x99, "&trade;",
				"Trade mark sign", '-');
		arc[154] = new Char((byte) 0x9A, (byte) 0x38, (byte) 0x9A, "&scaron;",
				"Latin small letter S with caron", '-');
		arc[155] = new Char((byte) 0x9B, (byte) 0x39, (byte) 0x9B, "&rsaquo;",
				"Single right-pointing angle quotation mark", '-');
		arc[156] = new Char((byte) 0x9C, (byte) 0x3A, (byte) 0x9C, "&oelig;",
				"Latin small ligature oe", '-');
		arc[157] = new Char((byte) 0x9D, (byte) 0x3B, (byte) 0x9D, "", "", '-');
		arc[158] = new Char((byte) 0x9E, (byte) 0x3E, (byte) 0x9E, "",
				"Latin small letter z with caron", '-');
		arc[159] = new Char((byte) 0x9F, (byte) 0xFF, (byte) 0x9F, "&yuml;",
				"Latin capital letter Y with diaeresis", '-');
		arc[160] = new Char((byte) 0xA0, (byte) 0x41, (byte) 0xA0, "&nbsp;",
				"Non-breaking space", '-');
		arc[161] = new Char((byte) 0xA1, (byte) 0xAA, (byte) 0xA1, "&iexcl;",
				"Inverted exclamation mark", '-');
		arc[162] = new Char((byte) 0xA2, (byte) 0x4A, (byte) 0xA2, "&cent;",
				"Cent sign", '-');
		arc[163] = new Char((byte) 0xA3, (byte) 0xB1, (byte) 0xA3, "&pound;",
				"Pound sign", '-');
		arc[164] = new Char((byte) 0xA4, (byte) 0x9F, (byte) 0xA4, "&curren;",
				"Currency sign", '-');
		arc[165] = new Char((byte) 0xA5, (byte) 0xB2, (byte) 0xA5, "&yen;",
				"Yen sign", '-');
		arc[166] = new Char((byte) 0xA6, (byte) 0x6A, (byte) 0xA6, "&brvbar;",
				"Pipe, Broken vertical bar", '-');
		arc[167] = new Char((byte) 0xA7, (byte) 0xB5, (byte) 0xA7, "&sect;",
				"Section sign", '-');
		arc[168] = new Char((byte) 0xA8, (byte) 0xBB, (byte) 0xA8, "&uml;",
				"Spacing diaeresis - umlaut", '-');
		arc[169] = new Char((byte) 0xA9, (byte) 0xB4, (byte) 0xA9, "&copy;",
				"Copyright sign", '-');
		arc[170] = new Char((byte) 0xAA, (byte) 0x9A, (byte) 0xAA, "&ordf;",
				"Feminine ordinal indicator", '-');
		arc[171] = new Char((byte) 0xAB, (byte) 0x8A, (byte) 0xAB, "&laquo;",
				"Left double angle quotes", '-');
		arc[172] = new Char((byte) 0xAC, (byte) 0xB0, (byte) 0xAC, "&not;",
				"Not sign", '-');
		arc[173] = new Char((byte) 0xAD, (byte) 0xCA, (byte) 0xAD, "&shy;",
				"Soft hyphen", '-');
		arc[174] = new Char((byte) 0xAE, (byte) 0xAF, (byte) 0xAE, "&reg;",
				"Registered trade mark sign", '-');
		arc[175] = new Char((byte) 0xAF, (byte) 0xBC, (byte) 0xAF, "&macr;",
				"Spacing macron - overline", '-');
		arc[176] = new Char((byte) 0xB0, (byte) 0x90, (byte) 0xB0, "&deg;",
				"Degree sign", '-');
		arc[177] = new Char((byte) 0xB1, (byte) 0x8F, (byte) 0xB1, "&plusmn;",
				"Plus-or-minus sign", '-');
		arc[178] = new Char((byte) 0xB2, (byte) 0xEA, (byte) 0xB2, "&sup2;",
				"Superscript two - squared", '-');
		arc[179] = new Char((byte) 0xB3, (byte) 0xFA, (byte) 0xB3, "&sup3;",
				"Superscript three - cubed", '-');
		arc[180] = new Char((byte) 0xB4, (byte) 0xBE, (byte) 0xB4, "&acute;",
				"Acute accent - spacing acute", '-');
		arc[181] = new Char((byte) 0xB5, (byte) 0xA0, (byte) 0xB5, "&micro;",
				"Micro sign", '-');
		arc[182] = new Char((byte) 0xB6, (byte) 0xB6, (byte) 0xB6, "&para;",
				"Pilcrow sign - paragraph sign", '-');
		arc[183] = new Char((byte) 0xB7, (byte) 0xB3, (byte) 0xB7, "&middot;",
				"Middle dot - Georgian comma", '-');
		arc[184] = new Char((byte) 0xB8, (byte) 0x9D, (byte) 0xB8, "&cedil;",
				"Spacing cedilla", '-');
		arc[185] = new Char((byte) 0xB9, (byte) 0xDA, (byte) 0xB9, "&sup1;",
				"Superscript one", '-');
		arc[186] = new Char((byte) 0xBA, (byte) 0x9B, (byte) 0xBA, "&ordm;",
				"Masculine ordinal indicator", '-');
		arc[187] = new Char((byte) 0xBB, (byte) 0x8B, (byte) 0xBB, "&raquo;",
				"Right double angle quotes", '-');
		arc[188] = new Char((byte) 0xBC, (byte) 0xB7, (byte) 0xBC, "&frac14;",
				"Fraction one quarter", '-');
		arc[189] = new Char((byte) 0xBD, (byte) 0xB8, (byte) 0xBD, "&frac12;",
				"Fraction one half", '-');
		arc[190] = new Char((byte) 0xBE, (byte) 0xB9, (byte) 0xBE, "&frac34;",
				"Fraction three quarters", '-');
		arc[191] = new Char((byte) 0xBF, (byte) 0xAB, (byte) 0xBF, "&iquest;",
				"Inverted question mark", '-');
		arc[192] = new Char((byte) 0xC0, (byte) 0x64, (byte) 0x41, "&Agrave;",
				"Latin capital letter A with grave", '-');
		arc[193] = new Char((byte) 0xC1, (byte) 0x65, (byte) 0x41, "&Aacute;",
				"Latin capital letter A with acute", '-');
		arc[194] = new Char((byte) 0xC2, (byte) 0x62, (byte) 0x41, "&Acirc;",
				"Latin capital letter A with circumflex", '-');
		arc[195] = new Char((byte) 0xC3, (byte) 0x66, (byte) 0x41, "&Atilde;",
				"Latin capital letter A with tilde", '-');
		arc[196] = new Char((byte) 0xC4, (byte) 0x63, (byte) 0x41, "&Auml;",
				"Latin capital letter A with diaeresis", '-');
		arc[197] = new Char((byte) 0xC5, (byte) 0x67, (byte) 0x41, "&Aring;",
				"Latin capital letter A with ring above", '-');
		arc[198] = new Char((byte) 0xC6, (byte) 0x9E, (byte) 0x45, "&AElig;",
				"Latin capital letter AE", '-');
		arc[199] = new Char((byte) 0xC7, (byte) 0x68, (byte) 0x43, "&Ccedil;",
				"Latin capital letter C with cedilla", '-');
		arc[200] = new Char((byte) 0xC8, (byte) 0x74, (byte) 0x45, "&Egrave;",
				"Latin capital letter E with grave", '-');
		arc[201] = new Char((byte) 0xC9, (byte) 0x71, (byte) 0x45, "&Eacute;",
				"Latin capital letter E with acute", '-');
		arc[202] = new Char((byte) 0xCA, (byte) 0x72, (byte) 0x45, "&Ecirc;",
				"Latin capital letter E with circumflex", '-');
		arc[203] = new Char((byte) 0xCB, (byte) 0x73, (byte) 0x45, "&Euml;",
				"Latin capital letter E with diaeresis", '-');
		arc[204] = new Char((byte) 0xCC, (byte) 0x78, (byte) 0x49, "&Igrave;",
				"Latin capital letter I with grave", '-');
		arc[205] = new Char((byte) 0xCD, (byte) 0x75, (byte) 0x49, "&Iacute;",
				"Latin capital letter I with acute", '-');
		arc[206] = new Char((byte) 0xCE, (byte) 0x76, (byte) 0x49, "&Icirc;",
				"Latin capital letter I with circumflex", '-');
		arc[207] = new Char((byte) 0xCF, (byte) 0x77, (byte) 0x49, "&Iuml;",
				"Latin capital letter I with diaeresis", '-');
		arc[208] = new Char((byte) 0xD0, (byte) 0xAC, (byte) 0x44, "&ETH;",
				"Latin capital letter ETH", '-');
		arc[209] = new Char((byte) 0xD1, (byte) 0x69, (byte) 0x4e, "&Ntilde;",
				"Latin capital letter NUMERIC with tilde", '-');
		arc[210] = new Char((byte) 0xD2, (byte) 0xED, (byte) 0x4f, "&Ograve;",
				"Latin capital letter O with grave", '-');
		arc[211] = new Char((byte) 0xD3, (byte) 0xEE, (byte) 0x4f, "&Oacute;",
				"Latin capital letter O with acute", '-');
		arc[212] = new Char((byte) 0xD4, (byte) 0xEB, (byte) 0x4f, "&Ocirc;",
				"Latin capital letter O with circumflex", '-');
		arc[213] = new Char((byte) 0xD5, (byte) 0xEF, (byte) 0x4f, "&Otilde;",
				"Latin capital letter O with tilde", '-');
		arc[214] = new Char((byte) 0xD6, (byte) 0xEC, (byte) 0x4f, "&Ouml;",
				"Latin capital letter O with diaeresis", '-');
		arc[215] = new Char((byte) 0xD7, (byte) 0xBF, (byte) 0x78, "&times;",
				"Multiplication sign", '-');
		arc[216] = new Char((byte) 0xD8, (byte) 0x80, (byte) 0x4f, "&Oslash;",
				"Latin capital letter O with slash", '-');
		arc[217] = new Char((byte) 0xD9, (byte) 0xFD, (byte) 0x55, "&Ugrave;",
				"Latin capital letter U with grave", '-');
		arc[218] = new Char((byte) 0xDA, (byte) 0xFE, (byte) 0x55, "&Uacute;",
				"Latin capital letter U with acute", '-');
		arc[219] = new Char((byte) 0xDB, (byte) 0xFB, (byte) 0x55, "&Ucirc;",
				"Latin capital letter U with circumflex", '-');
		arc[220] = new Char((byte) 0xDC, (byte) 0xFC, (byte) 0x55, "&Uuml;",
				"Latin capital letter U with diaeresis", '-');
		arc[221] = new Char((byte) 0xDD, (byte) 0xBA, (byte) 0x59, "&Yacute;",
				"Latin capital letter Y with acute", '-');
		arc[222] = new Char((byte) 0xDE, (byte) 0xAE, (byte) 0x50, "&THORN;",
				"Latin capital letter THORN", '-');
		arc[223] = new Char((byte) 0xDF, (byte) 0x59, (byte) 0x53, "&szlig;",
				"Latin small letter sharp s - ess-zed", '-');
		arc[224] = new Char((byte) 0xE0, (byte) 0x44, (byte) 0x61, "&agrave;",
				"Latin small letter a with grave", '-');
		arc[225] = new Char((byte) 0xE1, (byte) 0x45, (byte) 0x61, "&aacute;",
				"Latin small letter a with acute", '-');
		arc[226] = new Char((byte) 0xE2, (byte) 0x42, (byte) 0x61, "&acirc;",
				"Latin small letter a with circumflex", '-');
		arc[227] = new Char((byte) 0xE3, (byte) 0x46, (byte) 0x61, "&atilde;",
				"Latin small letter a with tilde", '-');
		arc[228] = new Char((byte) 0xE4, (byte) 0x43, (byte) 0x61, "&auml;",
				"Latin small letter a with diaeresis", '-');
		arc[229] = new Char((byte) 0xE5, (byte) 0x47, (byte) 0x61, "&aring;",
				"Latin small letter a with ring above", '-');
		arc[230] = new Char((byte) 0xE6, (byte) 0x9C, (byte) 0x65, "&aelig;",
				"Latin small letter ae", '-');
		arc[231] = new Char((byte) 0xE7, (byte) 0x48, (byte) 0x63, "&ccedil;",
				"Latin small letter c with cedilla", '-');
		arc[232] = new Char((byte) 0xE8, (byte) 0x54, (byte) 0x65, "&egrave;",
				"Latin small letter e with grave", '-');
		arc[233] = new Char((byte) 0xE9, (byte) 0x51, (byte) 0x65, "&eacute;",
				"Latin small letter e with acute", '-');
		arc[234] = new Char((byte) 0xEA, (byte) 0x52, (byte) 0x65, "&ecirc;",
				"Latin small letter e with circumflex", '-');
		arc[235] = new Char((byte) 0xEB, (byte) 0x53, (byte) 0x65, "&euml;",
				"Latin small letter e with diaeresis", '-');
		arc[236] = new Char((byte) 0xEC, (byte) 0x58, (byte) 0x69, "&igrave;",
				"Latin small letter i with grave", '-');
		arc[237] = new Char((byte) 0xED, (byte) 0x55, (byte) 0x69, "&iacute;",
				"Latin small letter i with acute", '-');
		arc[238] = new Char((byte) 0xEE, (byte) 0x56, (byte) 0x69, "&icirc;",
				"Latin small letter i with circumflex", '-');
		arc[239] = new Char((byte) 0xEF, (byte) 0x57, (byte) 0x69, "&iuml;",
				"Latin small letter i with diaeresis", '-');
		arc[240] = new Char((byte) 0xF0, (byte) 0x8C, (byte) 0x64, "&eth;",
				"Latin small letter eth", '-');
		arc[241] = new Char((byte) 0xF1, (byte) 0x49, (byte) 0x6e, "&ntilde;",
				"Latin small letter n with tilde", '-');
		arc[242] = new Char((byte) 0xF2, (byte) 0xCD, (byte) 0x6f, "&ograve;",
				"Latin small letter o with grave", '-');
		arc[243] = new Char((byte) 0xF3, (byte) 0xCE, (byte) 0x6f, "&oacute;",
				"Latin small letter o with acute", '-');
		arc[244] = new Char((byte) 0xF4, (byte) 0xCB, (byte) 0x6f, "&ocirc;",
				"Latin small letter o with circumflex", '-');
		arc[245] = new Char((byte) 0xF5, (byte) 0xCF, (byte) 0x6f, "&otilde;",
				"Latin small letter o with tilde", '-');
		arc[246] = new Char((byte) 0xF6, (byte) 0xCC, (byte) 0x6f, "&ouml;",
				"Latin small letter o with diaeresis", '-');
		arc[247] = new Char((byte) 0xF7, (byte) 0xE1, (byte) 0x2f, "&divide;",
				"Division sign", '-');
		arc[248] = new Char((byte) 0xF8, (byte) 0x70, (byte) 0x6f, "&oslash;",
				"Latin small letter o with slash", '-');
		arc[249] = new Char((byte) 0xF9, (byte) 0xDD, (byte) 0x75, "&ugrave;",
				"Latin small letter u with grave", '-');
		arc[250] = new Char((byte) 0xFA, (byte) 0xDE, (byte) 0x75, "&uacute;",
				"Latin small letter u with acute", '-');
		arc[251] = new Char((byte) 0xFB, (byte) 0xDB, (byte) 0x75, "&ucirc;",
				"Latin small letter u with circumflex", '-');
		arc[252] = new Char((byte) 0xFC, (byte) 0xDC, (byte) 0x75, "&uuml;",
				"Latin small letter u with diaeresis", '-');
		arc[253] = new Char((byte) 0xFD, (byte) 0x8D, (byte) 0x79, "&yacute;",
				"Latin small letter y with acute", '-');
		arc[254] = new Char((byte) 0xFE, (byte) 0x8E, (byte) 0x70, "&thorn;",
				"Latin small letter thorn", '-');
		arc[255] = new Char((byte) 0xFF, (byte) 0xDF, (byte) 0x79, "&yuml;",
				"Latin small letter y with diaeresis", '-');

	}

}