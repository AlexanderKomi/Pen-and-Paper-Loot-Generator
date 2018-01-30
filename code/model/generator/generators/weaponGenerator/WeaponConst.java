package model.generator.generators.weaponGenerator;

public final class WeaponConst {
	
	public static final String[] classifications  = {
			"schlecht", "mittel", "gut", "legendär"
	};
	
	public static final String[] weaponOwners = {
			"Arvel", "John", "Maria"
	};
	
	public static final String[] weaponTypes      = { "Nahkampf", "Fernkampf" };
	public static final String[] weaponTypesMelee = { "Waffenlos", "Scharf", "Stumpf", "Spitz", "Exotisch" };
	public static final String[] weaponTypesRange = { "Wurf", "Pistole", "Gewehr", "Bogen", "Exotisch" };
	
	public static final String[][] exoRange = {
			{ "Nagelschussgerät" }, { "Peitsche" }, {}, {}
	};
	
	
	/**
	 * Tests all array lengths and prints if it works or throws an exception.
	 *
	 * @return Returns true, when all arrays are correct.
	 */
	public static boolean testSetup() throws Exception {
		if ( weaponTypesRange.length != exoRange.length ) {
			throw new Exception( "Weapon type length != exo range length" );
		}
		
		throw new Exception( " Pls implement me and fill the arrays ..." );
	}
}
