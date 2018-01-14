package model;

import java.util.ArrayList;
import java.util.ListIterator;

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
	
	public String toString( ArrayList<String> columns ) {
		
		if ( columns != null ) {
			
			final String  descriptor = "\t:\t";
			final String  separator  = "; ";
			final String  breaker    = "\n";
			StringBuilder sb         = new StringBuilder();
			sb.append( columns.get( 0 ) ).append( descriptor ).append( this.getName() );
			sb.append( separator ).append( breaker );
			sb.append( columns.get( 1 ) ).append( descriptor ).append( this.getQualityAsNumber() );
			sb.append( separator ).append( breaker );
			
			ListIterator<String> iter = columns.listIterator( 2 );
			for ( String s : this.getOtherEntries() ) {
				String x;
				if ( s.isEmpty() || s.equals( " " ) ) {
					x = " ";
				}
				else {
					x = s;
				}
				if ( iter.hasNext() ) {
					String content = iter.next();
					if ( content != null ) {
						sb.append( content ).append( descriptor ).append( x ).append( separator ).append( breaker );
					}
				}
				else {
					sb.append( x ).append( separator ).append( breaker );
				}
			}
			sb.deleteCharAt( sb.lastIndexOf( separator ) ).deleteCharAt( sb.lastIndexOf( breaker ) );
			
			return sb.toString();
		}
		
		return this.toString();
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