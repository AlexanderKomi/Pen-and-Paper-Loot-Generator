package io.dataLoading;

import constants.IOConstants;

import java.util.ArrayList;

public class Header {
	
	private String   name;
	private int      headerLength;
	private String[] columns;
	
	Header( String name ) {
		this.name = name;
		
		for ( int i = 0; i < IOConstants.lootClasses.length; i++ ) {
			if ( IOConstants.lootClasses[ i ].equals( name ) ) {
				this.headerLength = IOConstants.headerLengths[ i ];
				this.columns = IOConstants.columnDefinitions[ i ];
			}
		}
	}
	
	
	// START ------------ This is only for testing --------------
	
	private String extractHeader( String rawData ) {
		return rawData.substring( 0, headerLength );
	}
	
	private ArrayList<String> extractColumns( String header ) {
		ArrayList<String> extracted = new ArrayList<>();
		
		for ( String s : header.split( IOConstants.fileRowSeparator ) ) {
			for ( String x : s.split( IOConstants.fileEntrySeparator ) ) {
				if ( x.length() > 0 ) {
					extracted.add( x );
				}
			}
		}
		return extracted;
	}
	
	// END ------------ This is only for testing --------------
	
	// -------------------------------------------- GETTER AND SETTER --------------------------------------------------
	public String getName() {
		return name;
	}
	
	public String[] getColumns() {
		return columns;
	}
}
