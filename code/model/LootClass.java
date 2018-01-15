package model;

import constants.IOConstants;
import io.FileLogger;
import io.dataLoading.Header;
import io.dataLoading.LootClassCreator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LootClass {
	
	private String   name;
	private String[] columns;
	private Loot[]   items;
	
	public LootClass( Header header, String content ) {
		this.name = header.getName();
		this.columns = header.getColumns();
		try {
			int             index = getIndex();
			ArrayList<Loot> list  = LootClassCreator.createItems( content, index );
			items = new Loot[ list.size() ];
			list.toArray( items );
		}
		catch ( Exception e ) {
			e.printStackTrace();
			FileLogger.getLogger().info( e.getMessage() );
			System.exit( 1 );
		}
	}
	
	public Loot getRandomLoot() {
		int randomNum = ThreadLocalRandom.current().nextInt( 0, items.length );
		return items[ randomNum ];
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
	
	private int getIndex() throws Exception {
		for ( int i = 0; i < IOConstants.lootClasses.length; i++ ) {
			if ( IOConstants.lootClasses[ i ].equals( this.name ) )
				return i;
		}
		throw new Exception( "Not a valid LootClass" );
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	private Loot[] getItems() {
		return items;
	}
	
	public void setItems( ArrayList<Loot> items ) {
		this.items = new Loot[ items.size() ];
		items.toArray( this.items );
	}
	
	public void setItems( Loot[] items ) {
		this.items = items;
	}
	
	private String[] getColumns() {
		return columns;
	}
}
