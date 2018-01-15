package gui.controller;

import gui.elements.GeneratorTab;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import model.generator.Generator;
import model.generator.LootGeneratorController;
import model.generator.generators.NissGenerator;

import java.util.ArrayList;

public class MiddleContentController {
	
	@FXML
	private Label   outputText;
	@FXML
	private TabPane tabPane;
	ArrayList<GeneratorTab> activeTabs = new ArrayList<>();
	@FXML
	private NissGeneratorTabController nissGeneratorTabController;
	
	@FXML
	public void initialize() {
		outputText.setText( "Loot Output" );
		createTabs();
	}
	
	private void createTabs() {
		Tab t = new Tab();
		t.setContent( nissGeneratorTabController.getRootBox() );
		activeTabs.add( new GeneratorTab( new NissGenerator(), t ) );
		
		for ( Generator g : LootGeneratorController.getGenerators() ) {
			GeneratorTab tab = new GeneratorTab( g );
			activeTabs.add( tab );
			tabPane.getTabs().add( tab );
		}
		activeTabs.forEach( s -> System.out.println( s.getText() ) );
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
		int i = tabPane.getSelectionModel().getSelectedIndex();
		return activeTabs.get( i );
	}
	
	public int getTabIndex( Tab t ) {
		return tabPane.getTabs().indexOf( t );
	}
	
	public int getActiveIndex() {
		return tabPane.getSelectionModel().getSelectedIndex();
	}
}
