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
			this.index = getIndex();
			ArrayList<Loot> list = LootClassCreator.createItems( content, index );
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
	
	private Loot getRandomLoot( Loot[] array ) {
		int  randomNum = ThreadLocalRandom.current().nextInt( 0, items.length );
		Loot loot      = array[ randomNum ];
		
		while ( loot == null ) {
			randomNum = ThreadLocalRandom.current().nextInt( 0, items.length );
			loot = array[ randomNum ];
		}
		
		return loot;
	}
	
	public Loot getRandomLootWithCategory( String category ) {
		ArrayList<Loot> lootArrayList = getAllFromCategory( category );
		Loot[]          array         = new Loot[ lootArrayList.size() ];
		lootArrayList.toArray( array );
		return getRandomLoot( array );
	}
	
	public ArrayList<String> filterDuplicates( String column ) {
		
		int i;
		for ( i = 0; i < columns.length; i++ ) {
			//System.out.println( "columns [" + i + "] = " + columns[ i ] );
			if ( columns[ i ].equals( column ) ) {
				break;
			}
		}
		
		ArrayList<String> list;
		if ( i == IOConstants.nameIndexes[ this.index ] ) {
			list = filterName();
		}
		else if ( i == IOConstants.qualityIndexes[ this.index ] ) {
			list = filterQuality();
		}
		else {
			list = filterOtherEntries( i );
		}
		
		return list;
	}
	
	private ArrayList<String> filterName() {
		ArrayList<String> list = new ArrayList<>();
		
		for ( Loot item : items ) {
			if ( item != null ) {
				String name = item.getName();
				if ( !list.contains( name ) ) {
					list.add( name );
				}
			}
		}
		
		return list;
	}
	
	private ArrayList<String> filterQuality() {
		ArrayList<String> list = new ArrayList<>();
		
		for ( Loot item : items ) {
			if ( item != null ) {
				String quality = String.valueOf( item.getQuality() );
				if ( !list.contains( String.valueOf( quality ) ) ) {
					list.add( quality );
				}
			}
		}
		
		return list;
	}
	
	private ArrayList<String> filterOtherEntries( int i ) {
		ArrayList<String> list = new ArrayList<>();
		
		for ( Loot item : items ) {
			if ( item != null ) {
				ArrayList<String> otherEntries = item.getOtherEntries();
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
	
	public ArrayList<Loot> getAllFromCategory( String category ) {
		
		// TODO : Need to filter name and quality.
		
		ArrayList<Loot> lootArrayList = new ArrayList<>();
		int             index         = 0;
		for ( int i = 0; i < columns.length; i++ ) {
			if ( category.equals( columns[ i ] ) ) {
				index = i;
			}
		}
		
		for ( Loot l : items ) {
			if ( l.getOtherEntries().get( index ).equals( category ) ) {
				lootArrayList.add( l );
			}
		}
		return lootArrayList;
	}
	
	public int getIndex() throws Exception {
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
	
	public String[] getColumns() {
		return columns;
	}
}
