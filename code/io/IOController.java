package io;

import constants.IOConstants;
import io.dataLoading.ContentManager;

public class IOController {
	
	//private static FileLogger     logger = new FileLogger();
	private static ContentManager c = new ContentManager();
	
	public static void loadStartingData() {
		if ( IOConstants.checkArrayLength() ) {
			c.createUsableData();
		}
		else {
			try {
				String exception = "\tArrays in IOConstants don't have the same length." + "\n"
						+ "\tPlease check all Arrays for the same length." + "\n";
				//logger.addEntry( exception );
				throw new Exception( exception );
			}
			catch ( Exception e ) {
				e.printStackTrace();
			}
		}
	}
	/*
	public static FileLogger getLogger() {
		return logger;
	}
	*/
}