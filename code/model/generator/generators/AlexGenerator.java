package model.generator.generators;

import gui.controller.tabs.AlexGeneratorTabController;
import model.Loot;
import model.LootClass;
import model.LootController;
import model.generator.Generator;

public class AlexGenerator extends Generator {
	
	private AlexGeneratorTabController tabController;
	
	public AlexGenerator( AlexGeneratorTabController alexGeneratorTabController ) {
		this.setTabController( alexGeneratorTabController );
		this.setName( "Alex Generator" );
	}
	
	@Override
	public String generateLoot() {
		
		String result = "";
		
		Configuration[] array = this.tabController.getConfiguration();
		if ( array == null ) {
			result = noConfigSet();
		}
		else {
			result = withConfig( array );
		}
		
		return result;
	}
	
	private String noConfigSet() {
		return LootController.getRandomLoot().toString();
	}
	
	private String withConfig( Configuration[] array ) {
		StringBuilder result = new StringBuilder();
		
		for ( Configuration c : array ) {
			if ( c.getAmountOfLoot() > 0 ) {
				
				String[] config = c.getConfig();
				for ( String category : config ) {
					
					if ( category != null ) {
						for ( int j = 0; j < c.getAmountOfLoot(); j++ ) {
							LootClass lootClass = LootController.getLootClassByIndex( c.getLootClassIndex() );
							Loot      loot      = lootClass.getRandomLootWithCategory( category );
							result.append( loot.toString() ).append( "\n" );
						}
					}
				}
			}
		}
		return result.toString();
	}
	
	private void setTabController( AlexGeneratorTabController tabController ) {
		this.tabController = tabController;
	}
}