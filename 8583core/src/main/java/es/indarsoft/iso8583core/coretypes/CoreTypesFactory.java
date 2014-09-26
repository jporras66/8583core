package es.indarsoft.iso8583core.coretypes;

import es.indarsoft.iso8583core.app.Application;
import es.indarsoft.iso8583core.coretypes.F001.Ordinal;
import es.indarsoft.iso8583core.types.Field;

public class CoreTypesFactory {

	private Application app;

	public CoreTypesFactory(Application app) {
		this.app = app;
	}
	
	public Application getApp() {
		return app;
	}

	/**
	 * Create an instance of {@link F000 }.
	 * 
	 */
	public F000 getF000(byte[] bytearr) {

		Field field = app.getAppBean().getField(0);
		return F000.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F001 }.
	 * 
	 */
	public F001 getF001(byte[] bytearr, Ordinal ordinal) {

		Field field = app.getAppBean().getField(1);
		return F001.get(bytearr, ordinal, field);
	}

	/**
	 * Create an instance of {@link F002 }.
	 * 
	 */
	public F002 getF002(byte[] bytearr) {

		Field field = app.getAppBean().getField(2);
		return F002.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F002 }.
	 * 
	 */
	public F002 getF002In(byte[] bytearr) {

		Field field = app.getAppBean().getField(2);
		return F002.getIn(bytearr, field);
	}

