package gui.controller;

import gui.elements.GeneratorTab;
import javafx.fxml.FXML;

public class ToolBarController {
	
	private GeneratorTab selectedTab;
	
	@FXML
	private void generateLootClicked() {
		System.out.println( "-> Generate clicked : Active Tab : " + selectedTab.getText() );
	}
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	public GeneratorTab getSelectedTab() {
		return selectedTab;
	}
	
	public void setSelectedTab( GeneratorTab selectedTab ) {
		this.selectedTab = selectedTab;
	}
}
