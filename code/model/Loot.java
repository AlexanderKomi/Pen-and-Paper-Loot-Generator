package model;

import constants.IOConstants;

import java.util.ArrayList;

public class Loot {
	
	private ArrayList<String> entries;
	
	public Loot( ArrayList<String> otherEntries ) {
		this.entries = ( otherEntries );
	}
	
	@Override
	public String toString() {
		final String separator = "; ";
		final String breaker   = "\n";
		
		StringBuilder sb = new StringBuilder();
		
		for ( String s : this.getEntries() ) {
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
			
			int i = 0;
			for ( String s : this.getEntries() ) {
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
	
	public String getEntry( int index ) {
		return this.entries.get( index );
	}
	
	public ArrayList<String> getEntries() {
		return entries;
	}
	
	public void setEntries( ArrayList<String> entries ) {
		this.entries = entries;
	}
	
	public String getName( int lootClassIndex ) {
		return entries.get( IOConstants.nameIndexes[ lootClassIndex ] );
	}
}