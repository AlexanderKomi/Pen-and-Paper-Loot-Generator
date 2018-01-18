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
	private int      index;
	
	public LootClass( Header header, String content ) {
		this.name = header.getName();
		this.columns = header.getColumns();
		try {
			this.index = getInitialIndex();
			ArrayList<Loot> list = LootClassCreator.createItems( content, index );
			//list.forEach( System.out::println );
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
		int  randomNum = ThreadLocalRandom.current().nextInt( 0, items.length );
		Loot loot      = items[ randomNum ];
		
		while ( loot == null ) {
			randomNum = ThreadLocalRandom.current().nextInt( 0, items.length );
			loot = items[ randomNum ];
		}
		
		return loot;
	}
	
	private Loot getRandomLoot( Loot[] array ) throws Exception {
		
		if ( array.length > 0 ) {
			int  randomNum = ThreadLocalRandom.current().nextInt( 0, array.length );
			Loot loot      = array[ randomNum ];
			
			while ( loot == null ) {
				randomNum = ThreadLocalRandom.current().nextInt( 0, array.length );
				loot = array[ randomNum ];
			}
			return loot;
		}
		else {
			throw new Exception( "Given array is empty." );
		}
		
	}
	
	public Loot getRandomLootWithCategory( String category ) {
		ArrayList<Loot> lootArrayList = getAllFromCategory( category );
		Loot[]          array         = new Loot[ lootArrayList.size() ];
		lootArrayList.toArray( array );
		
		try {
			return getRandomLoot( array );
		}
		catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<String> filterDuplicatedEntries( String column ) {
		ArrayList<String> list = new ArrayList<>();
		
		int i = getColumnIndex( column );
		
		for ( Loot item : items ) {
			if ( item != null ) {
				ArrayList<String> otherEntries = item.getEntries();
				if ( otherEntries != null ) {
					String entry = otherEntries.get( i );
					if ( !list.contains( entry ) ) {
						list.add( entry );
					}
				}
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
	
	private ArrayList<Loot> getAllFromCategory( String category ) {
		
		ArrayList<Loot> lootArrayList = new ArrayList<>();
		
		int i = getColumnIndex( category );
		
		for ( Loot l : items ) {
			if ( l.getEntries().get( i ).equals( category ) ) {
				lootArrayList.add( l );
			}
		}
		return lootArrayList;
	}
	
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
	
	public String[] getColumns() {
		return columns;
	}
}
