package io;

import constants.GeneralConstants;
import model.Loot;
import model.LootClass;
import model.LootController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	
	public static boolean writeLoot( LootClass lootClass, Loot loot ) {
		lootClass.getItems().add( loot );
		LootController.updateLootClass( lootClass );
		return writeToFile( lootClass );
	}
	
	private static boolean writeToFile( LootClass lootClass ) {
		String fileLocation = GeneralConstants.getLocation() + "/" + lootClass.getName();
		System.out.println( " fileLocation : " + fileLocation );
		try {
			BufferedWriter br = new BufferedWriter( new FileWriter( fileLocation ) );
			return true;
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
