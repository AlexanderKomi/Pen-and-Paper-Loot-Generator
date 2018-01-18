package model.generator;

import model.LootClass;

public class Configuration {
	
	private LootClass lootClass;
	private boolean[] searchAtColumnIndex;
	private int amount = 0;
	
	public Configuration( LootClass lootClass ) {
		this.lootClass = lootClass;
		this.searchAtColumnIndex = new boolean[ lootClass.getColumns().length ];
		
		for ( int i = 0; i < searchAtColumnIndex.length; i++ ) {
			searchAtColumnIndex[ i ] = false;
		}
	}
	
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	
	public void setSearchAtColumnIndex( int index, boolean value ) {
		this.searchAtColumnIndex[ index ] = value;
	}
	
	public int getAmountOfLoot() {
		return amount;
	}
	
	public void setAmount( int amount ) {
		this.amount = amount;
	}
	
}
