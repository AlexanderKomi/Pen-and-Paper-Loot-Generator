package gui.controller.tabs;

import gui.util.AlexGuiUtil;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import model.LootClass;
import model.LootController;
import model.generator.generators.AlexGenerator;

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
	private CheckBox          typeWeaponCheckBox;
	@FXML
	private ComboBox<String>  typeWeaponComboBox;
	@FXML
	private CheckBox          minQualityWeaponCheckBox;
	@FXML
	private ComboBox<Integer> minQualityWeaponComboBox;
	@FXML
	private CheckBox          maxQualityWeaponCheckBox;
	@FXML
	private ComboBox<Integer> maxQualityWeaponComboBox;
	@FXML
	private CheckBox          amountWeaponCheckBox;
	@FXML
	private TextField         amountWeaponField;
	
	//---------------------------------------- FIRST AID
	@FXML
	private CheckBox          minLevelFirstAidCheckBox;
	@FXML
	private ComboBox<Integer> minLevelFirstAidComboBox;
	@FXML
	private CheckBox          maxLevelFirstAidCheckBox;
	@FXML
	private ComboBox<Integer> maxLevelFirstAidComboBox;
	@FXML
	private CheckBox          amountFirstAidCheckBox;
	@FXML
	private TextField         amountFirstAidField;
	
	//---------------------------------------- POISON
	@FXML
	private CheckBox          minLevelPoisonCheckBox;
	@FXML
	private ComboBox<Integer> minLevelPoisonComboBox;
	@FXML
	private CheckBox          maxLevelPoisonCheckBox;
	@FXML
	private ComboBox<Integer> maxLevelPoisonComboBox;
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
		initControllerConfig();
	}
	
	// ----------------------------- initialize boxes -----------------------------
	
	private void initializeComboBoxes() {
		try {
			initializeWeaponBoxes( LootController.getLootClassByName( "Waffen" ) );
			initializeFirstAidBoxes( LootController.getLootClassByName( "Erste Hilfe" ) );
			initializePoisonBoxes( LootController.getLootClassByName( "Gifte" ) );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private void initializeWeaponBoxes( LootClass lootClass ) {
		AlexGuiUtil.fillStringComboBox( categoryWeaponComboBox, lootClass, "Kategorie" );
		AlexGuiUtil.fillStringComboBox( typeWeaponComboBox, lootClass, "Typ" );
		AlexGuiUtil.bindDependency( lootClass, categoryWeaponComboBox, typeWeaponComboBox, "Kategorie", "Typ" );
		
		AlexGuiUtil.fillIntComboBox( minQualityWeaponComboBox, lootClass, "Qualität" );
		AlexGuiUtil.fillIntComboBox( maxQualityWeaponComboBox, lootClass, "Qualität" );
		AlexGuiUtil.minMaxDependency( minQualityWeaponComboBox, maxQualityWeaponComboBox );
	}
	
	private void initializeFirstAidBoxes( LootClass lootClass ) {
		AlexGuiUtil.fillIntComboBox( minLevelFirstAidComboBox, lootClass, "Stufe" );
		AlexGuiUtil.fillIntComboBox( maxLevelFirstAidComboBox, lootClass, "Stufe" );
		AlexGuiUtil.minMaxDependency( minLevelFirstAidComboBox, maxLevelFirstAidComboBox );
	}
	
	private void initializePoisonBoxes( LootClass lootClass ) {
		AlexGuiUtil.fillIntComboBox( minLevelPoisonComboBox, lootClass, "Stufe" );
		AlexGuiUtil.fillIntComboBox( maxLevelPoisonComboBox, lootClass, "Stufe" );
		AlexGuiUtil.minMaxDependency( minLevelPoisonComboBox, maxLevelPoisonComboBox );
	}
	
	// ----------------------------- GUI initialization -----------------------------
	
	private void setDefaultValues() {
		//---------------------------------------- WEAPONS
		categoryWeaponComboBox.getSelectionModel().selectFirst();
		typeWeaponComboBox.getSelectionModel().selectFirst();
		minQualityWeaponComboBox.getSelectionModel().selectFirst();
		maxQualityWeaponComboBox.getSelectionModel().selectLast();
		AlexGuiUtil.setFieldOnlyNumber( amountWeaponField );
		amountWeaponField.setText( "0" );
		//---------------------------------------- FIRST AID
		minLevelFirstAidComboBox.getSelectionModel().selectFirst();
		maxLevelFirstAidComboBox.getSelectionModel().selectLast();
		AlexGuiUtil.setFieldOnlyNumber( amountFirstAidField );
		amountFirstAidField.setText( "0" );
		//---------------------------------------- POISON
		minLevelPoisonComboBox.getSelectionModel().selectFirst();
		maxLevelPoisonComboBox.getSelectionModel().selectLast();
		AlexGuiUtil.setFieldOnlyNumber( amountPoisonField );
		amountPoisonField.setText( "0" );
	}
	
	private void disableElements() {
		//---------------------------------------- WEAPONS
		categoryWeaponComboBox.setDisable( true );
		typeWeaponComboBox.setDisable( true );
		minQualityWeaponComboBox.setDisable( true );
		maxQualityWeaponComboBox.setDisable( true );
		amountWeaponField.setDisable( true );
		//---------------------------------------- FIRST AID
		minLevelFirstAidComboBox.setDisable( true );
		maxLevelFirstAidComboBox.setDisable( true );
		amountFirstAidField.setDisable( true );
		//---------------------------------------- POISON
		minLevelPoisonComboBox.setDisable( true );
		maxLevelPoisonComboBox.setDisable( true );
		amountPoisonField.setDisable( true );
	}
	
	private void bindGuiValues() {
		//---------------------------------------- WEAPONS
		AlexGuiUtil.bindBox( categoryWeaponCheckBox, categoryWeaponComboBox );
		AlexGuiUtil.bindBox( typeWeaponCheckBox, typeWeaponComboBox );
		AlexGuiUtil.bindBox( minQualityWeaponCheckBox, minQualityWeaponComboBox );
		AlexGuiUtil.bindBox( maxQualityWeaponCheckBox, maxQualityWeaponComboBox );
		AlexGuiUtil.bindField( amountWeaponCheckBox, amountWeaponField );
		//---------------------------------------- FIRST AID
		AlexGuiUtil.bindBox( minLevelFirstAidCheckBox, minLevelFirstAidComboBox );
		AlexGuiUtil.bindBox( maxLevelFirstAidCheckBox, maxLevelFirstAidComboBox );
		AlexGuiUtil.bindField( amountFirstAidCheckBox, amountFirstAidField );
		//---------------------------------------- POISON
		AlexGuiUtil.bindBox( minLevelPoisonCheckBox, minLevelPoisonComboBox );
		AlexGuiUtil.bindBox( maxLevelPoisonCheckBox, maxLevelPoisonComboBox );
		AlexGuiUtil.bindField( amountPoisonCheckBox, amountPoisonField );
		
	}
	
	// ----------------------------------------  CONFIG initialization  ----------------------------------------
	
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
		lootClass.getConfiguration().setSearchForCategory( categoryWeaponCheckBox.isSelected() );
		lootClass.getConfiguration().setCategory( categoryWeaponComboBox.getSelectionModel().getSelectedItem() );
		
		lootClass.getConfiguration().setSearchForType( typeWeaponCheckBox.isSelected() );
		lootClass.getConfiguration().setType( typeWeaponComboBox.getSelectionModel().getSelectedItem() );
		
		lootClass.getConfiguration().setSearchMinQuality( minQualityWeaponCheckBox.isSelected() );
		lootClass.getConfiguration().setMinQuality( minQualityWeaponComboBox.getSelectionModel().getSelectedItem() );
		
		lootClass.getConfiguration().setSearchMaxQuality( maxQualityWeaponCheckBox.isSelected() );
		lootClass.getConfiguration().setMaxQuality( maxQualityWeaponComboBox.getSelectionModel().getSelectedItem() );
		
		if ( amountWeaponCheckBox.isSelected() ) {
			int selected = Integer.parseInt( amountWeaponField.getText() );
			lootClass.getConfiguration().setAmount( selected );
		}
	}
	
	private void createFirstAidConfig( LootClass lootClass ) {
		lootClass.getConfiguration().setSearchMinQuality( minLevelFirstAidCheckBox.isSelected() );
		lootClass.getConfiguration().setMinQuality( minLevelFirstAidComboBox.getSelectionModel().getSelectedIndex() );
		
		lootClass.getConfiguration().setSearchMaxQuality( maxLevelFirstAidCheckBox.isSelected() );
		lootClass.getConfiguration().setMaxQuality( maxLevelFirstAidComboBox.getSelectionModel().getSelectedItem() );
		
		if ( amountFirstAidCheckBox.isSelected() ) {
			int selected = Integer.parseInt( amountFirstAidField.getText() );
			lootClass.getConfiguration().setAmount( selected );
		}
	}
	
	private void createPoisonConfig( LootClass lootClass ) {
		lootClass.getConfiguration().setSearchMinQuality( minLevelPoisonCheckBox.isSelected() );
		lootClass.getConfiguration().setMinQuality( minLevelPoisonComboBox.getSelectionModel().getSelectedIndex() );
		
		lootClass.getConfiguration().setSearchMaxQuality( maxLevelPoisonCheckBox.isSelected() );
		lootClass.getConfiguration().setMaxQuality( maxLevelPoisonComboBox.getSelectionModel().getSelectedItem() );
		
		if ( amountPoisonCheckBox.isSelected() ) {
			int selected = Integer.parseInt( amountPoisonField.getText() );
			lootClass.getConfiguration().setAmount( selected );
		}
		
	}
	
	// ---------------------------------------- GETTER AND SETTER ----------------------------------------
	
	
	public ScrollPane getRootPane() {
		return rootPane;
	}
	
	public AlexGenerator getAlexGenerator() {
		return alexGenerator;
	}
}
