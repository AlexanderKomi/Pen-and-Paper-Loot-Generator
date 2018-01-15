package io;

import constants.GeneralConstants;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
	
	private static Logger logger = Logger.getLogger( "log" );
	
	FileLogger() {
		
		FileHandler fh;
		
		try {
			// This block configure the logger with handler and formatter
			String location = GeneralConstants.getLocation().substring( 1, GeneralConstants.getLocation().length() );
			if ( !GeneralConstants.isExecutedFromJar() ) {
				String x = location + "logfiles/" + "LogFile.log";
				fh = new FileHandler( x );
				logger.addHandler( fh );
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter( formatter );
				
			}
		}
		catch ( SecurityException | IOException e ) {
			e.printStackTrace();
		}
	}
	
	public void addEntry( String entry ) {
		logger.info( entry );
	}
	
	public static Logger getLogger() {
		return logger;
	}
}
