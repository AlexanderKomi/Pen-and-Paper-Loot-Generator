package model;

import java.util.ArrayList;

public class LootClass {
	
	private String name;
	private ArrayList<Loot> items = new ArrayList<>();
	
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public ArrayList<Loot> getItems() {
		return items;
	}
	
	public void setItems( ArrayList<Loot> items ) {
		this.items = items;
	}
}
