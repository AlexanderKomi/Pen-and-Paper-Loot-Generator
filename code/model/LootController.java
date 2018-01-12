package model;

import java.util.ArrayList;

public class LootController {
	
	private static ArrayList<LootClass> lootClasses = new ArrayList<>();
	
	public LootController( ArrayList<LootClass> lootClasses ) {
		LootController.lootClasses = lootClasses;
	}
	
	
	// -------------------------------- GETTER AND SETTER -------------------------------------------
	
	public static LootClass getLootClassByName( String name ) {
		for ( LootClass lootClass : lootClasses ) {
			if ( lootClass.getName().equals( name ) ) {
				return lootClass;
			}
		}
		return null;
	}
	
	public static ArrayList<LootClass> getLootClasses() {
		return lootClasses;
	}
	
	public static void setLootClasses( ArrayList<LootClass> lootClasses ) {
		LootController.lootClasses = lootClasses;
	}
}
