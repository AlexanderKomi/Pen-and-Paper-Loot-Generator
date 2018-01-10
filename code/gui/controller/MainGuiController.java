package gui.controller;

import io.IOController;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;

public class MainGuiController {
	
	@FXML
	public MenuBar   menuBar;
	@FXML
	public SplitPane middleContent;
	@FXML
	public ToolBar   toolBar;
	
	@FXML
	public void initialize() {
		IOController ioController = new IOController();
		ioController.loadData();
	}
	
}
