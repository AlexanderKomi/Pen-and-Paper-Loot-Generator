package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;

public class MiddleContentController {
	
	@FXML
	private Label   outputText;
	@FXML
	private TabPane tabPane;
	
	@FXML
	public void initialize() {
		outputText.setText( "Testing Output" );
	}
	
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	public Label getOutputText() {
		return outputText;
	}
	
	public TabPane getTabPane() {
		return tabPane;
	}
	
	public void setTabPane( TabPane tabPane ) {
		this.tabPane = tabPane;
	}
}
