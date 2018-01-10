package io;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public final class GuiIOUtils {
	
	public static File loadDialog() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter( "Character-Folder", "*.evo" ) );
		return fileChooser.showOpenDialog( new Stage() );
	}
	
	public static File saveDialog() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter( "Character-Folder", "*.evo" ) );
		return fileChooser.showSaveDialog( new Stage() );
	}
	
}
