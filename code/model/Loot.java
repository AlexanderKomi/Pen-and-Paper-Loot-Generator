package model;

import java.util.ArrayList;

public class Loot {
	
	private String            name;
	private int               qualityAsNumber;
	private ArrayList<String> otherEntries;
	
	public Loot( String name, int qualityAsNumber, ArrayList<String> otherEntries ) {
		this.name = name;
		this.qualityAsNumber = qualityAsNumber;
		this.otherEntries = ( otherEntries );
	}
	
	@Override
	public String toString() {
		String        separator = "; ";
		StringBuilder sb        = new StringBuilder( this.getName() ).append( separator ).append( "\n" );
		sb.append( this.getQualityAsNumber() ).append( separator ).append( "\n" );
		for ( String s : this.getOtherEntries() ) {
			String x;
			if ( s.isEmpty() || s.equals( " " ) ) {
				x = " ";
			}
			else {
				x = s;
			}
			sb.append( x ).append( separator ).append( "\n" );
		}
		sb.deleteCharAt( sb.lastIndexOf( separator ) ).deleteCharAt( sb.lastIndexOf( "\n" ) );
		
		return sb.toString();
	}
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	
	private String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	private int getQualityAsNumber() {
		return qualityAsNumber;
	}
	
	public void setQualityAsNumber( int qualityAsNumber ) {
		this.qualityAsNumber = qualityAsNumber;
	}
	
	private ArrayList<String> getOtherEntries() {
		return otherEntries;
	}
	
	public void setOtherEntries( ArrayList<String> otherEntries ) {
		this.otherEntries = otherEntries;
	}
}