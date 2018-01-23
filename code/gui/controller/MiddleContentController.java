package gui.controller;

import gui.controller.tabs.AlexGeneratorTabController;
import gui.controller.tabs.DennisGeneratorTabController;
import gui.controller.tabs.NissGeneratorTabController;
import gui.elements.GeneratorTab;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MiddleContentController {
	
	private ArrayList<GeneratorTab> activeTabs = new ArrayList<>();
	
	@FXML
	private Label   outputText;
	@FXML
	private TabPane tabPane;
	
	// START ---------------- CUSTOM TABS ---------------- START
	
	@FXML
	private VBox                       nissGeneratorTab;

	@FXML
	private NissGeneratorTabController nissGeneratorTabController;
	
	@FXML
	private AlexGeneratorTabController alexGeneratorTabController;
	
	@FXML
	private DennisGeneratorTabController dennisGeneratorTabController;
	
	// END   ---------------- CUSTOM TABS ----------------   END
	
	@FXML
	public void initialize() {
		outputText.setText( "Loot Output" );
		createTabs();
	}
	
	private void createTabs() {
		createNissTab();
		createAlexTab();
		createDennisTab();
	}
	
	private void createDennisTab() {
		Tab tab = new Tab( "Dennis Generator" );	//TODO: Name kann nur über MiddleContent.fxml verändert werden!
		tab.setContent( this.dennisGeneratorTabController.getRootPane() );
		activeTabs.add( new GeneratorTab( this.dennisGeneratorTabController.getGenerator(), tab ) );
	}
	
	private void createAlexTab() {
		Tab tab = new Tab( "Alex Generator" );		//TODO: Name kann nur über MiddleContent.fxml verändert werden!
		tab.setContent( this.alexGeneratorTabController.getRootPane() );
		activeTabs.add( new GeneratorTab( this.alexGeneratorTabController.getAlexGenerator(), tab ) );
	}
	
	private void createNissTab() {
		Tab tab = new Tab("Waffen Generator");		//TODO: Name kann nur über MiddleContent.fxml verändert werden!
		tab.setContent( this.nissGeneratorTabController.getRootBox() );
		activeTabs.add( new GeneratorTab( this.nissGeneratorTabController.getNissGenerator(), tab ) );
	}
	
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public Label getOutputText() {
		return outputText;
	}
	
	public void setOutputText( String result ) {
		this.outputText.setText( result );
	}
	
	public TabPane getTabPane() {
		return tabPane;
	}
	
	public GeneratorTab getActiveTab() {
		return activeTabs.get( tabPane.getSelectionModel().getSelectedIndex() );
	}
	
}
