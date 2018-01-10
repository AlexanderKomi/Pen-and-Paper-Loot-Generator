package constants;

public class IOConstants {
	
	public static final String resourceFolder = "loot/";
	
	public static final String fileType           = ".csv";
	public static final String fileEntrySeparator = ";";
	public static final String fileRowSeparator   = "\n";
	
	public static final String[]  lootClasses                = {
			"Waffen"
	};
	public static final int[]     headerLengths              = {
			160
	};
	public static final boolean[] hasSpecialColumnDefinition = {
			true
	};
	
	public static final String[][] columnDefinitions = {
			{ "Name", "Kategorie", "Typ", "Qualität", "Schaden", "Trefferchance", "Parade", "Magazin", "Beschreibung", "Anmerkungen", "Grundschaden", "Wurfschaden" }
	};
	
	public static final int[] nameIndexes = {
			0
	};
	
	public static final int[] qualityIndexes = {
			3
	};
	
}
