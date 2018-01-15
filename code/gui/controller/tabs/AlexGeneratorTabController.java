package gui.controller.tabs;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import model.LootController;

import java.util.ArrayList;

public class AlexGeneratorTabController {
	
	@FXML
	private ScrollPane rootPane;
	
	//---------------------------------------- WEAPONS
	@FXML
	private CheckBox          categoryWeaponCheckBox;
	@FXML
	private ComboBox<String>  categoryWeaponComboBox;
	@FXML
	private CheckBox          qualityWeaponCheckBox;
	@FXML
	private ComboBox<Integer> qualityWeaponComboBox;
	@FXML
	private CheckBox          amountWeaponCheckBox;
	@FXML
	private ComboBox<Integer> amountWeaponComboBox;
	
	//---------------------------------------- FIRST AID
	@FXML
	private CheckBox          levelFirstAidCheckBox;
	@FXML
	private ComboBox<Integer> levelFirstAidComboBox;
	@FXML
	private CheckBox          amountFirstAidCheckBox;
	@FXML
	private ComboBox<Integer> amountFirstAidComboBox;
	
	//---------------------------------------- POISON
	@FXML
	private CheckBox          levelPoisonCheckBox;
	@FXML
	private ComboBox<Integer> levelPoisonComboBox;
	@FXML
	private CheckBox          amountPoisonCheckBox;
	@FXML
	private ComboBox<Integer> amountPoisonComboBox;
	
	@FXML
	private void initialize() {
		initializeComboBoxes();
		setDefaultValues();
		disableComboBoxes();
		bindValues();
	}
	
	// ----------------------------- initialize boxes -----------------------------
	
	private void initializeComboBoxes() {
		initializeWeaponBoxes();
		initializeFirstAidBoxes();
		initializePoisonBoxes();
	}
	
	private void initializeWeaponBoxes() {
		try {
			categoryWeaponComboBox.setItems( FXCollections.observableArrayList(
					LootController.getLootClassByName( "Waffen" ).filterDuplicates( "Kategorie" )
			) );
			
			ArrayList<String>  list    = LootController.getLootClassByName( "Waffen" ).filterDuplicates( "Qualität" );
			ArrayList<Integer> intList = new ArrayList<>();
			list.forEach( s -> {
				try {
					intList.add( Integer.parseInt( s ) );
				}
				catch ( Exception e ) {
					e.printStackTrace();
				}
			} );
			
			qualityWeaponComboBox.setItems( FXCollections.observableArrayList(
					intList
			) );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private void initializeFirstAidBoxes() {
		try {
			ArrayList<String>  list    = LootController.getLootClassByName( "Erste Hilfe" ).filterDuplicates( "Stufe" );
			ArrayList<Integer> intList = new ArrayList<>();
			list.forEach( s -> {
				try {
					intList.add( Integer.parseInt( s ) );
				}
				catch ( Exception e ) {
					e.printStackTrace();
				}
			} );
			
			levelFirstAidComboBox.setItems( FXCollections.observableArrayList(
					intList
			) );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private void initializePoisonBoxes() {
		try {
			ArrayList<String>  list    = LootController.getLootClassByName( "Gifte" ).filterDuplicates( "Stufe" );
			ArrayList<Integer> intList = new ArrayList<>();
			list.forEach( s -> {
				try {
					intList.add( Integer.parseInt( s ) );
				}
				catch ( Exception e ) {
					e.printStackTrace();
				}
			} );
			
			levelPoisonComboBox.setItems( FXCollections.observableArrayList(
					intList
			) );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	// ----------------------------- initialization -----------------------------
	
	private void setDefaultValues() {
		//---------------------------------------- WEAPONS
		categoryWeaponComboBox.getSelectionModel().selectFirst();
		qualityWeaponComboBox.getSelectionModel().selectFirst();
		amountWeaponComboBox.getSelectionModel().selectFirst();
		//---------------------------------------- FIRST AID
		levelFirstAidComboBox.getSelectionModel().selectFirst();
		amountFirstAidComboBox.getSelectionModel().selectFirst();
		//---------------------------------------- POISON
		levelPoisonComboBox.getSelectionModel().selectFirst();
		amountPoisonComboBox.getSelectionModel().selectFirst();
	}
	
	private void disableComboBoxes() {
		//---------------------------------------- WEAPONS
		categoryWeaponComboBox.setDisable( true );
		qualityWeaponComboBox.setDisable( true );
		amountWeaponComboBox.setDisable( true );
		//---------------------------------------- FIRST AID
		levelFirstAidComboBox.setDisable( true );
		amountFirstAidComboBox.setDisable( true );
		//---------------------------------------- POISON
		levelPoisonComboBox.setDisable( true );
		amountPoisonComboBox.setDisable( true );
	}
	
	private void bindValues() {
		//---------------------------------------- WEAPONS
		bindBox( categoryWeaponCheckBox, categoryWeaponComboBox );
		bindBox( qualityWeaponCheckBox, qualityWeaponComboBox );
		bindBox( amountWeaponCheckBox, amountWeaponComboBox );
		//---------------------------------------- FIRST AID
		bindBox( levelFirstAidCheckBox, levelFirstAidComboBox );
		bindBox( amountFirstAidCheckBox, amountFirstAidComboBox );
		//---------------------------------------- POISON
		bindBox( levelPoisonCheckBox, levelPoisonComboBox );
		bindBox( amountPoisonCheckBox, amountPoisonComboBox );
	}
	
	private void bindBox( CheckBox check, ComboBox combo ) {
		check.selectedProperty().addListener( ( observable, oldValue, newValue ) -> combo.setDisable( !newValue ) );
	}
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	public ScrollPane getRootPane() {
		return rootPane;
	}
	
	public void setRootPane( ScrollPane rootPane ) {
		this.rootPane = rootPane;
	}
}
