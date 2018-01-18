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
		
		for ( int i = 0; i < minQuality.length; i++ ) {
			minQuality[ i ] = 0;
			maxQuality[ i ] = Integer.MAX_VALUE;
		}
	}
	
	public ArrayList<Loot> createRandomLoot() {
		ArrayList<Loot> result = new ArrayList<>();
		ArrayList<Loot> list   = createLootableItems();
		
		if ( !list.isEmpty() ) {
			for ( int i = 0; i < getAmountOfLoot(); i++ ) {
				int  random = Generator.getRandomInt( 0, list.size() );
				Loot l      = list.get( random );
				if ( l != null ) {
					result.add( l );
				}
			}
		}
		else {
			System.out.println( " Attention : list for useable loot is empty. Look at : Configuration.createRandomLoot() for more information." );
		}
		return result;
	}
	
	
	private ArrayList<Loot> createLootableItems() {
		
		
		return new ArrayList<>();
	}
	
	private boolean fitsQualityRequirements( Loot loot, String qualityName ) {
		int i           = lootClassQualityIndex;
		int lootQuality = Integer.parseInt( loot.getEntry( qualityName ) );
		return minQuality[ i ] <= lootQuality && lootQuality <= maxQuality[ i ];
	}
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	
	private int getAmountOfLoot() {
		return amount;
	}
	
	public void setAmount( int amount ) {
		this.amount = amount;
	}
	
	public void setMinQualityAtIndex( int index, Integer selectedItem ) {
		this.minQuality[ index ] = selectedItem;
	}
	
	public void setSearchAtColumnIndex( int typ, boolean b ) {
		this.searchAtColumnIndex[ typ ] = b;
	}
}
