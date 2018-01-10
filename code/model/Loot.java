package model;

import java.util.ArrayList;

public class Loot {
	
	private String            name            = "";
	private int               qualityAsNumber = 0;
	private ArrayList<String> otherEntries    = new ArrayList<>();
	
	public Loot() {
	
	}
	
	public Loot( String name, int qualityAsNumber, ArrayList<String> otherEntries ) {
		this.name = name;
		this.qualityAsNumber = qualityAsNumber;
		this.otherEntries.addAll( otherEntries );
	}
	
	@Override
	public String toString() {
		String        separator = ", ";
		StringBuilder sb        = new StringBuilder( this.getName() ).append( separator ).append( "\n" );
		sb.append( this.getQualityAsNumber() ).append( separator );
		
		for ( String s : this.getOtherEntries() ) {
			sb.append( s ).append( ", " );
		}
		
		return sb.toString();
	}
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public int getQualityAsNumber() {
		return qualityAsNumber;
	}
	
	public void setQualityAsNumber( int qualityAsNumber ) {
		this.qualityAsNumber = qualityAsNumber;
	}
	
	public ArrayList<String> getOtherEntries() {
		return otherEntries;
	}
	
	public void setOtherEntries( ArrayList<String> otherEntries ) {
		this.otherEntries = otherEntries;
	}
}