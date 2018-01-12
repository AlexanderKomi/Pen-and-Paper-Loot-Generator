package model.generator;

/**
 * When you want to create a new generator:
 * <p>
 * pls create a new class, extend this class, overload generateLoot() and register it in LootGeneratorController.
 */
public abstract class Generator {
	
	private String name;
	
	public String generateLoot() {
		return "";
	}
	
	//-------------------------------------- GETTER AND SETTER --------------------------------------
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
}
