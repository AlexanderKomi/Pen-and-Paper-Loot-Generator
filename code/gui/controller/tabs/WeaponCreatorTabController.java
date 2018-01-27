package gui.controller.tabs;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import model.generator.generators.DennisGenerator;

public class WeaponCreatorTabController {
	
	private DennisGenerator dennisGenerator = new DennisGenerator();
	
	@FXML
	private AnchorPane rootPane;
	
	public AnchorPane getRootPane() {
		return rootPane;
	}
	
	public DennisGenerator getGenerator() {
		return dennisGenerator;
	}
}
