package constants;

public class IOConstants {
	
	public static final String resourceFolder = "loot/";
	
	public static final String fileType           = ".csv";
	public static final String fileEntrySeparator = ";";
	public static final String fileRowSeparator   = "\n";
	
	public static final String[]  lootClasses                = {
			"Waffen", "Erste Hilfe"
	};
	public static final int[]     headerLengths              = {
			160, 0
	};
	public static final boolean[] hasSpecialColumnDefinition = {
			true, false
	};
	
	public static final String[][] columnDefinitions = {
			{ "Name", "Kategorie", "Typ", "Qualität", "Schaden", "Trefferchance", "Parade", "Magazin", "Beschreibung", "Anmerkungen", "Grundschaden", "Wurfschaden" },
			{ "Name", "Qualität", "Menge" }
	};
	
	public static final int[] nameIndexes = {
			0
	};
	
	public static final int[] qualityIndexes = {
			3
	};
	
}
