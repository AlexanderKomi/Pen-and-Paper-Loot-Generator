package model;

import constants.IOConstants;
import io.dataLoading.Header;

import java.util.ArrayList;

public class LootClass {
	
	private String name;
	private ArrayList<String> columns = new ArrayList<>();
	private ArrayList<Loot> items;
	private int             indexOfLootClass;
	
	public LootClass( Header header, String content ) {
		this.name = header.getName();
		this.columns.addAll( header.getColumns() );
		this.indexOfLootClass = getIndex();
		this.items = createItems( content );
	}
	
	private ArrayList<Loot> createItems( String content ) {
		ArrayList<Loot> loot = new ArrayList<>();
		String[]        rows = content.split( IOConstants.fileRowSeparator );
		
		for ( String row : deleteEmptyStart( rows ) ) {
			if ( row != null ) {
				loot.add( createLoot( row ) );
			}
		}
		return loot;
	}
	
	private String[] deleteEmptyStart( String[] rows ) {
		String[] result = rows;
		for ( int i = 0; i < rows.length; i++ ) {
			for ( String s : rows[ i ].split( IOConstants.fileEntrySeparator ) ) {
				if ( !s.isEmpty() ) {
					
					result = new String[ rows.length - i ];
					
					System.arraycopy( rows, i + 1, result, 0, rows.length - i - 1 - i );
					
					return result;
				}
			}
		}
		return result;
	}
	
	private Loot createLoot( String row ) {
		Loot loot = new Loot();
		
		String[] elements = row.split( IOConstants.fileEntrySeparator );
		
		for ( int i = 0; i < elements.length; i++ ) {
			
			if ( i == IOConstants.nameIndexes[ indexOfLootClass ] ) {
				loot.setName( elements[ i ] );
			}
			else if ( i == IOConstants.qualityIndexes[ indexOfLootClass ] ) {
				loot.setQualityAsNumber( Integer.parseInt( elements[ i ] ) );
			}
			else {
				if ( elements[ i ] == null ) {
					loot.getOtherEntries().add( " x " );
				}
				else {
					loot.getOtherEntries().add( elements[ i ] );
				}
			}
		}
		return loot;
	}
	
	private int getIndex() {
		for ( int i = 0; i < IOConstants.lootClasses.length; i++ ) {
			if ( IOConstants.lootClasses[ i ].equals( this.name ) )
				return i;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		String        separator = ", ";
		StringBuilder sb        = new StringBuilder( "Name of lootclass : " + this.name );
		
		
		sb.append( "\n\n\t Columns : \n" );
		for ( String s : this.columns ) {
			sb.append( s ).append( separator );
		}
		sb.deleteCharAt( sb.lastIndexOf( separator ) );
		
		
		sb.append( "\n\n\t Loot : \n" );
		for ( Loot l : this.getItems() ) {
			sb.append( l ).append( separator ).append( "\n" );
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
	
	public ArrayList<Loot> getItems() {
		return items;
	}
	
	public void setItems( ArrayList<Loot> items ) {
		this.items = items;
	}
}
