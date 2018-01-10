package io.dataLoading;

import constants.GeneralConstants;
import constants.IOConstants;
import io.Helper;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
	
	public ArrayList<String> initialize() {
		System.out.println( "Location : " + GeneralConstants.getLocation() );
		
		if ( GeneralConstants.getLocation().endsWith( ".jar" ) ) {  //Distinguish between jar and IDE execution
			return findInJar();
		}
		else {
			File[] files = findInFiles();
			if ( files == null ) return null;
			return getContentAsStrings( files ); //Every Element in this list contains one file.
		}
	}
	
	private String readFile( String fileLocation ) {
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
	
	private String findResource( String fileLocation ) {
		InputStream is = Helper.class.getClassLoader().getResourceAsStream( fileLocation );
		if ( is == null ) {
			System.out.println( " File : " + fileLocation + " not found." );
			return null;
		}
		BufferedReader reader     = new BufferedReader( new InputStreamReader( is ) );
		String         everything = "";
		try {
			StringBuilder sb   = new StringBuilder();
			String        line = reader.readLine();
			
			while ( line != null ) {
				sb.append( line );
				sb.append( System.lineSeparator() );
				line = reader.readLine();
			}
			everything = sb.toString();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		
		if ( everything.equals( "" ) ) {
			everything = " No stuff found ";
		}
		
		return everything;
	}
	
	private ArrayList<String> findInJar() {
		ArrayList<String> results = new ArrayList<>();
		
		for ( String s : IOConstants.lootClasses ) {
			s = findResource( IOConstants.resourceFolder + s + IOConstants.fileType );
			if ( s != null ) {
				results.add( s );
			}
		}
		
		//results.forEach( System.out::println ); // Print all content
		
		return results;
	}
	
	/**
	 * When you wanna make restrictions to files read and used in the folder, you have to exclude it here.
	 *
	 * @return All files found in the directory with special ending from IOConstants.
	 */
	private File[] findInFiles() {
		ArrayList<File> usebleFiles     = new ArrayList<>();
		String          sourceDirectory = GeneralConstants.getLocation() + IOConstants.resourceFolder;
		File[]          files           = finder( sourceDirectory );
		
		try {
			if ( files != null ) {
				for ( File f : files ) {
					String nameWithoutExtension = f.getName().substring( 0, f.getName().length() - IOConstants.fileType.length() );
					for ( String s : IOConstants.lootClasses ) {
						if ( s.equals( nameWithoutExtension ) ) {
							usebleFiles.add( f );
							System.out.println( "Found file and is viable lootclass : \t" + f.getName() );
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
		File f = new File( dirName );
		//		//System.out.println( Arrays.toString( f.list() ) );
		return f.listFiles( ( directory, filename ) -> filename.endsWith( IOConstants.fileType ) );
	}
	
	private ArrayList<String> getContentAsStrings( File[] files ) {
		ArrayList<String> content = new ArrayList<>();
		for ( File file : files ) {
			content.add( readFile( file.getPath() ) );
		}
		return content;
	}
}
