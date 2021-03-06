package io.dataLoading;

import io.IOConstants;

public final class Header {
	
	private String   name;
	private String[] columns;
	
	Header( String name ) {
		this.name = name;
		
		for ( int i = 0; i < IOConstants.lootClasses.length; i++ ) {
			if ( IOConstants.lootClasses[ i ].equals( name ) ) {
				this.columns = IOConstants.columnDefinitions[ i ];
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder( name ).append( ": ( " );
		for ( String s : columns ) {
			sb.append( s ).append( ", " );
		}
		sb.deleteCharAt( sb.lastIndexOf( ", " ) );
		sb.append( " )" );
		return sb.toString();
	}
	
	// -------------------------------------------- GETTER AND SETTER --------------------------------------------------
	public String getName() {
		return name;
	}
	
	public String[] getColumns() {
		return columns;
	}
}
