package gui.controller.tabs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import model.generator.generators.NissGenerator;

public class NissGeneratorTabController {
	
	private NissGenerator nissGenerator = new NissGenerator();

	@FXML
	private VBox rootBox;

	@FXML
	private RadioButton rb_waffenlos;

	@FXML
	private ToggleGroup waffentyp;

	@FXML
	private RadioButton rb_scharf;

	@FXML
	private RadioButton rb_stumpf;

	@FXML
	private RadioButton rb_spitz;

	@FXML
	private RadioButton rb_wurf;

	@FXML
	private RadioButton rb_pistole;

	@FXML
	private RadioButton rb_gewehr;

	@FXML
	private RadioButton rb_bogen;

	@FXML
	private Label label_magazin;

	@FXML
	private RadioButton rb_klassifizierung_benutzer;

	@FXML
	private ToggleGroup klassifizierung;

	@FXML
	private RadioButton rb_klassifizierung_schlecht;

	@FXML
	private RadioButton rb_klassifizierung_mittel;

	@FXML
	private RadioButton rb_klassifizierung_gut;

	@FXML
	private RadioButton rb_klassifizierung_legendär;

	@FXML
	private RadioButton rb_zustand_zufällig;

	@FXML
	private ToggleGroup zustand;

	@FXML
	private RadioButton rb_zustand_1;

	@FXML
	private RadioButton rb_zustand_2;

	@FXML
	private RadioButton rb_zustand_3;

	@FXML
	private RadioButton rb_zustand_4;

	@FXML
	private RadioButton rb_zustand_5;

	@FXML
	private RadioButton rb_schaden_zufällig;

	@FXML
	private ToggleGroup schaden;

	@FXML
	private RadioButton rb_schaden_schwach;

	@FXML
	private RadioButton rb_schaden_mittel;

	@FXML
	private RadioButton rb_schaden_stark;

	@FXML
	private RadioButton rb_trefferchance_zufällig;

	@FXML
	private ToggleGroup trefferchance;

	@FXML
	private RadioButton rb_trefferchance_schlecht;

	@FXML
	private RadioButton rb_trefferchance_mittel;

	@FXML
	private RadioButton rb_trefferchance_gut;

	@FXML
	private RadioButton rb_parade_zufällig;

	@FXML
	private ToggleGroup parade;

	@FXML
	private RadioButton rb_parade_schlecht;

	@FXML
	private RadioButton rb_parade_mittel;

	@FXML
	private RadioButton rb_parade_gut;

	@FXML
	private RadioButton rb_magazin_zufällig;

	@FXML
	private ToggleGroup magazin;

	@FXML
	private RadioButton rb_magazin_wenig;

	@FXML
	private RadioButton rb_magazin_mittel;

	@FXML
	private RadioButton rb_magazin_viel;

	@FXML
	private RadioButton rb_zusatz_zufällig;

	@FXML
	private ToggleGroup zusatz;

	@FXML
	private RadioButton rb_zusatz_keinen;

	@FXML
	private RadioButton rb_zusatz_negativ;

	@FXML
	private RadioButton rb_zusatz_neutral;

	@FXML
	private RadioButton rb_zusatz_positiv;


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
