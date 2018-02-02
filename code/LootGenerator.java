import arguments.Arguments;
import constants.GeneralConstants;
import io.Helper;
import io.IOConstants;
import io.IOController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import testing.LanguageSupportTest;

import java.util.Map;

public class LootGenerator extends Application {
	
	public static void main( String[] args ) {
		if ( args.length == 0 ) {
			launch( args ); //calls "void start(Stage primaryStage)"
		}
		else {
			parseArguments( args );
		}
	}
	
	private static void parseArguments( String[] args ) {
		System.out.println( "--- ATTENTION : Started with program arguments ---" );
		Map<String, String> legalArguments = Arguments.checkIfArgumentsExists( args );
		
		Arguments.printLegalArguments();
		Arguments.printIllegalArguments();
		
		for ( String s : legalArguments.keySet() ) {
			if ( s.equals( "-h" ) || s.equals( "--help" ) ) {
				Arguments.printAllLegalArguments();
			}
		}
		
		launch( args );
	}
	
	@Override
	public void start( Stage primaryStage ) throws Exception {
		beforeGuiInit();
		Scene scene = new Scene( FXMLLoader.load( getClass().getResource( "gui/fxml/MainGui.fxml" ) ) );
		primaryStage.setTitle( "Pen and Paper : Loot Generator" );
		primaryStage.setMinWidth( GeneralConstants.guiMinWidth );
		primaryStage.setMinHeight( GeneralConstants.guiMinHeight );
		primaryStage.setScene( scene );
		primaryStage.setOnCloseRequest( event -> Platform.exit() );
		
		setIcon( primaryStage );
		
		primaryStage.show();
		
		afterGuiInit();
	}
	
	private void setIcon( Stage primaryStage ) {
		try {
			String iconPath = IOConstants.graphicsFolder + "PnPLogo.svg";
			if ( GeneralConstants.isExecutedFromJar() ) {
				primaryStage.getIcons().add( new Image( getClass().getResourceAsStream( iconPath ) ) );
			}
			else {
				primaryStage.getIcons().add( new Image( getClass().getResource( iconPath ).toExternalForm() ) );
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void beforeGuiInit() {
		
		LanguageSupportTest.test();
		IOController.loadStartingData();
		Helper.test_BeforeGUIStarts();
	}
	
	private void kotlinTest() {
	}
	
	private void afterGuiInit() {
		Helper.test_AfterGUIStarts();
	}
	
}
