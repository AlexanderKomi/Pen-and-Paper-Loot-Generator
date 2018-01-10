package io.dataLoading;

import java.io.File;
import java.util.ArrayList;

public class ContentManager {
	
	private ReadFile reader = new ReadFile();
	
	public void createUsableData() {
		File[] files = reader.findFiles();
		if ( files == null ) return;
		ArrayList<String> content = getContentAsStrings( files ); //Every Element in this list contains one file.
		//content.forEach( System.out::println );
		String[] s = new String[ content.size() ];
		content.toArray( s );
		ArrayList<Header> headers = createHeaders( s );
	}
	
	private Header createHeader( String content, int index ) {
		Header header = null;
		System.out.println( "Header are currently not implemented. Look at ContentManager.createHeader for implementation." );
		return header;
	}
	
	private ArrayList<Header> createHeaders( String[] content ) {
		ArrayList<Header> headers = new ArrayList<>();
		for ( int i = 0; i < content.length; i++ ) {
			headers.add( createHeader( content[ i ], i ) );
		}
		return headers;
	}
	
	private ArrayList<String> getContentAsStrings( File[] files ) {
		ArrayList<String> content = new ArrayList<>();
		
		for ( File file : files ) {
			content.add( reader.readFile( file.getPath() ) );
		}
		return content;
	}
	
	
}
