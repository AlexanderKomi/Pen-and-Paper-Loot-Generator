package gui.controller;

import gui.elements.GeneratorTab;
import javafx.fxml.FXML;

public class ToolBarController {
	
	private MiddleContentController mcc;
	
	@FXML
	public void initialize() {
		//System.out.println("ToolBarController initialized");
	}
	
	@FXML
	private void generateLootClicked() {
		GeneratorTab t;
		//t.generateLoot();
		System.out.println( "-> Generate clicked" );
	}
	
}
