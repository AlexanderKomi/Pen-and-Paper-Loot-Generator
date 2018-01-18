package model.generator.generators;

import gui.controller.tabs.AlexGeneratorTabController;
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
		
		ArrayList<Configuration> array = this.tabController.getConfiguration();
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
	
	private String withConfig( ArrayList<Configuration> list ) {
		StringBuilder result = new StringBuilder();
		
		return result.toString();
	}
	
	private void setTabController( AlexGeneratorTabController tabController ) {
		this.tabController = tabController;
	}
}