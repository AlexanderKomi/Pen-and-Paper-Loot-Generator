package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;

public class MainGuiController {
	
	@FXML
	public  MenuBar                 menuBar;
	@FXML
	public  SplitPane               middleContent;
	@FXML
	public  ToolBar                 toolBar;
	
	// ------ FXML - Controller
	
	@FXML
	private MiddleContentController middleContentController;
	@FXML
	private ToolBarController       toolBarController;
	
	
	
	@FXML
	public void initialize() {
		initializeToolBar();
		middleContentController.getOutputText().textProperty().bind( toolBarController.resultOutputProperty() );
	}
	
	private void initializeToolBar() {
		toolBarController.setSelectedTab( middleContentController.getActiveTab() );
		
		middleContentController.getTabPane().getSelectionModel().selectedItemProperty().addListener(
				( observableValue, oldTab, newTab ) -> toolBarController.setSelectedTab( middleContentController.getActiveTab() )
		);
	}
	
	// ----------------------------------------- GETTER AND SETTER -----------------------------------------
	
	public void setMiddleContentController( MiddleContentController middleContentController ) {
		this.middleContentController = middleContentController;
	}
	
	public void setToolBarController( ToolBarController toolBarController ) {
		this.toolBarController = toolBarController;
	}
}
