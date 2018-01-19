package gui.controller.tabs;

import gui.util.AlexConfigUtils;
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
	private CheckBox          nameWeaponCheckBox;
	@FXML
	private ComboBox<String>  nameWeaponComboBox;
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
	private CheckBox          nameFirstAidCheckBox;
	@FXML
	private ComboBox<String>  nameFirstAidComboBox;
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
	private CheckBox          namePoisonCheckBox;
	@FXML
	private ComboBox<String>  namePoisonComboBox;
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
	
	//---------------------------------------- MISC
	@FXML
	private CheckBox          nameMiscCheckBox;
	@FXML
	private ComboBox<String>  nameMiscComboBox;
	@FXML
	private CheckBox          minQualityMiscCheckBox;
	@FXML
	private ComboBox<Integer> minQualityMiscComboBox;
	@FXML
	private CheckBox          maxQualityMiscCheckBox;
	@FXML
	private ComboBox<Integer> maxQualityMiscComboBox;
	@FXML
	private CheckBox          amountMiscCheckBox;
	@FXML
	private TextField         amountMiscField;
	
	
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
			initializeMiscBoxes( LootController.getLootClassByName( "Kram" ) );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private void initializeWeaponBoxes( LootClass lootClass ) {
		AlexGuiUtil.fillStringComboBox( nameWeaponComboBox, lootClass, "Name" );
		AlexGuiUtil.fillStringComboBox( categoryWeaponComboBox, lootClass, "Kategorie" );
		AlexGuiUtil.fillStringComboBox( typeWeaponComboBox, lootClass, "Typ" );
		
		AlexGuiUtil.bindDependency( lootClass, categoryWeaponComboBox, typeWeaponComboBox, "Kategorie", "Typ" );
		AlexGuiUtil.bindDependency( lootClass, typeWeaponComboBox, nameWeaponComboBox, "Typ", "Name" );
		
		AlexGuiUtil.fillIntComboBox( minQualityWeaponComboBox, lootClass, "Qualität" );
		AlexGuiUtil.fillIntComboBox( maxQualityWeaponComboBox, lootClass, "Qualität" );
		
		AlexGuiUtil.minMaxDependency( minQualityWeaponComboBox, maxQualityWeaponComboBox );
	}
	
	private void initializeFirstAidBoxes( LootClass lootClass ) {
		AlexGuiUtil.fillStringComboBox( nameFirstAidComboBox, lootClass, "Name" );
		
		AlexGuiUtil.fillIntComboBox( minLevelFirstAidComboBox, lootClass, "Stufe" );
		AlexGuiUtil.fillIntComboBox( maxLevelFirstAidComboBox, lootClass, "Stufe" );
		AlexGuiUtil.minMaxDependency( minLevelFirstAidComboBox, maxLevelFirstAidComboBox );
	}
	
	private void initializePoisonBoxes( LootClass lootClass ) {
		AlexGuiUtil.fillStringComboBox( namePoisonComboBox, lootClass, "Name" );
		
		AlexGuiUtil.fillIntComboBox( minLevelPoisonComboBox, lootClass, "Stufe" );
		AlexGuiUtil.fillIntComboBox( maxLevelPoisonComboBox, lootClass, "Stufe" );
		AlexGuiUtil.minMaxDependency( minLevelPoisonComboBox, maxLevelPoisonComboBox );
	}
	
	private void initializeMiscBoxes( LootClass lootClass ) {
		AlexGuiUtil.fillStringComboBox( nameMiscComboBox, lootClass, "Name" );
		
		AlexGuiUtil.fillIntComboBox( minQualityMiscComboBox, lootClass, "Qualität" );
		AlexGuiUtil.fillIntComboBox( maxQualityMiscComboBox, lootClass, "Qualität" );
		AlexGuiUtil.minMaxDependency( minQualityMiscComboBox, maxQualityMiscComboBox );
	}
	
	// ----------------------------- GUI initialization -----------------------------
	
	private void setDefaultValues() {
		//---------------------------------------- WEAPONS
		nameWeaponComboBox.getSelectionModel().selectFirst();
		categoryWeaponComboBox.getSelectionModel().selectFirst();
		typeWeaponComboBox.getSelectionModel().selectFirst();
		minQualityWeaponComboBox.getSelectionModel().selectFirst();
		maxQualityWeaponComboBox.getSelectionModel().selectLast();
		AlexGuiUtil.setFieldOnlyNumber( amountWeaponField );
		amountWeaponField.setText( "0" );
		//---------------------------------------- FIRST AID
		nameFirstAidComboBox.getSelectionModel().selectFirst();
		minLevelFirstAidComboBox.getSelectionModel().selectFirst();
		maxLevelFirstAidComboBox.getSelectionModel().selectLast();
		AlexGuiUtil.setFieldOnlyNumber( amountFirstAidField );
		amountFirstAidField.setText( "0" );
		//---------------------------------------- POISON
		namePoisonComboBox.getSelectionModel().selectFirst();
		minLevelPoisonComboBox.getSelectionModel().selectFirst();
		maxLevelPoisonComboBox.getSelectionModel().selectLast();
		AlexGuiUtil.setFieldOnlyNumber( amountPoisonField );
		amountPoisonField.setText( "0" );
		//---------------------------------------- MISC
		nameMiscComboBox.getSelectionModel().selectFirst();
		minQualityMiscComboBox.getSelectionModel().selectFirst();
		maxQualityMiscComboBox.getSelectionModel().selectLast();
		AlexGuiUtil.setFieldOnlyNumber( amountMiscField );
		amountMiscField.setText( "0" );
	}
	
	private void disableElements() {
		//---------------------------------------- WEAPONS
		nameWeaponComboBox.setDisable( true );
		categoryWeaponComboBox.setDisable( true );
		typeWeaponComboBox.setDisable( true );
		minQualityWeaponComboBox.setDisable( true );
		maxQualityWeaponComboBox.setDisable( true );
		amountWeaponField.setDisable( true );
		//---------------------------------------- FIRST AID
		nameFirstAidComboBox.setDisable( true );
		minLevelFirstAidComboBox.setDisable( true );
		maxLevelFirstAidComboBox.setDisable( true );
		amountFirstAidField.setDisable( true );
		//---------------------------------------- POISON
		namePoisonComboBox.setDisable( true );
		minLevelPoisonComboBox.setDisable( true );
		maxLevelPoisonComboBox.setDisable( true );
		amountPoisonField.setDisable( true );
		//---------------------------------------- MISC
		nameMiscComboBox.setDisable( true );
		minQualityMiscComboBox.setDisable( true );
		maxQualityMiscComboBox.setDisable( true );
		amountMiscField.setDisable( true );
	}
	
	private void bindGuiValues() {
		//---------------------------------------- WEAPONS
		AlexGuiUtil.bindBox( nameWeaponCheckBox, nameWeaponComboBox );
		AlexGuiUtil.bindBox( categoryWeaponCheckBox, categoryWeaponComboBox );
		AlexGuiUtil.bindBox( typeWeaponCheckBox, typeWeaponComboBox );
		AlexGuiUtil.bindBox( minQualityWeaponCheckBox, minQualityWeaponComboBox );
		AlexGuiUtil.bindBox( maxQualityWeaponCheckBox, maxQualityWeaponComboBox );
		AlexGuiUtil.bindField( amountWeaponCheckBox, amountWeaponField );
		//---------------------------------------- FIRST AID
		AlexGuiUtil.bindBox( nameFirstAidCheckBox, nameFirstAidComboBox );
		AlexGuiUtil.bindBox( minLevelFirstAidCheckBox, minLevelFirstAidComboBox );
		AlexGuiUtil.bindBox( maxLevelFirstAidCheckBox, maxLevelFirstAidComboBox );
		AlexGuiUtil.bindField( amountFirstAidCheckBox, amountFirstAidField );
		//---------------------------------------- POISON
		AlexGuiUtil.bindBox( namePoisonCheckBox, namePoisonComboBox );
		AlexGuiUtil.bindBox( minLevelPoisonCheckBox, minLevelPoisonComboBox );
		AlexGuiUtil.bindBox( maxLevelPoisonCheckBox, maxLevelPoisonComboBox );
		AlexGuiUtil.bindField( amountPoisonCheckBox, amountPoisonField );
		//---------------------------------------- MISC
		AlexGuiUtil.bindBox( nameMiscCheckBox, nameMiscComboBox );
		AlexGuiUtil.bindBox( minQualityMiscCheckBox, minQualityMiscComboBox );
		AlexGuiUtil.bindBox( maxQualityMiscCheckBox, maxQualityMiscComboBox );
		AlexGuiUtil.bindField( amountMiscCheckBox, amountMiscField );
	}
	
	// ----------------------------------------  CONFIG initialization  ----------------------------------------
	
	public void initControllerConfig() {
		try {
			createWeaponConfig( LootController.getLootClassByName( "Waffen" ) );
			createFirstAidConfig( LootController.getLootClassByName( "Erste Hilfe" ) );
			createPoisonConfig( LootController.getLootClassByName( "Gifte" ) );
			createMiscConfig( LootController.getLootClassByName( "Kram" ) );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private void createWeaponConfig( LootClass lootClass ) {
		AlexConfigUtils.setName( lootClass, nameWeaponCheckBox, nameWeaponComboBox );
		AlexConfigUtils.setCategory( lootClass, categoryWeaponCheckBox, categoryWeaponComboBox );
		AlexConfigUtils.setType( lootClass, typeWeaponCheckBox, typeWeaponComboBox );
		AlexConfigUtils.setMinQuality( lootClass, minQualityWeaponCheckBox, minQualityWeaponComboBox );
		AlexConfigUtils.setMaxQuality( lootClass, maxQualityWeaponCheckBox, maxQualityWeaponComboBox );
		
		if ( amountWeaponCheckBox.isSelected() ) {
			int selected = Integer.parseInt( amountWeaponField.getText() );
			lootClass.getConfiguration().setAmount( selected );
		}
	}
	
	private void createFirstAidConfig( LootClass lootClass ) {
		AlexConfigUtils.setMinQuality( lootClass, minLevelFirstAidCheckBox, minLevelFirstAidComboBox );
		AlexConfigUtils.setMaxQuality( lootClass, maxLevelFirstAidCheckBox, maxLevelFirstAidComboBox );
		
		if ( amountFirstAidCheckBox.isSelected() ) {
			int selected = Integer.parseInt( amountFirstAidField.getText() );
			lootClass.getConfiguration().setAmount( selected );
		}
	}
	
	private void createPoisonConfig( LootClass lootClass ) {
		AlexConfigUtils.setMinQuality( lootClass, minLevelPoisonCheckBox, minLevelPoisonComboBox );
		AlexConfigUtils.setMaxQuality( lootClass, maxLevelPoisonCheckBox, maxLevelPoisonComboBox );
		
		if ( amountPoisonCheckBox.isSelected() ) {
			int selected = Integer.parseInt( amountPoisonField.getText() );
			lootClass.getConfiguration().setAmount( selected );
		}
		
	}
	
	private void createMiscConfig( LootClass lootClass ) {
		AlexConfigUtils.setName( lootClass, nameMiscCheckBox, nameMiscComboBox );
		AlexConfigUtils.setMinQuality( lootClass, minQualityWeaponCheckBox, minQualityMiscComboBox );
		AlexConfigUtils.setMaxQuality( lootClass, maxQualityWeaponCheckBox, maxQualityMiscComboBox );
		
		if ( amountMiscCheckBox.isSelected() ) {
			int selected = Integer.parseInt( amountMiscField.getText() );
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
