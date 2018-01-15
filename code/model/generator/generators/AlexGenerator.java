package model.generator.generators;

import model.Loot;
import model.LootClass;
import model.LootController;
import model.generator.Generator;

public class AlexGenerator extends Generator {
	
	public AlexGenerator() {
		this.setName( "Alex Generator" );
	}
	
	@Override
	public String generateLoot() {
		
		try {
			LootClass lootClass = LootController.getLootClassByName( "Waffen" );
			Loot      l         = lootClass.getRandomLoot();
			return l.toString( lootClass.getColumns() );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		return "Nothing can be found";
	}
	
}