	/**
	 * Create an instance of {@link F035 }.
	 * 
	 */
	public F035 getF035(byte[] bytearr) {

		Field field = app.getAppBean().getField(35);
		return F035.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F003} - Processing code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F003}
	 */
	public F003 getF003(byte[] bytearr) {

		Field field = app.getAppBean().getField(3);
		return F003.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F004} - Amount, transaction.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F004}
	 */
	public F004 getF004(byte[] bytearr) {

		Field field = app.getAppBean().getField(4);
		return F004.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F005} - Amount, settlement.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F005}
	 */
	public F005 getF005(byte[] bytearr) {

		Field field = app.getAppBean().getField(5);
		return F005.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F006} - Amount, cardholder billing.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F006}
	 */
	public F006 getF006(byte[] bytearr) {

		Field field = app.getAppBean().getField(6);
		return F006.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F007} - Transmission date time.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F007}
	 */
	public F007 getF007(byte[] bytearr) {

		Field field = app.getAppBean().getField(7);
		return F007.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F008} - Amount, cardholder billing fee.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F008}
	 */
	public F008 getF008(byte[] bytearr) {

		Field field = app.getAppBean().getField(8);
		return F008.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F009} - Conversion rate, settlement.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F009}
	 */
	public F009 getF009(byte[] bytearr) {

		Field field = app.getAppBean().getField(9);
		return F009.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F010} - Conversion rate, cardholder billing.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F010}
	 */
	public F010 getF010(byte[] bytearr) {

		Field field = app.getAppBean().getField(10);
		return F010.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F011} - System trace audit number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F011}
	 */
	public F011 getF011(byte[] bytearr) {

		Field field = app.getAppBean().getField(11);
		return F011.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F012} - Time, local transaction.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F012}
	 */
	public F012 getF012(byte[] bytearr) {

		Field field = app.getAppBean().getField(12);
		return F012.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F013} - Date, local transaction.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F013}
	 */
	public F013 getF013(byte[] bytearr) {

		Field field = app.getAppBean().getField(13);
		return F013.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F014} - Date, expiration.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F014}
	 */
	public F014 getF014(byte[] bytearr) {

		Field field = app.getAppBean().getField(14);
		return F014.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F015} - Date, settlement.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F015}
	 */
	public F015 getF015(byte[] bytearr) {

		Field field = app.getAppBean().getField(15);
		return F015.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F016} - Date, conversion.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F016}
	 */
	public F016 getF016(byte[] bytearr) {

		Field field = app.getAppBean().getField(16);
		return F016.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F017} - Date, capture.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F017}
	 */
	public F017 getF017(byte[] bytearr) {

		Field field = app.getAppBean().getField(17);
		return F017.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F018} - Merchant type.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F018}
	 */
	public F018 getF018(byte[] bytearr) {

		Field field = app.getAppBean().getField(18);
		return F018.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F019} - Acquiring institution country code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F019}
	 */
	public F019 getF019(byte[] bytearr) {

		Field field = app.getAppBean().getField(19);
		return F019.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F020} - PAN extended, country code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F020}
	 */
	public F020 getF020(byte[] bytearr) {

		Field field = app.getAppBean().getField(20);
		return F020.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F021} - Forwarding institution country code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F021}
	 */
	public F021 getF021(byte[] bytearr) {

		Field field = app.getAppBean().getField(21);
		return F021.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F022} - Point of service entry mode.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F022}
	 */
	public F022 getF022(byte[] bytearr) {

		Field field = app.getAppBean().getField(22);
		return F022.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F023} - Application PAN sequence number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F023}
	 */
	public F023 getF023(byte[] bytearr) {

		Field field = app.getAppBean().getField(23);
		return F023.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F024} - Network International identifier.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F024}
	 */
	public F024 getF024(byte[] bytearr) {

		Field field = app.getAppBean().getField(24);
		return F024.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F025} - Point of service condition code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F025}
	 */
	public F025 getF025(byte[] bytearr) {

		Field field = app.getAppBean().getField(25);
		return F025.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F026} - Point of service capture code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F026}
	 */
	public F026 getF026(byte[] bytearr) {

		Field field = app.getAppBean().getField(26);
		return F026.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F027} - Authorizing identification response
	 * length.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F027}
	 */
	public F027 getF027(byte[] bytearr) {

		Field field = app.getAppBean().getField(27);
		return F027.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F028} - Amount, transaction fee.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F028}
	 */
	public F028 getF028(byte[] bytearr) {

		Field field = app.getAppBean().getField(28);
		return F028.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F029} - Amount, settlement fee.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F029}
	 */
	public F029 getF029(byte[] bytearr) {

		Field field = app.getAppBean().getField(29);
		return F029.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F030} - Amount, transaction processing fee.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F030}
	 */
	public F030 getF030(byte[] bytearr) {

		Field field = app.getAppBean().getField(30);
		return F030.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F031} - Amount, settlement processing fee.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F031}
	 */
	public F031 getF031(byte[] bytearr) {

		Field field = app.getAppBean().getField(31);
		return F031.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F032} - Acquiring institution identification
	 * code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F032}
	 */
	public F032 getF032(byte[] bytearr) {

		Field field = app.getAppBean().getField(32);
		return F032.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F033} - Forwarding institution
	 * identification code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F033}
	 */
	public F033 getF033(byte[] bytearr) {

		Field field = app.getAppBean().getField(33);
		return F033.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F034} - Primary account number, extended.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F034}
	 */
	public F034 getF034(byte[] bytearr) {

		Field field = app.getAppBean().getField(34);
		return F034.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F037} - Retrieval reference number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F037}
	 */
	public F037 getF037(byte[] bytearr) {

		Field field = app.getAppBean().getField(37);
		return F037.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F038} - Authorization identification
	 * response.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F038}
	 */
	public F038 getF038(byte[] bytearr) {

		Field field = app.getAppBean().getField(38);
		return F038.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F039} - Response code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F039}
	 */
	public F039 getF039(byte[] bytearr) {

		Field field = app.getAppBean().getField(39);
		return F039.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F040} - Service restriction code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F040}
	 */
	public F040 getF040(byte[] bytearr) {

		Field field = app.getAppBean().getField(40);
		return F040.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F041} - Card acceptor terminal
	 * identification.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F041}
	 */
	public F041 getF041(byte[] bytearr) {

		Field field = app.getAppBean().getField(41);
		return F041.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F042} - Card acceptor identification code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F042}
	 */
	public F042 getF042(byte[] bytearr) {

		Field field = app.getAppBean().getField(42);
		return F042.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F043} - Card acceptor name location.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F043}
	 */
	public F043 getF043(byte[] bytearr) {

		Field field = app.getAppBean().getField(43);
		return F043.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F044} - Additional response data.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F044}
	 */
	public F044 getF044(byte[] bytearr) {

		Field field = app.getAppBean().getField(44);
		return F044.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F045} - Track 1 data.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F045}
	 */
	public F045 getF045(byte[] bytearr) {

		Field field = app.getAppBean().getField(45);
		return F045.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F046} - Additional data ISO.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F046}
	 */
	public F046 getF046(byte[] bytearr) {

		Field field = app.getAppBean().getField(46);
		return F046.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F047} - Additional data national.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F047}
	 */
	public F047 getF047(byte[] bytearr) {

		Field field = app.getAppBean().getField(47);
		return F047.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F048} - Additional data private.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F048}
	 */
	public F048 getF048(byte[] bytearr) {

		Field field = app.getAppBean().getField(48);
		return F048.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F049} - Currency code, transaction.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F049}
	 */
	public F049 getF049(byte[] bytearr) {

		Field field = app.getAppBean().getField(49);
		return F049.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F050} - Currency code, settlement.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F050}
	 */
	public F050 getF050(byte[] bytearr) {

		Field field = app.getAppBean().getField(50);
		return F050.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F051} - Currency code, cardholder billing.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F051}
	 */
	public F051 getF051(byte[] bytearr) {

		Field field = app.getAppBean().getField(51);
		return F051.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F052} - Personal identification number data.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F052}
	 */
	public F052 getF052(byte[] bytearr) {

		Field field = app.getAppBean().getField(52);
		return F052.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F053} - Security related control
	 * information.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F053}
	 */
	public F053 getF053(byte[] bytearr) {

		Field field = app.getAppBean().getField(53);
		return F053.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F054} - Additional amounts.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F054}
	 */
	public F054 getF054(byte[] bytearr) {

		Field field = app.getAppBean().getField(54);
		return F054.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F055} - Integrated Circuit Card Data.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F055}
	 */
	public F055 getF055(byte[] bytearr) {

		Field field = app.getAppBean().getField(55);
		return F055.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F060} - Advice reason code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F060}
	 */
	public F060 getF060(byte[] bytearr) {

		Field field = app.getAppBean().getField(60);
		return F060.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F061} - Reserved private.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F061}
	 */
	public F061 getF061(byte[] bytearr) {

		Field field = app.getAppBean().getField(61);
		return F061.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F063} - Reserved private.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F063}
	 */
	public F063 getF063(byte[] bytearr) {

		Field field = app.getAppBean().getField(63);
		return F063.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F064} - Message authentication code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F064}
	 */
	public F064 getF064(byte[] bytearr) {

		Field field = app.getAppBean().getField(64);
		return F064.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F065} - Bit Map, Extended.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F065}
	 */
	public F065 getF065(byte[] bytearr) {

		Field field = app.getAppBean().getField(65);
		return F065.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F066} - Settlement code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F066}
	 */
	public F066 getF066(byte[] bytearr) {

		Field field = app.getAppBean().getField(66);
		return F066.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F067} - Extended payment code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F067}
	 */
	public F067 getF067(byte[] bytearr) {

		Field field = app.getAppBean().getField(67);
		return F067.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F068} - Receiving institution country code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F068}
	 */
	public F068 getF068(byte[] bytearr) {

		Field field = app.getAppBean().getField(68);
		return F068.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F069} - Settlement institution country code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F069}
	 */
	public F069 getF069(byte[] bytearr) {

		Field field = app.getAppBean().getField(69);
		return F069.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F070} - Network management information code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F070}
	 */
	public F070 getF070(byte[] bytearr) {

		Field field = app.getAppBean().getField(70);
		return F070.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F071} - Message number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F071}
	 */
	public F071 getF071(byte[] bytearr) {

		Field field = app.getAppBean().getField(71);
		return F071.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F072} - Data record.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F072}
	 */
	public F072 getF072(byte[] bytearr) {

		Field field = app.getAppBean().getField(72);
		return F072.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F073} - Date, action.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F073}
	 */
	public F073 getF073(byte[] bytearr) {

		Field field = app.getAppBean().getField(73);
		return F073.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F074} - Credits, number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F074}
	 */
	public F074 getF074(byte[] bytearr) {

		Field field = app.getAppBean().getField(74);
		return F074.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F075} - Credits, reversal number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F075}
	 */
	public F075 getF075(byte[] bytearr) {

		Field field = app.getAppBean().getField(75);
		return F075.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F076} - Debits, number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F076}
	 */
	public F076 getF076(byte[] bytearr) {

		Field field = app.getAppBean().getField(76);
		return F076.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F077} - Debits, reversal number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F077}
	 */
	public F077 getF077(byte[] bytearr) {

		Field field = app.getAppBean().getField(77);
		return F077.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F078} - Transfer number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F078}
	 */
	public F078 getF078(byte[] bytearr) {

		Field field = app.getAppBean().getField(78);
		return F078.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F079} - Transfer, reversal number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F079}
	 */
	public F079 getF079(byte[] bytearr) {

		Field field = app.getAppBean().getField(79);
		return F079.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F080} - Inquiries number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F080}
	 */
	public F080 getF080(byte[] bytearr) {

		Field field = app.getAppBean().getField(80);
		return F080.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F081} - Authorizations, number.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F081}
	 */
	public F081 getF081(byte[] bytearr) {

		Field field = app.getAppBean().getField(81);
		return F081.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F082} - Credits, processing fee amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F082}
	 */
	public F082 getF082(byte[] bytearr) {

		Field field = app.getAppBean().getField(82);
		return F082.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F083} - Credits, transaction fee amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F083}
	 */
	public F083 getF083(byte[] bytearr) {

		Field field = app.getAppBean().getField(83);
		return F083.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F084} - Debits, processing fee amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F084}
	 */
	public F084 getF084(byte[] bytearr) {

		Field field = app.getAppBean().getField(84);
		return F084.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F085} - Debits, transaction fee amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F085}
	 */
	public F085 getF085(byte[] bytearr) {

		Field field = app.getAppBean().getField(85);
		return F085.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F086} - Credits, amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F086}
	 */
	public F086 getF086(byte[] bytearr) {

		Field field = app.getAppBean().getField(86);
		return F086.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F087} - Credits, reversal amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F087}
	 */
	public F087 getF087(byte[] bytearr) {

		Field field = app.getAppBean().getField(87);
		return F087.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F088} - Debits, amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F088}
	 */
	public F088 getF088(byte[] bytearr) {

		Field field = app.getAppBean().getField(88);
		return F088.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F089} - Debits, reversal amount.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F089}
	 */
	public F089 getF089(byte[] bytearr) {

		Field field = app.getAppBean().getField(89);
		return F089.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F090} - Original data elements.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F090}
	 */
	public F090 getF090(byte[] bytearr) {

		Field field = app.getAppBean().getField(90);
		return F090.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F091} - File update code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F091}
	 */
	public F091 getF091(byte[] bytearr) {

		Field field = app.getAppBean().getField(91);
		return F091.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F092} - File security code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F092}
	 */
	public F092 getF092(byte[] bytearr) {

		Field field = app.getAppBean().getField(92);
		return F092.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F093} - Response indicator.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F093}
	 */
	public F093 getF093(byte[] bytearr) {

		Field field = app.getAppBean().getField(93);
		return F093.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F094} - Service indicator.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F094}
	 */
	public F094 getF094(byte[] bytearr) {

		Field field = app.getAppBean().getField(94);
		return F094.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F095} - Replacement amounts.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F095}
	 */
	public F095 getF095(byte[] bytearr) {

		Field field = app.getAppBean().getField(95);
		return F095.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F096} - Message security code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F096}
	 */
	public F096 getF096(byte[] bytearr) {

		Field field = app.getAppBean().getField(96);
		return F096.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F097} - Amount, net settlement.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F097}
	 */
	public F097 getF097(byte[] bytearr) {

		Field field = app.getAppBean().getField(97);
		return F097.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F098} - Payee.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F098}
	 */
	public F098 getF098(byte[] bytearr) {

		Field field = app.getAppBean().getField(98);
		return F098.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F099} - Settlement institution
	 * identification code .
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F099}
	 */
	public F099 getF099(byte[] bytearr) {

		Field field = app.getAppBean().getField(99);
		return F099.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F100} - Receiving institution identification
	 * code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F100}
	 */
	public F100 getF100(byte[] bytearr) {

		Field field = app.getAppBean().getField(100);
		return F100.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F101} - File name.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F101}
	 */
	public F101 getF101(byte[] bytearr) {

		Field field = app.getAppBean().getField(101);
		return F101.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F102} - Account identification 1.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F102}
	 */
	public F102 getF102(byte[] bytearr) {

		Field field = app.getAppBean().getField(102);
		return F102.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F103} - Account identification 2.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F103}
	 */
	public F103 getF103(byte[] bytearr) {

		Field field = app.getAppBean().getField(103);
		return F103.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F104} - Transaction description.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F104}
	 */
	public F104 getF104(byte[] bytearr) {

		Field field = app.getAppBean().getField(104);
		return F104.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F113} - Authorizing agent institution id
	 * code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F113}
	 */
	public F113 getF113(byte[] bytearr) {

		Field field = app.getAppBean().getField(113);
		return F113.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F124} - Info text.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F124}
	 */
	public F124 getF124(byte[] bytearr) {

		Field field = app.getAppBean().getField(124);
		return F124.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F125} - Network management information.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F125}
	 */
	public F125 getF125(byte[] bytearr) {

		Field field = app.getAppBean().getField(125);
		return F125.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F126} - Issuer trace id.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F126}
	 */
	public F126 getF126(byte[] bytearr) {

		Field field = app.getAppBean().getField(126);
		return F126.get(bytearr, field);
	}

	/**
	 * Create an instance of {@link F128} - Message authentication code.
	 * 
	 * @param bytearr
	 *            byte array
	 * @return {@link F128}
	 */
	public F128 getF128(byte[] bytearr) {

		Field field = app.getAppBean().getField(128);
		return F128.get(bytearr, field);
	}

}