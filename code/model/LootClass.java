package model;

import constants.IOConstants;
import io.dataLoading.Header;
import io.dataLoading.LootClassCreator;

import java.util.ArrayList;

public class LootClass {
	
	private String name;
	private ArrayList<String> columns = new ArrayList<>();
	private ArrayList<Loot> items;
	
	public LootClass( Header header, String content ) {
		this.name = header.getName();
		this.columns.addAll( header.getColumns() );
		try {
			int index = getIndex();
			this.items = LootClassCreator.createItems( content, index );
		}
		catch ( Exception e ) {
			e.printStackTrace();
			System.exit( 1 );
		}
	}
	
	private int getIndex() throws Exception {
		for ( int i = 0; i < IOConstants.lootClasses.length; i++ ) {
			if ( IOConstants.lootClasses[ i ].equals( this.name ) )
				return i;
		}
		throw new Exception( "Not a valid LootClass" );
	}
	
	@Override
	public String toString() {
		String        separator = ", ";
		StringBuilder sb        = new StringBuilder( "Name of lootclass : " + this.name );
		
		
		sb.append( "\n\n\t Columns : \n" );
		for ( String s : this.getColumns() ) {
			sb.append( s ).append( separator );
		}
		sb.deleteCharAt( sb.lastIndexOf( separator ) );
		
		
		sb.append( "\n\n\t Loot : \n" );
		for ( Loot l : this.getItems() ) {
			if ( l != null ) {
				if ( this.columns == null ) {
					System.out.println( " ---- COLUMNS ARE NULL" );
				}
				String x = l.toString( this.columns );
				sb.append( x ).append( separator ).append( "\n" );
			}
		}
		sb.deleteCharAt( sb.lastIndexOf( separator ) );
		
		return sb.toString();
	}
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	private ArrayList<Loot> getItems() {
		return items;
	}
	
	public void setItems( ArrayList<Loot> items ) {
		this.items = items;
	}
	
	private ArrayList<String> getColumns() {
		return columns;
	}
}
