package gui.controller.tabs;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import model.LootClass;
import model.LootController;
import model.generator.generators.AlexGenerator;

import java.util.ArrayList;

public class AlexGeneratorTabController {
	
	private AlexGenerator alexGenerator = new AlexGenerator( this );
	
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
	private TextField         amountWeaponField;
	
	//---------------------------------------- FIRST AID
	@FXML
	private CheckBox          levelFirstAidCheckBox;
	@FXML
	private ComboBox<Integer> levelFirstAidComboBox;
	@FXML
	private CheckBox          amountFirstAidCheckBox;
	@FXML
	private TextField         amountFirstAidField;
	
	//---------------------------------------- POISON
	@FXML
	private CheckBox          levelPoisonCheckBox;
	@FXML
	private ComboBox<Integer> levelPoisonComboBox;
	@FXML
	private CheckBox          amountPoisonCheckBox;
	@FXML
	private TextField         amountPoisonField;
	
	@FXML
	private void initialize() {
		initializeComboBoxes();
		setDefaultValues();
		disableElements();
		bindGuiValues();
		bindCategoryValues();
		initControllerConfig();
	}
	
	private void bindCategoryValues() {
	
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
					LootController.getLootClassByName( "Waffen" ).filterDuplicatedEntries( "Typ" )
			) );
			
			ArrayList<String>  list    = LootController.getLootClassByName( "Waffen" ).filterDuplicatedEntries( "Qualität" );
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
			ArrayList<String>  list    = LootController.getLootClassByName( "Erste Hilfe" ).filterDuplicatedEntries( "Stufe" );
			ArrayList<Integer> intList = new ArrayList<>();
			list.forEach( s -> {
				try {
					if ( s != null ) {
						intList.add( Integer.parseInt( s ) );
					}
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
			ArrayList<String>  list    = LootController.getLootClassByName( "Gifte" ).filterDuplicatedEntries( "Stufe" );
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
		setFieldOnlyNumber( amountWeaponField );
		amountWeaponField.setText( "0" );
		//---------------------------------------- FIRST AID
		levelFirstAidComboBox.getSelectionModel().selectFirst();
		setFieldOnlyNumber( amountFirstAidField );
		amountFirstAidField.setText( "0" );
		//---------------------------------------- POISON
		levelPoisonComboBox.getSelectionModel().selectFirst();
		setFieldOnlyNumber( amountPoisonField );
		amountPoisonField.setText( "0" );
	}
	
	private void disableElements() {
		//---------------------------------------- WEAPONS
		categoryWeaponComboBox.setDisable( true );
		qualityWeaponComboBox.setDisable( true );
		amountWeaponField.setDisable( true );
		//---------------------------------------- FIRST AID
		levelFirstAidComboBox.setDisable( true );
		amountFirstAidField.setDisable( true );
		//---------------------------------------- POISON
		levelPoisonComboBox.setDisable( true );
		amountPoisonField.setDisable( true );
	}
	
	private void bindGuiValues() {
		//---------------------------------------- WEAPONS
		bindBox( categoryWeaponCheckBox, categoryWeaponComboBox );
		bindBox( qualityWeaponCheckBox, qualityWeaponComboBox );
		bindField( amountWeaponCheckBox, amountWeaponField );
		//---------------------------------------- FIRST AID
		bindBox( levelFirstAidCheckBox, levelFirstAidComboBox );
		bindField( amountFirstAidCheckBox, amountFirstAidField );
		//---------------------------------------- POISON
		bindBox( levelPoisonCheckBox, levelPoisonComboBox );
		bindField( amountPoisonCheckBox, amountPoisonField );
	}
	
	private void bindBox( CheckBox check, ComboBox combo ) {
		check.selectedProperty().addListener( ( observable, oldValue, newValue ) -> combo.setDisable( !newValue ) );
	}
	
	private void bindField( CheckBox check, TextField textField ) {
		check.selectedProperty().addListener( ( observable, oldValue, newValue ) -> textField.setDisable( !newValue ) );
	}
	
	private void setFieldOnlyNumber( TextField textField ) {
		textField.textProperty().addListener( ( observable, oldValue, newValue ) -> {
			if ( !newValue.matches( "\\d*" ) ) {
				textField.setText( newValue.replaceAll( "[^\\d]", "" ) );
			}
		} );
	}
	
	// ----------------------------------------  PUBLIC METHODS  ----------------------------------------
	
	public void initControllerConfig() {
		try {
			createWeaponConfig( LootController.getLootClassByName( "Waffen" ) );
			createFirstAidConfig( LootController.getLootClassByName( "Erste Hilfe" ) );
			createPoisonConfig( LootController.getLootClassByName( "Gifte" ) );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	
	private void createWeaponConfig( LootClass lootClass ) {
		try {
			
			lootClass.getConfiguration().setSearchForType( categoryWeaponCheckBox.isSelected() );
			lootClass.getConfiguration().setType( categoryWeaponComboBox.getSelectionModel().getSelectedItem() );
			
			lootClass.getConfiguration().setSearchMaxQuality( qualityWeaponCheckBox.isSelected() );
			lootClass.getConfiguration().setMaxQuality( qualityWeaponComboBox.getSelectionModel().getSelectedItem() );
			
			if ( amountWeaponCheckBox.isSelected() ) {
				int selected = Integer.parseInt( amountWeaponField.getText() );
				lootClass.getConfiguration().setAmount( selected );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private void createFirstAidConfig( LootClass lootClass ) {
		try {
			lootClass.getConfiguration().setSearchMaxQuality( levelFirstAidCheckBox.isSelected() );
			lootClass.getConfiguration().setMaxQuality( levelFirstAidComboBox.getSelectionModel().getSelectedItem() );
			
			if ( amountFirstAidCheckBox.isSelected() ) {
				int selected = Integer.parseInt( amountFirstAidField.getText() );
				lootClass.getConfiguration().setAmount( selected );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private void createPoisonConfig( LootClass lootClass ) {
		try {
			lootClass.getConfiguration().setSearchMaxQuality( levelPoisonCheckBox.isSelected() );
			lootClass.getConfiguration().setMaxQuality( levelPoisonComboBox.getSelectionModel().getSelectedItem() );
			
			if ( amountPoisonCheckBox.isSelected() ) {
				int selected = Integer.parseInt( amountPoisonField.getText() );
				lootClass.getConfiguration().setAmount( selected );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	
	public ScrollPane getRootPane() {
		return rootPane;
	}
	
	public void setRootPane( ScrollPane rootPane ) {
		this.rootPane = rootPane;
	}
	
	public AlexGenerator getAlexGenerator() {
		return alexGenerator;
	}
	
	public void setAlexGenerator( AlexGenerator alexGenerator ) {
		this.alexGenerator = alexGenerator;
	}
}
