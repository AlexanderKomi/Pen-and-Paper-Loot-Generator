package controller;

import io.IOController;
import javafx.scene.control.Tab;
import model.generator.LootGeneratorController;

public class MainController {
	
	private static Tab selectedTab;
	
	public static void initialize() {
		IOController.loadStartingData();
		LootGeneratorController.addGenerators();
	}
	
	
	public static Tab getSelectedTab() {
		return selectedTab;
	}
	
	public static void setSelectedTab( Tab selectedTab ) {
		MainController.selectedTab = selectedTab;
	}
}
