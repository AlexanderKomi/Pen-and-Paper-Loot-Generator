package gui.controller;

import gui.elements.GeneratorTab;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class ToolBarController {
	
	private StringProperty resultOutput = new SimpleStringProperty( "" );
	private GeneratorTab selectedTab;
	
	@FXML
	private void generateLootClicked() {
		Platform.runLater( () -> resultOutput.set( this.selectedTab.generateLoot() ) );
	}
	
	@FXML
	private void saveGeneratedLootClicked() {
	
	}
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	public GeneratorTab getSelectedTab() {
		return this.selectedTab;
	}
	
	public void setSelectedTab( Tab selectedTab ) {
		this.selectedTab = (GeneratorTab) selectedTab;
	}
	
	public String getResultOutput() {
		return resultOutput.get();
	}
	
	public void setResultOutput( String resultOutput ) {
		this.resultOutput.set( resultOutput );
	}
	
	public StringProperty resultOutputProperty() {
		return resultOutput;
	}
}
