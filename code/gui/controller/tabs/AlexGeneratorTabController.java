package gui.controller.tabs;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class AlexGeneratorTabController {
	
	@FXML
	private BorderPane rootPane;
	
	
	public BorderPane getRootPane() {
		return rootPane;
	}
	
	public void setRootPane( BorderPane rootPane ) {
		this.rootPane = rootPane;
	}
}
