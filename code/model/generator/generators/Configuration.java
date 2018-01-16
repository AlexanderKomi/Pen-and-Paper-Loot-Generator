package model.generator.generators;

public class Configuration {
	
	private int      lootClassIndex;
	private String[] config;
	private int amount = 0;
	
	public Configuration( int lootClassIndex, int configLength ) {
		this.lootClassIndex = lootClassIndex;
		this.config = new String[ configLength ];
	}
	
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	
	public String[] getConfig() {
		return config;
	}
	
	public int getAmountOfLoot() {
		return amount;
	}
	
	public void setConfig( int index, String selectedItem ) {
		this.config[ index ] = selectedItem;
	}
	
	public void setConfig( int index, int selectedItem ) {
		this.config[ index ] = String.valueOf( selectedItem );
	}
	
	public void setAmount( int amount ) {
		this.amount = amount;
	}
	
	public int getLootClassIndex() {
		return lootClassIndex;
	}
	
	public void setLootClassIndex( int lootClassIndex ) {
		this.lootClassIndex = lootClassIndex;
	}
}
