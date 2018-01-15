package model;

import java.util.ArrayList;

public class LootController {
	
	private static ArrayList<LootClass> lootClasses = new ArrayList<>();
	
	public LootController( ArrayList<LootClass> lootClasses ) {
		LootController.lootClasses = lootClasses;
	}
	
	public static Loot getRandomLootFromClass( String lootclass ) {
		try {
			LootClass lootcl = getLootClassByName( lootclass );
			return lootcl.getRandomLoot();
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
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
	
	public static ArrayList<LootClass> getLootClasses() {
		return lootClasses;
	}
	
	public static void setLootClasses( ArrayList<LootClass> lootClasses ) {
		LootController.lootClasses = lootClasses;
	}
}
