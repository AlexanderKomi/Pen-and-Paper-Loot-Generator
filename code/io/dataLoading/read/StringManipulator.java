package io.dataLoading.read;

import io.IOConstants;

public class StringManipulator {
	
	public static String[] deleteEmptyStart( String[] rows ) {
		String[] result = rows;
		for ( int i = 0; i < rows.length; i++ ) {
			for ( String s : rows[ i ].split( IOConstants.fileEntrySeparator ) ) {
				if ( !s.isEmpty() ) {
					
					result = new String[ rows.length - i ];
					
					System.arraycopy( rows, i + 1, result, 0, rows.length - i - 1 - i );
					
					return result;
				}
			}
		}
		return result;
	}
	
}
