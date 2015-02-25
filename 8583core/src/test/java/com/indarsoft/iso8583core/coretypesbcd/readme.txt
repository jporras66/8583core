bcd test for a customized application (VISA SMS in this case)

	CONFIGFILE = "visasms.properties";

This function must be called before execute every test :

	public Application  app	= ApplicationFactory.getApp( cfg ) ;