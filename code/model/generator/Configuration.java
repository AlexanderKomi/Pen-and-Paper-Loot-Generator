package model.generator;

import io.IOConstants;
import model.Loot;
import model.LootClass;

import java.util.ArrayList;

public class Configuration {
	
	private LootClass lootClass;
	private int amount = 0;
	
	//--------------------------------------------- QUALITY
	private boolean searchFixValueQuality = false;
	private boolean searchMinQuality      = false;
	private boolean searchMaxQuality      = false;
	
	private int fixQuality;
	private int minQuality;
	private int maxQuality;
	
	//--------------------------------------------- TYPE
	private boolean searchForType = false;
	private String type;
	
	
	//--------------------------------------------- CATEGORY
	private boolean searchForCategory = false;
	private String category;
	
	
	//--------------------------------------------- NAME
	private boolean searchForName = false;
	private String name;
	
	
	public Configuration( LootClass lootClass ) {
		this.lootClass = lootClass;
	}
	
	public ArrayList<Loot> createRandomLoot() {
		ArrayList<Loot> result = new ArrayList<>();
		ArrayList<Loot> list   = createLootableItems();
		
		if ( !list.isEmpty() ) {
			
			for ( int i = 0; i < getAmount(); i++ ) {
				int  random = Generator.getRandomInt( 0, list.size() );
				Loot l      = list.get( random );
				result.add( l );
			}
			
		}
		else {
			System.out.println( " Attention : list for useable loot is empty. LootClass : " + lootClass.getName() + " \nLook at : Configuration.createRandomLoot() for more information." );
		}
		return result;
	}
	
	
	private ArrayList<Loot> createLootableItems() {
		
		ArrayList<Loot> list = new ArrayList<>();
		
		for ( Loot loot : lootClass.getItems() ) {
			if ( fitsRequirements( loot ) ) {
				list.add( loot );
			}
		}
		
		return list;
	}
	
	private boolean fitsRequirements( Loot loot ) {
		if ( fitsQualityRequirements( loot ) ) {
			if ( fitsTypeRequirements( loot ) ) {
				if ( fitsNameRequirements( loot ) ) {
					return fitsCategoryRequirements( loot );
				}
			}
		}
		return false;
	}
	
	private boolean fitsNameRequirements( Loot loot ) {
		if ( searchForName ) {
			return loot.getEntries().values().contains( name );
		}
		return true;
	}
	
	private boolean fitsCategoryRequirements( Loot loot ) {
		if ( searchForCategory ) {
			return loot.getEntries().values().contains( category );
		}
		return true;
	}
	
	private boolean fitsTypeRequirements( Loot loot ) {
		if ( searchForType ) {
			return loot.getEntries().values().contains( type );
		}
		return true;
	}
	
	private boolean fitsQualityRequirements( Loot loot ) {
		// get Entry in Loot
		int    index            = IOConstants.qualityIndexes[ lootClass.getIndex() ];
		String quality          = lootClass.getColumns()[ index ];
		String lootQualityEntry = loot.getEntries().get( quality );
		
		// compare value from loot
		int lootQuality = Integer.parseInt( lootQualityEntry );
		
		//System.out.println("Comparing : " +loot.getEntries().get( "Name" )+" , "+ lootQuality);
		
		return compareQualityRequirements( lootQuality );
	}
	
	private boolean compareQualityRequirements( int lootQuality ) {
		
		if ( searchMinQuality ) {
			if ( minQuality > lootQuality ) {
				return false;
			}
		}
		if ( searchMaxQuality ) {
			if ( maxQuality < lootQuality ) {
				return false;
			}
		}
		if ( searchFixValueQuality ) {
			return fixQuality == lootQuality;
		}
		return true;
	}
	
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	private int getAmount() {
		return amount;
	}
	
	public void setAmount( int amount ) {
		this.amount = amount;
	}
	
	public void setFixQuality( int fixQuality ) {
		this.fixQuality = fixQuality;
	}
	
	public void setMaxQuality( int maxQuality ) {
		this.maxQuality = maxQuality;
	}
	
	public void setMinQuality( int minQuality ) {
		this.minQuality = minQuality;
	}
	
	public void setSearchForType( boolean searchForType ) {
		this.searchForType = searchForType;
	}
	
	public void setType( String type ) {
		this.type = type;
	}
	
	public void setSearchMinQuality( boolean searchMinQuality ) {
		this.searchMinQuality = searchMinQuality;
	}
	
	public void setSearchMaxQuality( boolean searchMaxQuality ) {
		this.searchMaxQuality = searchMaxQuality;
	}
	
	public void setSearchFixValueQuality( boolean searchFixValueQuality ) {
		this.searchFixValueQuality = searchFixValueQuality;
	}
	
	public boolean isSearchForCategory() {
		return searchForCategory;
	}
	
	public void setSearchForCategory( boolean searchForCategory ) {
		this.searchForCategory = searchForCategory;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory( String category ) {
		this.category = category;
	}
	
	public boolean isSearchForName() {
		return searchForName;
	}
	
	public void setSearchForName( boolean searchForName ) {
		this.searchForName = searchForName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
}
