package gui.controller;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.ToolBar;

public class MainGuiController {
	
	@FXML
	public  MenuBar                 menuBar;
	@FXML
	public  SplitPane               middleContent;
	@FXML
	public  ToolBar                 toolBar;
	@FXML
	private MiddleContentController middleContentController;
	
	@FXML
	public void initialize() {
		Tab t = middleContentController.getActiveTab();
		MainController.setSelectedTab( t );
	}
	
}
