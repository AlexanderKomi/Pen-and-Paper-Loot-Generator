package io.dataLoading;

import io.IOConstants;
import model.Loot;

import java.util.ArrayList;
import java.util.HashMap;

public class LootClassCreator {
	
	public static ArrayList<Loot> createItems( String content, String[] columns ) {
		
		ArrayList<Loot> loot = new ArrayList<>();
		String[]        rows = content.split( IOConstants.fileRowSeparator );
		
		for ( String row : deleteEmptyStart( rows ) ) {
			
			ArrayList<String> list = createLoot( row );
			
			if ( list != null ) {
				loot.add( new Loot( mergeListAndColumnsToLoot( list, columns ) ) );
			}
		}
		return loot;
	}
	
	private static HashMap<String, String> mergeListAndColumnsToLoot( ArrayList<String> list, String[] columns ) {
		HashMap<String, String> map = new HashMap<>();
		for ( int i = 0; i < columns.length; i++ ) {
			map.put( columns[ i ], list.get( i ) );
		}
		return map;
	}
	
	private static String[] deleteEmptyStart( String[] rows ) {
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
	
	private static ArrayList<String> createLoot( String row ) {
		if ( row == null ) {
			return null;
		}
		String[] elements = row.split( IOConstants.fileEntrySeparator );
		
		ArrayList<String> list = new ArrayList<>();
		
		for ( String element : elements ) {
			if ( element == null ) {
				list.add( IOConstants.replaceCharacter );
			}
			else if ( element.isEmpty() ) {
				list.add( IOConstants.replaceCharacter );
			}
			else {
				list.add( element );
			}
		}
		return list;
	}
}
