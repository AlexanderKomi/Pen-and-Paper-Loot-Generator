package gui.controller.tabs;

import constants.IOConstants;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import model.LootController;
import model.generator.generators.AlexGenerator;
import model.generator.generators.Configuration;

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
		//---------------------------------------- FIRST AID
		levelFirstAidComboBox.getSelectionModel().selectFirst();
		amountFirstAidComboBox.getSelectionModel().selectFirst();
		//---------------------------------------- POISON
		levelPoisonComboBox.getSelectionModel().selectFirst();
		amountPoisonComboBox.getSelectionModel().selectFirst();
		
		setFieldOnlyNumber( amountWeaponField );
		amountWeaponField.setText( "0" );
	}
	
	private void disableComboBoxes() {
		//---------------------------------------- WEAPONS
		categoryWeaponComboBox.setDisable( true );
		qualityWeaponComboBox.setDisable( true );
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
		bindField( amountWeaponCheckBox, amountWeaponField );
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
	
	public Configuration[] getConfiguration() {
		Configuration[] configuration = new Configuration[ IOConstants.lootClasses.length ];
		
		configuration[ 0 ] = createWeaponConfig();
		configuration[ 1 ] = createFirstAidConfig();
		configuration[ 2 ] = createPoisonConfig();
		
		return configuration;
	}
	
	private Configuration createWeaponConfig() {
		Configuration configuration = null;
		try {
			int index        = LootController.getLootClassByName( "Waffen" ).getIndex();
			int columnLength = IOConstants.columnDefinitions[ index ].length;
			configuration = new Configuration( index, columnLength );
			
			if ( categoryWeaponCheckBox.isSelected() ) {
				configuration.setConfig( 1, categoryWeaponComboBox.getSelectionModel().getSelectedItem() );
			}
			if ( qualityWeaponCheckBox.isSelected() ) {
				configuration.setConfig( IOConstants.qualityIndexes[ index ], categoryWeaponComboBox.getSelectionModel().getSelectedItem() );
			}
			if ( amountWeaponCheckBox.isSelected() ) {
				int selected = Integer.parseInt( amountWeaponField.getText() );
				configuration.setAmount( selected );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		return configuration;
	}
	
	private Configuration createFirstAidConfig() {
		Configuration configuration = null;
		try {
			int index        = LootController.getLootClassByName( "Erste Hilfe" ).getIndex();
			int columnLength = IOConstants.columnDefinitions[ index ].length;
			configuration = new Configuration( index, columnLength );
			
			if ( levelFirstAidCheckBox.isSelected() ) {
				configuration.setConfig( IOConstants.qualityIndexes[ index ], levelFirstAidComboBox.getSelectionModel().getSelectedItem() );
			}
			if ( amountFirstAidCheckBox.isSelected() ) {
				configuration.setAmount( amountFirstAidComboBox.getSelectionModel().getSelectedIndex() );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		return configuration;
	}
	
	private Configuration createPoisonConfig() {
		Configuration configuration = null;
		try {
			int index        = LootController.getLootClassByName( "Gifte" ).getIndex();
			int columnLength = IOConstants.columnDefinitions[ index ].length;
			configuration = new Configuration( index, columnLength );
			
			if ( levelPoisonCheckBox.isSelected() ) {
				configuration.setConfig( IOConstants.qualityIndexes[ index ], levelPoisonComboBox.getSelectionModel().getSelectedItem() );
			}
			if ( amountPoisonCheckBox.isSelected() ) {
				configuration.setAmount( amountPoisonComboBox.getSelectionModel().getSelectedIndex() );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		return configuration;
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
