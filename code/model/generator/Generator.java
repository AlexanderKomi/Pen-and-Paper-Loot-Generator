package model.generator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * When you want to create a new generator:
 * <p>
 * pls create a new class, extend this class, overload generateLoot() and register it in LootGeneratorController.
 */
public abstract class Generator {
	
	private String name;
	
	public static int getRandomInt( int min, int max ) {
		return ThreadLocalRandom.current().nextInt( min, max );
	}
	
	public abstract String generateLoot();  // This method produces the output! You need to implement this class in your Extended CLass
	//-------------------------------------- GETTER AND SETTER --------------------------------------
	
	public String getName() {
		return name;
	}
	
	protected void setName( String name ) {
		this.name = name;
	}
}
