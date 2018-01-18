package model;

import java.util.ArrayList;

public final class Filter {
	
	public static ArrayList<String> filterDuplicatedEntries( Loot[] items, String column ) {
		ArrayList<String> list = new ArrayList<>();
		
		for ( Loot item : items ) {
			String entry = item.getEntries().get( column );
			if ( !list.contains( entry ) ) {
				list.add( entry );
			}
		}
		return list;
	}
	
	public static ArrayList<String> filterDuplicatedEntries( ArrayList<Loot> items, String column ) {
		ArrayList<String> list = new ArrayList<>();
		
		for ( Loot item : items ) {
			String entry = item.getEntries().get( column );
			if ( !list.contains( entry ) ) {
				list.add( entry );
			}
		}
		return list;
	}
	
	public static ArrayList<Loot> filterDependency( ArrayList<Loot> items, String dependecyColumn, String dependencyValue ) {
		ArrayList<Loot> lootArrayList = new ArrayList<>();
		
		for ( Loot item : items ) {
			String depValue = item.getEntries().get( dependecyColumn );
			if ( depValue.equals( dependencyValue ) ) {
				lootArrayList.add( item );
			}
		}
		return lootArrayList;
	}
	
	public static ArrayList<Loot> filterDependency( Loot[] items, String dependecyColumn, String dependencyValue ) {
		ArrayList<Loot> lootArrayList = new ArrayList<>();
		
		for ( Loot item : items ) {
			String depValue = item.getEntries().get( dependecyColumn );
			if ( depValue.equals( dependencyValue ) ) {
				lootArrayList.add( item );
			}
		}
		return lootArrayList;
	}
	
}
