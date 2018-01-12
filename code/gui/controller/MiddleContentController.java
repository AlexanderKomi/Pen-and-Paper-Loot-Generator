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
		
		tabPane.getSelectionModel().selectedItemProperty().addListener( ( ov, oldTab, newTab ) -> {
			System.out.println( "Active tab changed from \t|" + oldTab.getText() + "|\t\t to \t\t|" + newTab.getText() + "|\t." );
		} );
	}
	
	public void setOutputResult( String result ) {
		this.outputText.setText( result );
	}
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public GeneratorTab getActiveTab() {
		return (GeneratorTab) tabPane.getSelectionModel().getSelectedItem();
	}
	
	public int getActiveIndex() {
		return tabPane.getSelectionModel().getSelectedIndex();
	}
}
