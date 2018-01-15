package gui.controller;

import gui.controller.tabs.AlexGeneratorTabController;
import gui.controller.tabs.NissGeneratorTabController;
import gui.elements.GeneratorTab;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import model.generator.generators.AlexGenerator;
import model.generator.generators.NissGenerator;

import java.util.ArrayList;

public class MiddleContentController {
	
	@FXML
	private Label   outputText;
	@FXML
	private TabPane tabPane;
	
	private ArrayList<GeneratorTab> activeTabs = new ArrayList<>();
	
	@FXML
	private VBox                       nissGeneratorTab;
	@FXML
	private NissGeneratorTabController nissGeneratorTabController;
	
	@FXML
	private AlexGeneratorTabController alexGeneratorTabController;
	
	@FXML
	public void initialize() {
		outputText.setText( "Loot Output" );
		createTabs();
	}
	
	private void createTabs() {
		createNissTab();
		createAlexTab();
	}
	
	private void createAlexTab() {
		Tab tab = new Tab( "Alex Generator" );
		tab.setContent( this.alexGeneratorTabController.getRootPane() );
		activeTabs.add( new GeneratorTab( new AlexGenerator(), tab ) );
	}
	
	private void createNissTab() {
		Tab tab = new Tab();
		tab.setContent( this.nissGeneratorTabController.getRootBox() );
		activeTabs.add( new GeneratorTab( new NissGenerator(), tab ) );
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
	
	public int getTabIndex( Tab t ) {
		return tabPane.getTabs().indexOf( t );
	}
	
	public int getActiveIndex() {
		return tabPane.getSelectionModel().getSelectedIndex();
	}
	
	public void setNissGeneratorTabController( NissGeneratorTabController nissGeneratorTabController ) {
		this.nissGeneratorTabController = nissGeneratorTabController;
	}
	
	public VBox getNissGeneratorTab() {
		return nissGeneratorTab;
	}
	
	public void setNissGeneratorTab( VBox nissGeneratorTab ) {
		this.nissGeneratorTab = nissGeneratorTab;
	}
}
