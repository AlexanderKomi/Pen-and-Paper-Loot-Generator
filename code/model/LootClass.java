package model;

import io.IOConstants;
import io.dataLoading.Header;
import model.generator.Configuration;

import java.util.ArrayList;
import java.util.Collections;

public class LootClass {
	
	private Configuration   configuration;
	private String          name;
	private String[]        columns;
	private ArrayList<Loot> items;
	private int             index;
	
	public LootClass( Header header, ArrayList<Loot> loot ) {
		this.name = header.getName();
		this.columns = header.getColumns();
		this.items = loot;
		try {
			this.index = getInitialIndex();
		}
		catch ( Exception e ) {
			e.printStackTrace();
			System.exit( 1 );
		}
		this.configuration = new Configuration( this );
	}
	
	public ArrayList<String> filterDuplicatedEntries( String column ) {
		return Filter.filterDuplicatedEntries( this.items, column );
	}
	
	public ArrayList<String> filterDuplicatedEntries( ArrayList<String> columns ) {
		return Filter.filterDuplicatedEntries( this.items, columns );
	}
	
	public ArrayList<String> filterDuplicatedEntries( String[] columns ) {
		return Filter.filterDuplicatedEntries( this.items, columns );
	}
	
	public ArrayList<String> filterDuplicatesWithDependency( String column, String dependencyColumn, String dependencyValue ) {
		ArrayList<Loot> lootList = Filter.filterDependency( this.items, dependencyColumn, dependencyValue );
		return Filter.filterDuplicatedEntries( lootList, column );
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
				String x = l.toString();
				sb.append( x ).append( separator ).append( "\n" );
			}
		}
		sb.deleteCharAt( sb.lastIndexOf( separator ) );
		
		return sb.toString();
	}
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	private int getInitialIndex() throws Exception {
		for ( int i = 0; i < IOConstants.lootClasses.length; i++ ) {
			if ( IOConstants.lootClasses[ i ].equals( this.name ) )
				return i;
		}
		throw new Exception( "Not a valid LootClass" );
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getColumnIndex( String column ) {
		int i;
		for ( i = 0; i < columns.length; i++ ) {
			if ( columns[ i ].equals( column ) ) {
				break;
			}
		}
		return i;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public ArrayList<Loot> getItems() {
		return items;
	}
	
	public void setItems( Loot[] items ) {
		Collections.addAll( this.items, items );
	}
	
	public void setItems( ArrayList<Loot> items ) {
		Loot[] loot = new Loot[ items.size() ];
		items.toArray( loot );
	}
	
	public String[] getColumns() {
		return columns;
	}
	
	public Configuration getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration( Configuration configuration ) {
		this.configuration = configuration;
	}
}
