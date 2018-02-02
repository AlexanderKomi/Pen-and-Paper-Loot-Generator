package io.dataLoading;

import io.IOConstants;
import io.dataLoading.read.StringManipulator;
import model.Loot;

import java.util.ArrayList;
import java.util.HashMap;

public final class LootClassCreator {
	
	public ArrayList<Loot> createLoot( Header header, String lootContent ) {
		return createLoot( lootContent, header.getColumns() );
	}
	
	private ArrayList<Loot> createLoot( String content, String[] columns ) {
		
		ArrayList<Loot> loot = new ArrayList<>();
		String[]        rows = content.split( IOConstants.fileRowSeparator );
		
		for ( String row : StringManipulator.deleteEmptyStart( rows ) ) {
			
			ArrayList<String> lootContent = createLootContent( row );
			
			if ( lootContent != null ) {
				if ( lootContent.size() == columns.length ) {
					loot.add( new Loot( createLootMap( lootContent, columns ) ) );
				}
				else {
					try {
						throw new Exception( "list size != columns length!" );
					}
					catch ( Exception e ) {
						e.printStackTrace();
						System.exit( 1 );
					}
				}
			}
		}
		return loot;
	}
	
	private HashMap<String, String> createLootMap( ArrayList<String> lootContent, String[] columns ) {
		HashMap<String, String> map = new HashMap<>();
		for ( int i = 0; i < columns.length; i++ ) {
			String column = columns[ i ];
			map.put( column, lootContent.get( i ) );
		}
		return map;
	}
	
	private ArrayList<String> createLootContent( String row ) {
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
