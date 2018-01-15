package controller;

import io.IOController;

public class MainController {
	
	public static void initialize() {
		IOController.loadStartingData();
		//LootController.getLootClasses().forEach( System.out::println );
	}
	
}
