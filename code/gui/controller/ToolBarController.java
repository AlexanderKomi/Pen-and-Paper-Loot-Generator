package gui.controller;

import gui.elements.GeneratorTab;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class ToolBarController {
	
	private StringProperty resultOutput = new SimpleStringProperty( "" );
	private GeneratorTab selectedTab;
	
	@FXML
	private void generateLootClicked() {
		System.out.println( "-> Generate clicked : Active Tab : " + selectedTab.getText() );
		resultOutput.set( this.selectedTab.generateLoot() );
	}
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	public GeneratorTab getSelectedTab() {
		return this.selectedTab;
	}
	
	public void setSelectedTab( GeneratorTab selectedTab ) {
		this.selectedTab = selectedTab;
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
