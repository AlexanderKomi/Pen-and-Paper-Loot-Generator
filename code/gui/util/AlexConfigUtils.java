package gui.util;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import model.LootClass;

public final class AlexConfigUtils {
	
	public static void setCategory( LootClass lootClass, CheckBox checkBox, ComboBox<String> comboBox ) {
		lootClass.getConfiguration().setSearchForCategory( checkBox.isSelected() );
		lootClass.getConfiguration().setCategory( comboBox.getSelectionModel().getSelectedItem() );
	}
	
	public static void setType( LootClass lootClass, CheckBox checkBox, ComboBox<String> comboBox ) {
		lootClass.getConfiguration().setSearchForType( checkBox.isSelected() );
		lootClass.getConfiguration().setType( comboBox.getSelectionModel().getSelectedItem() );
	}
	
	public static void setMinQuality( LootClass lootClass, CheckBox checkBox, ComboBox<Integer> comboBox ) {
		lootClass.getConfiguration().setSearchMinQuality( checkBox.isSelected() );
		lootClass.getConfiguration().setMinQuality( comboBox.getSelectionModel().getSelectedItem() );
	}
	
	public static void setMaxQuality( LootClass lootClass, CheckBox checkBox, ComboBox<Integer> comboBox ) {
		lootClass.getConfiguration().setSearchMaxQuality( checkBox.isSelected() );
		lootClass.getConfiguration().setMaxQuality( comboBox.getSelectionModel().getSelectedItem() );
		
	}
	
	public static void setName( LootClass lootClass, CheckBox checkBox, ComboBox<String> comboBox ) {
		lootClass.getConfiguration().setSearchForName( checkBox.isSelected() );
		lootClass.getConfiguration().setName( comboBox.getSelectionModel().getSelectedItem() );
	}
}
