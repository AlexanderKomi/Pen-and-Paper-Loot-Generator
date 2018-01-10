package io;

import constants.GeneralConstants;

import java.io.File;
import java.util.ArrayList;

public class IOController {
	
	public IOController() {
	
	}
	
	public void loadData() {
		File[] files = findFiles();
		if ( files == null ) return;
		
		ArrayList<String> content = new ArrayList<>();
		
		for ( File file : files ) {
			ReadFile reader = new ReadFile();
			content.add( reader.readFile( file.getPath() ) );
		}
		
		content.forEach( System.out::println );
		
	}
	
	private File[] findFiles() {
		String sourceDirectory = GeneralConstants.getLocation() + "loot/";
		
		File[] files = finder( sourceDirectory );
		try {
			if ( files != null ) {
				for ( File f : files ) {
					System.out.println( "Found file : \t" + f.getName() );
				}
			}
			else {
				throw new Exception( "No resources found : " + sourceDirectory );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		return files;
	}
	
	private File[] finder( String dirName ) {
		return new File( dirName ).listFiles( ( directory, filename ) -> filename.endsWith( ".csv" ) );
	}
	
}