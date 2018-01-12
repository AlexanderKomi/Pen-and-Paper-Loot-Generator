package model.generator;


import model.generator.generators.ExampleGenerator;

import java.util.ArrayList;

/**
 * Implement randomised loot creation here.
 */
public class LootGeneratorController {
	
	private static ArrayList<Generator> generators = new ArrayList<>();
	
	
	public static void addGenerators() {
		addExsampleGenerators();
	}
	
	private static void addExsampleGenerators() {
		generators.add( new ExampleGenerator( "Example Generator" ) );
	}
	
	//-------------------------------------- GETTER AND SETTER --------------------------------------
	
	public static ArrayList<Generator> getGenerators() {
		return generators;
	}
}