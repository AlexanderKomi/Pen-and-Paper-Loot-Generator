package model;

import model.generator.Configuration;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LootController {
	
	private static ArrayList<LootClass> lootClasses = new ArrayList<>();
	
	public LootController( ArrayList<LootClass> lootClasses ) {
		LootController.lootClasses = lootClasses;
	}
	
	
	public static Loot getRandomLoot() {
		int       randomNum = ThreadLocalRandom.current().nextInt( 0, lootClasses.size() );
		LootClass lootClass = lootClasses.get( randomNum );
		
		return lootClass.getRandomLoot();
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
	
	public static Loot getRandomLootFromClass( LootClass lootClass ) {
		return lootClass.getRandomLoot();
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
