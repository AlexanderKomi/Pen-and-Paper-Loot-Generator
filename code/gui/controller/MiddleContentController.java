package gui.controller;

import gui.elements.GeneratorTab;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import model.generator.Generator;
import model.generator.LootGeneratorController;
import model.generator.generators.NissGenerator;

public class MiddleContentController {
	
	@FXML
	private Label   outputText;
	@FXML
	private TabPane tabPane;
	
	@FXML
	public void initialize() {
		outputText.setText( "Loot Output" );
		createTabs();
	}
	
	private void createTabs() {
		for ( Generator g : LootGeneratorController.getGenerators() ) {
			GeneratorTab tab = new GeneratorTab( g );
			tabPane.getTabs().add( tab );
		}
		
		NissGeneratorTabController niss = new NissGeneratorTabController();
		
		Tab t = new Tab();
		t.setContent( niss.getRootBox() );
		
		tabPane.getTabs().add( new GeneratorTab( new NissGenerator(), t ) );
	}
	
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public void setOutputText( String result ) {
		this.outputText.setText( result );
	}
	
	public Label getOutputText() {
		return outputText;
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
