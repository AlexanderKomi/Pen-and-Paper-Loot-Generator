package io.dataLoading;

import java.util.ArrayList;

public class ContentManager {
	
	private ReadFile reader = new ReadFile();
	
	public void createUsableData() {
		ArrayList<String> content      = reader.initialize();
		String[]          contentArray = new String[ content.size() ];
		content.toArray( contentArray );
		ArrayList<Header> headers = createHeaders( contentArray );
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
	
	
}
