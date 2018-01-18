package model;

import java.util.HashMap;

public class Loot {
	
	private HashMap<String, String> entries;
	
	public Loot( HashMap<String, String> otherEntries ) {
		this.entries = ( otherEntries );
	}
	
	@Override
	public String toString() {
		final String separator = "\t; \t";
		final String breaker   = "\n";
		
		StringBuilder sb = new StringBuilder();
		
		for ( String s : entries.keySet() ) {
			sb.append( s ).append( separator ).append( entries.get( s ) ).append( breaker );
		}
		sb.append( breaker );
		
		return sb.toString();
	}
	
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public boolean containsKey( String key ) {
		return this.entries.containsKey( key );
	}
	
	public boolean containsValue( String value ) {
		return this.entries.containsValue( value );
	}
	
	public String getEntry( String key ) {
		return this.entries.get( key );
	}
	
	public HashMap<String, String> getEntries() {
		return entries;
	}
}