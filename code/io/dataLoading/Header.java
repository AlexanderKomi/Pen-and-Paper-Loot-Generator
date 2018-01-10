package io.dataLoading;

import constants.IOConstants;

import java.util.ArrayList;
import java.util.Arrays;

public class Header {
	
	private String name;
	private int    headerLength;
	private ArrayList<String> columns = new ArrayList<>();
	
	Header( String name ) {
		this.name = name;
		if ( !checkForRestrictions() ) {
			// not restrictions set in IO Constants
		}
	}
	
	private boolean checkForRestrictions() {
		for ( int i = 0; i < IOConstants.lootClasses.length; i++ ) {
			if ( IOConstants.lootClasses[ i ].equals( name ) ) {
				this.headerLength = IOConstants.headerLengths[ i ];
				this.columns.addAll( Arrays.asList( IOConstants.columnDefinitions[ i ] ) );
				return true;
			}
		}
		return false;
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
	
	public ArrayList<String> getColumns() {
		return columns;
	}
}
