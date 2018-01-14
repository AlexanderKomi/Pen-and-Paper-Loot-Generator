package io.dataLoading;

import constants.IOConstants;
import model.LootClass;
import model.LootController;

import java.util.ArrayList;

public class ContentManager {
	
	private static ReadFile reader = new ReadFile();
	
	public void createUsableData() {
		// TODO : Extract usefull content from here to model classes
		ArrayList<String> content      = reader.getContent();
		String[]          contentArray = new String[ content.size() ];
		content.toArray( contentArray );
		
		ArrayList<Header> headers     = createHeaders( contentArray );
		Header[]          headerArray = new Header[ headers.size() ];
		headers.toArray( headerArray );
		
		contentArray = cutHeader( contentArray );
		
		ArrayList<LootClass> classes = createLootClasses( headerArray, contentArray );
		LootController.setLootClasses( classes );
		classes.forEach( System.out::println );
	}
	
	private String[] cutHeader( String[] contentArray ) {
		for ( int i = 0; i < contentArray.length; i++ ) {
			int length = contentArray[ i ].length();
			contentArray[ i ] = contentArray[ i ].substring( IOConstants.headerLengths[ i ], length );
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
			headers.add( new Header( IOConstants.lootClasses[ i ] ) );
		}
		return headers;
	}
	
	
}
