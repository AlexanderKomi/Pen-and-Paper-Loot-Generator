package model.generator.generators.weaponGenerator;

import model.generator.Generator;

public final class WeaponNameGenerator {
	
	public static String generateName( Weapon weapon ) {
		String result = "";
		result += firstPart() + " ";
		result += secondPart( weapon ) + " ";
		result += thridPart( weapon );
		return result;
	}
	
	private static String firstPart() {
		String firstPart;
		int    i = Generator.getRandomIntInclusive( 0, WeaponConst.weaponOwners.length );
		firstPart = WeaponConst.weaponOwners[ i ] + "s";
		return firstPart;
	}
	
	private static String secondPart( Weapon weapon ) {
		String secondPart   = "";
		String quality      = weapon.getQuality();
		int    qualityIndex = 0;
		if ( !quality.isEmpty() ) {
			for ( int i = 0; i < WeaponConst.classifications.length; i++ ) {
				if ( quality.equals( WeaponConst.classifications[ i ] ) ) {
					qualityIndex = i;
				}
			}
		}
		else {
			return "";
		}
		
		
		if ( qualityIndex == 0 || qualityIndex == 1 || qualityIndex == 3 ) {
			secondPart = quality + "e";
		}
		else if ( qualityIndex == 2 ) {
			secondPart = quality + "ere";
		}
		
		return secondPart;
	}
	
	private static String thridPart( Weapon weapon ) {
		String thridPart = weapon.getName();
		return thridPart;
	}
}
