package gui.controller;

import gui.elements.GeneratorTab;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import model.generator.Generator;
import model.generator.LootGeneratorController;

public class MiddleContentController {
	
	@FXML
	private Label   outputText;
	@FXML
	private TabPane tabPane;
	
	@FXML
	public void initialize() {
		outputText.setText( "Testing Output" );
		createTabs();
	}
	
	private void createTabs() {
		for ( Generator g : LootGeneratorController.getGenerators() ) {
			GeneratorTab tab = new GeneratorTab( g );
			tabPane.getTabs().add( tab );
		}
	}
	
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public void setOutputText( String result ) {
		this.outputText.setText( result );
	}
	
	public TabPane getTabPane() {
		return tabPane;
	}
	
	public GeneratorTab getActiveTab() {
		return (GeneratorTab) tabPane.getSelectionModel().getSelectedItem();
	}
	
	public int getActiveIndex() {
		return tabPane.getSelectionModel().getSelectedIndex();
	}
}
