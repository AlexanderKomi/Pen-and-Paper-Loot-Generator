package model;

import constants.IOConstants;
import io.FileLogger;
import io.dataLoading.Header;
import io.dataLoading.LootClassCreator;
import model.generator.Configuration;

import java.util.ArrayList;

public class LootClass {
	
	private Configuration configuration;
	private String        name;
	private String[]      columns;
	private Loot[]        items;
	private int           index;
	
	public LootClass( Header header, String content ) {
		this.name = header.getName();
		this.columns = header.getColumns();
		try {
			this.index = getInitialIndex();
			ArrayList<Loot> list = LootClassCreator.createItems( content, columns );
			//list.forEach( System.out::println );
			items = new Loot[ list.size() ];
			list.toArray( items );
		}
		catch ( Exception e ) {
			e.printStackTrace();
			FileLogger.getLogger().info( e.getMessage() );
			System.exit( 1 );
		}
		configuration = new Configuration( this );
	}
	
	public ArrayList<String> filterDuplicatedEntries( String column ) {
		ArrayList<String> list = new ArrayList<>();
		
		for ( Loot item : items ) {
			String entry = item.getEntries().get( column );
			if ( !list.contains( entry ) ) {
				list.add( entry );
			}
		}
		return list;
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
	
	public Loot[] getItems() {
		return items;
	}
	
	public void setItems( ArrayList<Loot> items ) {
		this.items = new Loot[ items.size() ];
		items.toArray( this.items );
	}
	
	public void setItems( Loot[] items ) {
		this.items = items;
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
