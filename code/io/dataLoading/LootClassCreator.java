package io.dataLoading;

import constants.IOConstants;
import model.Loot;

import java.util.ArrayList;

public class LootClassCreator {
	
	public static ArrayList<Loot> createItems( String content, int indexOfLootClass ) {
		
		ArrayList<Loot> loot = new ArrayList<>();
		String[]        rows = content.split( IOConstants.fileRowSeparator );
		
		for ( String row : deleteEmptyStart( rows ) ) {
			Loot l = createLoot( row, indexOfLootClass );
			if ( l != null ) {
				loot.add( l );
			}
		}
		return loot;
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
	
	private static Loot createLoot( String row, int indexOfLootClass ) {
		Loot loot;
		if ( row == null ) {
			return null;
		}
		
		String[] elements = row.split( IOConstants.fileEntrySeparator );
		
		ArrayList<String> list    = new ArrayList<>();
		
		for ( int i = 0; i < elements.length; i++ ) {
			if ( elements[ i ] == null || elements[ i ].isEmpty() ) {
				list.add( " " );
			}
			else {
				list.add( elements[ i ] );
			}
		}
		loot = new Loot( list );
		return loot;
	}
}
