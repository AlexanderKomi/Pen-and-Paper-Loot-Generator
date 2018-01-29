package gui.controller;

import gui.elements.AboutPage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Modality;

public class MenuBarController {
	
	private static AboutPage about = new AboutPage();
	
	@FXML
	private void initialize() {
		about.initModality( Modality.APPLICATION_MODAL );
	}
	
	@FXML
	private void closeClicked() {
		System.out.println( "Close clicked" );
		Platform.exit();
	}
	
	@FXML
	private void aboutClicked() {
		System.out.println( "About clicked" );
		about.showAndWait();
	}
	
}
