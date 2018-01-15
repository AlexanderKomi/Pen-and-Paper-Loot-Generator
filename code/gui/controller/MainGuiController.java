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
				( observableValue, oldTab, newTab ) -> {
					//System.out.println( "Active tab changed from \t|" + oldTab.getText() + "|\t\t to \t\t|" + newTab.getText() + "|\t." );
					toolBarController.setSelectedTab( middleContentController.getActiveTab() );
				}
		);
	}
	
}
