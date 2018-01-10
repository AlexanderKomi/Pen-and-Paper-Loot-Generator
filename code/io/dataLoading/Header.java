package io.dataLoading;

import constants.IOConstants;

import java.util.ArrayList;

public class Header {
	
	private ArrayList<String> columns;
	private int               headerLength;
	private String            header;
	
	public Header( String rawHeader, int headerLength ) {
		this.headerLength = headerLength;
		this.header = extractHeader( rawHeader );
		this.columns = extractColumns( header );
		this.columns.forEach( System.out::println );
	}
	
	private String extractHeader( String rawHeader ) {
		return rawHeader.substring( 0, headerLength );
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
}
