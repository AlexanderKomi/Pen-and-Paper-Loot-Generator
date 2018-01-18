package model.generator;

import constants.IOConstants;
import model.Loot;
import model.LootClass;

import java.util.ArrayList;

public class Configuration {
	
	private LootClass lootClass;
	private boolean[] searchAtColumnIndex;
	private int amount = 0;
	
	private int   lootClassQualityIndex;
	private int[] minQuality;
	private int[] maxQuality;
	
	
	public Configuration( LootClass lootClass ) {
		this.lootClass = lootClass;
		setDefaultValues();
	}
	
	private void setDefaultValues() {
		this.lootClassQualityIndex = IOConstants.qualityIndexes[ lootClass.getIndex() ];
		this.searchAtColumnIndex = new boolean[ lootClass.getColumns().length ];
		this.minQuality = new int[ lootClass.getColumns().length ];
		this.maxQuality = new int[ lootClass.getColumns().length ];
		
		for ( int i = 0; i < searchAtColumnIndex.length; i++ ) {
			searchAtColumnIndex[ i ] = false;
			minQuality[ i ] = 0;
			maxQuality[ i ] = Integer.MAX_VALUE;
		}
	}
	
	public ArrayList<Loot> createRandomLoot() {
		ArrayList<Loot> result = new ArrayList<>();
		ArrayList<Loot> list   = createLootableItems();
		
		for ( int i = 0; i < getAmountOfLoot(); i++ ) {
			Loot l = list.get( Generator.getRandomInt( 0, list.size() ) );
			if ( l != null ) {
				result.add( l );
			}
		}
		return result;
	}
	
	
	private ArrayList<Loot> createLootableItems() {
		
		ArrayList<Loot> loot = new ArrayList<>();
		
		for ( int i = 0; i < searchAtColumnIndex.length; i++ ) {
			if ( searchAtColumnIndex[ i ] ) {
				
				for ( Loot item : lootClass.getItems() ) {
					if ( item.getEntry( i ) != null ) {
						
						// Do specific restrictions to an item here!
						
							if ( fitsQualityRequirements( item ) ) {
								loot.add( item );
							}
						
						
					}
				}
			}
		}
		
		return loot;
	}
	
	private boolean fitsQualityRequirements( Loot loot ) {
		int i           = lootClassQualityIndex;
		int lootQuality = Integer.parseInt( loot.getEntry( i ) );
		return minQuality[ i ] <= lootQuality && lootQuality <= maxQuality[ i ];
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
	
	public void setMinQualityAtIndex( int index, Integer selectedItem ) {
		this.minQuality[ index ] = selectedItem;
	}
}
