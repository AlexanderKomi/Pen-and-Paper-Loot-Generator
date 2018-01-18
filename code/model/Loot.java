package model;

import java.util.HashMap;

public class Loot {
	
	private HashMap<String, String> entries;
	
	public Loot( HashMap<String, String> otherEntries ) {
		this.entries = ( otherEntries );
	}
	
	@Override
	public String toString() {
		final String separator = "; ";
		final String breaker   = "\n";
		
		StringBuilder sb = new StringBuilder();
		
		for ( String s : this.getEntries().values() ) {
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
			for ( String s : this.getEntries().values() ) {
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
	
	public String getEntry( String key ) {
		return this.entries.get( key );
	}
	
	public HashMap<String, String> getEntries() {
		return entries;
	}
}