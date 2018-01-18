package model.generator.generators;

import gui.controller.tabs.AlexGeneratorTabController;
import model.Loot;
import model.LootController;
import model.generator.Configuration;
import model.generator.Generator;

import java.util.ArrayList;

public class AlexGenerator extends Generator {
	
	private AlexGeneratorTabController tabController;
	
	public AlexGenerator( AlexGeneratorTabController alexGeneratorTabController ) {
		this.setTabController( alexGeneratorTabController );
		this.setName( "Alex Generator" );
	}
	
	@Override
	public String generateLoot() {
		
		String result;
		this.tabController.initControllerConfig();
		ArrayList<Configuration> array = LootController.getConfiguration();
		if ( array == null ) {
			result = noConfigSet();
		}
		else {
			result = withConfig( array );
		}
		
		return result;
	}
	
	private String noConfigSet() {
		return "";
	}
	
	private String withConfig( ArrayList<Configuration> list ) {
		StringBuilder result = new StringBuilder();
		
		ArrayList<Loot> loot = new ArrayList<>();
		
		for ( Configuration c : list ) {
			ArrayList<Loot> helper = c.createRandomLoot();
			loot.addAll( helper );
		}
		
		for ( Loot item : loot ) {
			result.append( item.toString() );
		}
		
		return result.toString();
	}
	
	private void setTabController( AlexGeneratorTabController tabController ) {
		this.tabController = tabController;
	}
}