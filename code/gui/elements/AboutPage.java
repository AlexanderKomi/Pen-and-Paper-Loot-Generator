package gui.elements;

import constants.GeneralConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * An simple About-Page, which shows all information about the authors of the program and version.
 *
 * @author Alex
 */
public class AboutPage extends Stage {
	
	private static BorderPane bp = new BorderPane();
	private static Label systemLabel;
	private static Label versionLabel;
	private static Label authorsLabel;
	
	public AboutPage() {
		createContent();
		addContentToGui();
	}
	
	
	private void createContent() {
		versionLabel = new Label( "Current Version : \t" + GeneralConstants.current_version );
		systemLabel = new Label( "Compatible System Version : \t" + GeneralConstants.compatible_System_Version );
		StringBuilder authors = new StringBuilder();
		for ( String s : GeneralConstants.authors ) {
			authors.append( "\t" ).append( s ).append( "\n" );
		}
		authorsLabel = new Label( "Authors : \n" + authors );
	}
	
	
	private void addContentToGui() {
		VBox vbox = new VBox();
		this.addDefaultValues( vbox );
		vbox.getChildren().addAll( versionLabel, systemLabel, authorsLabel );
		
		bp.setCenter( vbox );
		Scene scene = new Scene( bp );
		this.setScene( scene );
		this.setTitle( "About" );
		this.setMinHeight( 200 );
		this.setMinWidth( 200 );
	}
	
	private void addDefaultValues( VBox vBox ) {
		vBox.setPadding( new Insets( 10, 10, 10, 10 ) );
		vBox.setAlignment( Pos.CENTER );
		vBox.setSpacing( 10 );
	}
	
}
