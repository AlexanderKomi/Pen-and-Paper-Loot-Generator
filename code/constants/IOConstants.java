package constants;

public final class IOConstants {
	
	public static final String resourceFolder     = "loot/";
	public static final String fileType           = ".csv";
	public static final String fileEntrySeparator = ";";
	public static final String fileRowSeparator   = "\n";
	
	public static final String[] lootClasses   = {
			"Waffen", "Erste Hilfe", "Gifte", "Kram"
	};
	public static final int[]    headerLengths = {
			160, 28, 20, 46
	};
	
	public static final String[][] columnDefinitions = {
			{ "Name", "Kategorie", "Typ", "Qualität", "Grundschaden", "Wurfschaden", "Trefferchance", "Parade", "Magazin", "Beschreibung", "Anmerkungen" },
			{ "Name", "Stufe", "Wirkung", "Anmerkung" },
			{ "Name", "Stufe", "Anmerkung" },
			{ "Name", "Qualität", "Anmerkung", "Beschreibung" }
	};
	
	public static final int[] qualityIndexes = {
			3, 1, 1, 1
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
