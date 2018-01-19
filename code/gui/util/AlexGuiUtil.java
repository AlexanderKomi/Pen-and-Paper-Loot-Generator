package gui.util;

import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.LootClass;

import java.util.ArrayList;

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
	
	public static ArrayList<String> fillStringComboBox( ComboBox<String> comboBox, LootClass lootClass, String column ) {
		ArrayList<String> list = lootClass.filterDuplicatedEntries( column );
		comboBox.setItems( FXCollections.observableArrayList(
				list
		) );
		return list;
	}
	
	public static ArrayList<String> fillStringComboBox( ComboBox<String> comboBox, LootClass lootClass, ArrayList<String> columns ) {
		ArrayList<String> list = lootClass.filterDuplicatedEntries( columns );
		comboBox.setItems( FXCollections.observableArrayList(
				list
		) );
		return list;
	}
	
	public static ArrayList<String> fillStringComboBox( ComboBox<String> comboBox, LootClass lootClass, String... columns ) {
		ArrayList<String> list = lootClass.filterDuplicatedEntries( columns );
		comboBox.setItems( FXCollections.observableArrayList(
				list
		) );
		return list;
	}
	
	public static ArrayList<Integer> fillIntComboBox( ComboBox<Integer> comboBox, LootClass lootClass, String column ) {
		ArrayList<String>  list    = lootClass.filterDuplicatedEntries( column );
		ArrayList<Integer> intList = new ArrayList<>();
		list.forEach( s -> {
			try {
				intList.add( Integer.parseInt( s ) );
			}
			catch ( Exception e ) {
				e.printStackTrace();
			}
		} );
		comboBox.setItems( FXCollections.observableArrayList(
				intList
		) );
		return intList;
	}
	
	public static void bindDependency( LootClass lootClass, ComboBox<String> master, ComboBox<String> slave, String masterColumn, String slaveColumn ) {
		master.getSelectionModel().selectedItemProperty().addListener(
				( observable, oldValue, newValue ) -> {
					slave.setItems( FXCollections.observableArrayList(
							lootClass.filterDuplicatesWithDependency( slaveColumn, masterColumn, master.getSelectionModel().getSelectedItem() )
					) );
					slave.getSelectionModel().selectFirst();
				} );
	}
	
	public static void minMaxDependency( ComboBox<Integer> min, ComboBox<Integer> max ) {
		min.getSelectionModel().selectedItemProperty().addListener(
				( observable, oldValue, newValue ) -> {
					if ( !max.getSelectionModel().isEmpty() ) {
						int maxValue = max.getSelectionModel().selectedItemProperty().get();
						if ( newValue > maxValue ) {
							min.getSelectionModel().select( max.getSelectionModel().getSelectedIndex() );
						}
					}
				}
		);
		
		max.getSelectionModel().selectedItemProperty().addListener(
				( observable, oldValue, newValue ) -> {
					if ( !min.getSelectionModel().isEmpty() ) {
						int minValue = min.getSelectionModel().selectedItemProperty().get();
						if ( newValue < minValue ) {
							max.getSelectionModel().select( min.getSelectionModel().getSelectedIndex() );
						}
					}
				}
		);
	}
}
