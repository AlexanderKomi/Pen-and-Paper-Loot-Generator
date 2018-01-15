package gui.controller.tabs;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import model.generator.generators.NissGenerator;

public class NissGeneratorTabController {
	
	private NissGenerator nissGenerator = new NissGenerator();
	
	@FXML
	private VBox rootBox;
	
	@FXML
	private ToggleGroup weaponType;
	
	@FXML
	private ToggleGroup classification;
	
	@FXML
	private ToggleGroup quallity;
	
	@FXML
	private ToggleGroup damage;
	
	@FXML
	private ToggleGroup hitChance;
	
	@FXML
	private ToggleGroup parade;
	
	@FXML
	private ToggleGroup magazin;
	
	@FXML
	private ToggleGroup special;
	
	// --------------------------------------- GETTER AND SETTER ---------------------------------------
	
	
	public VBox getRootBox() {
		return rootBox;
	}
	
	public NissGenerator getNissGenerator() {
		return nissGenerator;
	}
	
	public void setNissGenerator( NissGenerator nissGenerator ) {
		this.nissGenerator = nissGenerator;
	}
}
