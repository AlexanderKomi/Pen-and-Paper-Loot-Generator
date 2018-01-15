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
		final String separator = "; ";
		final String breaker   = "\n";
		
		StringBuilder sb = new StringBuilder( this.getName() ).append( separator ).append( breaker );
		sb.append( this.getQualityAsNumber() ).append( separator ).append( breaker );
		for ( String s : this.getOtherEntries() ) {
			String x;
			if ( s.isEmpty() || s.equals( " " ) ) {
				x = " ";
			}
			else {
				x = s;
			}
			sb.append( x ).append( separator ).append( breaker );
		}
		sb.deleteCharAt( sb.lastIndexOf( separator ) ).deleteCharAt( sb.lastIndexOf( breaker ) );
		
		return sb.toString();
	}
	
	public String toString( String[] columns ) {
		
		if ( columns != null ) {
			
			final String descriptor = "\t:\t";
			final String separator  = "; ";
			final String breaker    = "\n";
			
			StringBuilder sb = new StringBuilder();
			
			sb.append( columns[ 0 ] ).append( descriptor ).append( this.getName() );
			sb.append( separator ).append( breaker );
			sb.append( columns[ 1 ] ).append( descriptor ).append( this.getQualityAsNumber() );
			sb.append( separator ).append( breaker );
			
			int i = 2;
			for ( String s : this.getOtherEntries() ) {
				String x;
				if ( s.isEmpty() || s.equals( " " ) ) {
					x = " ";
				}
				else {
					x = s;
				}
				
				if ( i < columns.length ) {
					String content = columns[ i ];
					if ( content != null ) {
						sb.append( content ).append( descriptor ).append( x ).append( separator ).append( breaker );
					}
				}
				else {
					sb.append( x ).append( separator ).append( breaker );
				}
				i++;
			}
			sb.deleteCharAt( sb.lastIndexOf( separator ) ).deleteCharAt( sb.lastIndexOf( breaker ) );
			
			return sb.toString();
		}
		
		return this.toString();
	}
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	
	public String getName() {
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
	
	public ArrayList<String> getOtherEntries() {
		return otherEntries;
	}
	
	public void setOtherEntries( ArrayList<String> otherEntries ) {
		this.otherEntries = otherEntries;
	}
	
	public int getQuality() {
		return qualityAsNumber;
	}
}