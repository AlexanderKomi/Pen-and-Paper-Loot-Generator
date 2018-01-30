package io.dataLoading;

import constants.GeneralConstants;
import io.Helper;
import io.IOConstants;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
	
	public ArrayList<String> fileNames = new ArrayList<>();
	
	public ArrayList<String> getAllContent() {
		if ( this.isExecutedFromJar() ) {  //Distinguish between jar and IDE execution
			return findInJar();
		}
		else {
			return getAllContentAsStrings( findInFiles() ); //Every Element in this list contains one file.
		}
	}
	
	private String readFile( String fileLocation ) {
		String everything = "";
		try ( BufferedReader br = new BufferedReader( new FileReader( fileLocation ) ) ) {
			StringBuilder sb   = new StringBuilder();
			String        line = br.readLine();
			
			while ( line != null ) {
				sb.append( line ).append( IOConstants.lineSeparator );
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
				sb.append( IOConstants.lineSeparator );
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
		for ( String lootClassName : IOConstants.lootClasses ) {
			String content = findResource( IOConstants.lootFolder + lootClassName + IOConstants.fileType );
			if ( content != null ) {
				fileNames.add( lootClassName );
				results.add( content );
			}
			else {
				try {
					String exception = "ERROR : No resources found in : " + IOConstants.lootFolder + lootClassName + IOConstants.fileType;
					//IOController.getLogger().addEntry( exception );
					throw new Exception( exception );
				}
				catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		}
		return results;
	}
	
	private File[] findInFiles() {
		ArrayList<File> usebleFiles     = new ArrayList<>();
		String          sourceDirectory = GeneralConstants.getLocation() + IOConstants.lootFolder;
		File[]          files           = findFilesInDirectory( sourceDirectory );

		try {
			if ( files != null ) {
				if ( files.length != IOConstants.lootClasses.length ) {
					
					for ( File file : files ) {
						for ( int j = 0; j < IOConstants.lootClasses.length; j++ ) {
							
							String nameWithoutExtension = file.getName().substring( 0, file.getName().length() - IOConstants.fileType.length() );
							
							if ( IOConstants.lootClasses[ j ].equals( nameWithoutExtension ) ) {
								fileNames.add( nameWithoutExtension );
								usebleFiles.add( file );
							}
						}
					}
					files = new File[ usebleFiles.size() ];
					usebleFiles.toArray( files );
					
					String exception = "Found files and loot-classes (in IOConstants) differ in length : " + sourceDirectory;
					//IOController.getLogger().addEntry( exception );
					throw new Exception( exception );
				}
			}
			else {
				String exception = "No resources found in : " + sourceDirectory;
				//IOController.getLogger().addEntry( exception );
				throw new Exception( exception );
			}
			
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}

		return files;
	}
	
	private File findFileInDirectory( String dirName, String fileName ) {
		return new File( dirName + "/" + fileName );
	}
	
	private File[] findFilesInDirectory( String dirName ) {
		return new File( dirName ).listFiles( ( directory, filename ) -> filename.endsWith( IOConstants.fileType ) );
	}
	
	private ArrayList<String> getAllContentAsStrings( File[] files ) {
		ArrayList<String> content = new ArrayList<>();

		for ( File file : files ) {
			fileNames.add( file.getName().substring( 0, file.getName().length() - IOConstants.fileType.length() ) );
			content.add( readFile( file.getPath() ) );
		}

		return content;
	}
	
	private String getContentAsString( File file ) {
		return readFile( file.getPath() );
	}
	
	private boolean isExecutedFromJar() {
		return GeneralConstants.getLocation().endsWith( ".jar" );
	}
}
