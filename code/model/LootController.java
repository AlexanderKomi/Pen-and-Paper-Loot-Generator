package model;

import model.generator.Configuration;

import java.util.ArrayList;

public class LootController {
	
	private static ArrayList<LootClass> lootClasses = new ArrayList<>();
	
	public LootController( ArrayList<LootClass> lootClasses ) {
		LootController.lootClasses = lootClasses;
	}
	
	
	// -------------------------------- GETTER AND SETTER -------------------------------------------
	
	public static LootClass getLootClassByName( String name ) throws Exception {
		for ( LootClass lootClass : lootClasses ) {
			if ( lootClass.getName().equals( name ) ) {
				return lootClass;
			}
		}
		throw new Exception( "Class can not be found" );
	}
	
	public static LootClass getLootClassByIndex( int index ) {
		return lootClasses.get( index );
	}
	
	public static ArrayList<LootClass> getLootClasses() {
		return lootClasses;
	}
	
	public static void setLootClasses( ArrayList<LootClass> lootClasses ) {
		LootController.lootClasses = lootClasses;
	}
	
	public static ArrayList<Configuration> getConfiguration() {
		ArrayList<Configuration> list = new ArrayList<>();
		for ( LootClass l : lootClasses ) {
			list.add( l.getConfiguration() );
		}
		return list;
	}
}
