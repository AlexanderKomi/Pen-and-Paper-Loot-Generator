import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LootGenerator extends Application {
	
	public static void main( String[] args ) {
		launch( args );
	}
	
	@Override
	public void start( Stage primaryStage ) throws Exception {
		Scene scene = new Scene( FXMLLoader.load( getClass().getResource( "gui/fxml/MainGui.fxml" ) ) );
		primaryStage.setTitle( "Pen and Paper : Loot Generator" );
		primaryStage.setScene( scene );
		primaryStage.setOnCloseRequest( event -> Platform.exit() );
		primaryStage.show();
	}
	
	
}
