package io.dataLoading;

import constants.IOConstants;
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
	}
	
	private String[] cutHeader( Header[] headers, String[] contentArray ) {
		
		for ( int i = 0; i < headers.length; i++ ) {
			for ( int j = 0; j < contentArray.length; j++ ) {
				
				if ( headers[ i ].getName().equals( IOConstants.lootClasses[ j ] ) ) {
					int    length = contentArray[ i ].length();
					String s      = contentArray[ i ].substring( IOConstants.headerLengths[ j ], length );
					contentArray[ i ] = s;
				}
			}
		}
		
		return contentArray;
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
