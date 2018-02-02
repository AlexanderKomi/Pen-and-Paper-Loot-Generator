package io.dataLoading;

import io.IOConstants;
import io.dataLoading.read.ReadFile;
import model.LootClass;

import java.util.ArrayList;

public class ContentManager {
	
	private static LootClassCreator llc    = new LootClassCreator();
	private static ReadFile         reader = new ReadFile();
	
	public ArrayList<LootClass> createUsableData() {
		ArrayList<String> content = reader.getAllContent();
		ArrayList<Header> headers = createHeaders( content );
		content = cutHeader( headers, content );
		return createLootClasses( headers, content );
	}
	
	private ArrayList<String> cutHeader( ArrayList<Header> headers, ArrayList<String> content ) {
		
		for ( int i = 0; i < headers.size(); i++ ) {
			for ( int j = 0; j < content.size(); j++ ) {
				
				if ( headers.get( i ).getName().equals( IOConstants.lootClasses[ j ] ) ) {
					int    length = content.get( i ).length();
					String s      = content.get( i ).substring( IOConstants.headerLengths[ j ], length );
					content.set( i, s );
				}
			}
		}
		
		return content;
	}
	
	private ArrayList<LootClass> createLootClasses( ArrayList<Header> headers, ArrayList<String> content ) {
		ArrayList<LootClass> lootClasses = new ArrayList<>();
		for ( int i = 0; i < headers.size(); i++ ) {
			LootClass c = new LootClass(
					headers.get( i ),
					llc.createLoot( headers.get( i ), content.get( i ) )
			);
			lootClasses.add( c );
		}
		
		return lootClasses;
	}
	
	private ArrayList<Header> createHeaders( ArrayList<String> content ) {
		ArrayList<Header> headers = new ArrayList<>();
		
		for ( int i = 0; i < content.size(); i++ ) {
			headers.add( new Header( reader.fileNames.get( i ) ) );
		}
		return headers;
	}
	
}
