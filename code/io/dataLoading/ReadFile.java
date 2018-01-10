package io.dataLoading;

import constants.GeneralConstants;
import constants.IOConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	
	public String readFile( String fileLocation ) {
		String everything = "";
		try ( BufferedReader br = new BufferedReader( new FileReader( fileLocation ) ) ) {
			StringBuilder sb   = new StringBuilder();
			String        line = br.readLine();
			
			while ( line != null ) {
				sb.append( line );
				sb.append( System.lineSeparator() );
				line = br.readLine();
			}
			everything = sb.toString();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		return everything;
	}
	
	
	/**
	 * When you wanna make restrictions to files read and used in the folder, you have to exclude it here.
	 *
	 * @return All files found in the directory with special ending from IOConstants.
	 */
	public File[] findFiles() {
		String sourceDirectory = GeneralConstants.getLocation() + "loot/";
		
		File[]          files       = finder( sourceDirectory );
		ArrayList<File> usebleFiles = new ArrayList<>();
		try {
			if ( files != null ) {
				for ( File f : files ) {
					String nameWithoutExtension = f.getName().substring( 0, f.getName().length() - IOConstants.fileType.length() );
					for ( String s : IOConstants.lootClasses ) {
						if ( s.equals( nameWithoutExtension ) ) {
							usebleFiles.add( f );
							System.out.println( "Found file and is viable lootclass : \t" + f.getName() );
						}
						else {
							System.out.println( "Found file and is not viable lootclass : \t" + f.getName() );
						}
					}
				}
			}
			else {
				throw new Exception( "ERROR : No resources found in : " + sourceDirectory );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		files = new File[ usebleFiles.size() ];
		usebleFiles.toArray( files );
		return files;
	}
	
	private File[] finder( String dirName ) {
		return new File( dirName ).listFiles( ( directory, filename ) -> filename.endsWith( IOConstants.fileType ) );
	}
}
