package io.dataLoading;

import constants.IOConstants;

public class Header {
	
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
	
	// -------------------------------------------- GETTER AND SETTER --------------------------------------------------
	public String getName() {
		return name;
	}
	
	public String[] getColumns() {
		return columns;
	}
}
