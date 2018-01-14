package model.generator.generators;

import model.generator.Generator;

public class ExampleGenerator extends Generator {
	
	public ExampleGenerator( String name ) {
		super.setName( name );
	}
	
	@Override
	public String generateLoot() {
		return "Cool loot has been generated :)";
	}
}