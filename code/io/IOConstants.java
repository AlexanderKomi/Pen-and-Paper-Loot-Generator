package io;

public final class IOConstants {
	
	public static final String replaceCharacter   = "";
	public static final String lootFolder         = "loot/";
	public static final String graphicsFolder     = "graphics/";
	public static final String fileType           = ".csv";
	public static final String fileEntrySeparator = ";";
	public static final String fileRowSeparator   = "\n";
	public static final String lineSeparator      = "\r\n";
	
	public static final String[] lootClasses   = {
			"Waffen", "Erste Hilfe", "Gifte", "Kram", "Computerteile"
	};
	public static final int[]    headerLengths = {
			160, 28, 20, 46, 75
	};
	
	public static final String[][] columnDefinitions = {
			{ "Name", "Kategorie", "Typ", "Qualität", "Grundschaden", "Wurfschaden", "Trefferchance", "Parade", "Magazin", "Beschreibung", "Anmerkungen" },
			{ "Name", "Stufe", "Wirkung", "Anmerkung" },
			{ "Name", "Stufe", "Anmerkung" },
			{ "Name", "Qualität", "Anmerkung", "Beschreibung" },
			{ "Name", "Stufe", "Kategorie 1", "Kategorie 2", "Kategorie 3" }
	};
	
	public static final int[] qualityIndexes = {
			3, 1, 1, 1, 1
	};
	
	public static boolean checkArrayLength() {
		
		boolean sameLength = true;
		
		if ( lootClasses.length != headerLengths.length ) {
			sameLength = false;
		}
		else if ( lootClasses.length != qualityIndexes.length ) {
			sameLength = false;
		}
		else if ( lootClasses.length != columnDefinitions.length ) {
			sameLength = false;
		}
		
		return sameLength;
	}
	
}
