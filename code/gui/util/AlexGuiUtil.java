package gui.util;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public final class AlexGuiUtil {
	
	
	public static void bindBox( CheckBox check, ComboBox combo ) {
		check.selectedProperty().addListener( ( observable, oldValue, newValue ) -> combo.setDisable( !newValue ) );
	}
	
	public static void bindField( CheckBox check, TextField textField ) {
		check.selectedProperty().addListener( ( observable, oldValue, newValue ) -> textField.setDisable( !newValue ) );
	}
	
	public static void setFieldOnlyNumber( TextField textField ) {
		textField.textProperty().addListener( ( observable, oldValue, newValue ) -> {
			if ( !newValue.matches( "\\d*" ) ) {
				textField.setText( newValue.replaceAll( "[^\\d]", "" ) );
			}
		} );
	}
}
