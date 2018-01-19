package io.dataLoading;

import io.IOConstants;
import model.LootClass;
import model.LootController;

import java.util.ArrayList;

public class ContentManager {
	
	private static ReadFile reader = new ReadFile();
	
	public void createUsableData() {
		
		ArrayList<String> content      = reader.getContent();
		String[]          contentArray = new String[ content.size() ];
		content.toArray( contentArray );
		
		ArrayList<Header> headers     = createHeaders( contentArray );
		Header[]          headerArray = new Header[ headers.size() ];
		headers.toArray( headerArray );
		
		contentArray = cutHeader( headerArray, contentArray );
		
		ArrayList<LootClass> classes = createLootClasses( headerArray, contentArray );
		LootController.setLootClasses( classes );
		//classes.forEach( System.out::println );
	}
	
	private String[] cutHeader( Header[] headers, String[] content ) {
		
		for ( int i = 0; i < headers.length; i++ ) {
			for ( int j = 0; j < content.length; j++ ) {
				
				if ( headers[ i ].getName().equals( IOConstants.lootClasses[ j ] ) ) {
					int    length = content[ i ].length();
					String s      = content[ i ].substring( IOConstants.headerLengths[ j ], length );
					content[ i ] = s;
				}
			}
		}
		
		return content;
	}
	
	private ArrayList<LootClass> createLootClasses( Header[] headers, String[] content ) {
		ArrayList<LootClass> lootClasses = new ArrayList<>();
		for ( int i = 0; i < headers.length; i++ ) {
			LootClass c = new LootClass( headers[ i ], content[ i ] );
			lootClasses.add( c );
		}
		
		return lootClasses;
	}
	
	private ArrayList<Header> createHeaders( String[] content ) {
		ArrayList<Header> headers = new ArrayList<>();
		
		for ( int i = 0; i < content.length; i++ ) {
			headers.add( new Header( reader.fileNames.get( i ) ) );
		}
		return headers;
	}
	
	
}
