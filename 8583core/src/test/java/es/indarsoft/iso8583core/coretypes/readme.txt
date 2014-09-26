		ISO8583 application

	CONFIGFILE = "main.properties";
	

This function must be called before execute every test :

	public Application  app	= ApplicationFactory.getMain( cfg ) ;