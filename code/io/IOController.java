package io;

import io.dataLoading.ContentManager;
import model.LootController;

public final class IOController {
	
	//private static FileLogger     logger = new FileLogger();
	private static ContentManager contentManager = new ContentManager();
	
	public static void loadStartingData() {
		if ( IOConstants.checkArrayLength() ) {
			LootController.setLootClasses( contentManager.createUsableData() );
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