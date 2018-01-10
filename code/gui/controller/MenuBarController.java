package gui.controller;

import gui.elements.AboutPage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Modality;

public class MenuBarController {
	
	@FXML
	private void closeClicked() {
		System.out.println( "Close clicked" );
		Platform.exit();
	}
	
	@FXML
	private void aboutClicked() {
		System.out.println( "About clicked" );
		AboutPage about = new AboutPage();
		about.initModality( Modality.APPLICATION_MODAL );
		about.showAndWait();
	}
	
}
