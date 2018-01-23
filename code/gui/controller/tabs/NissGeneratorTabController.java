package gui.controller.tabs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import model.generator.generators.NissGenerator;

public class NissGeneratorTabController {

    private NissGenerator nissGenerator = new NissGenerator(this);
    private String weaponRange = "Nahkampf";

    // --- Fxml -----------------------------------------------------------------------------------

    @FXML
    private VBox rootBox;

    // --- RadioButtons ---------------------------------------------------------------------------

    @FXML
    private RadioButton rb_random_weapontype;

    @FXML
    private RadioButton rb_weaponless;

    @FXML
    private RadioButton rb_sharp;

    @FXML
    private RadioButton rb_blunt;

    @FXML
    private RadioButton rb_pointy;

    @FXML
    private RadioButton rb_exo_melee;

    @FXML
    private RadioButton rb_throw;

    @FXML
    private RadioButton rb_pistole;

    @FXML
    private RadioButton rb_gun;

    @FXML
    private RadioButton rb_bow;

    @FXML
    private RadioButton rb_exo_range;

    @FXML
    private RadioButton rb_random_class;

    @FXML
    private RadioButton rb_poor;

    @FXML
    private RadioButton rb_medium;

    @FXML
    private RadioButton rb_good;

    @FXML
    private RadioButton rb_legendary;


    // --- ToggleGroups ---------------------------------------------------------------------------
    @FXML
    private ToggleGroup classification;
    @FXML
    private ToggleGroup weaponType;

    // --- Methods --------------------------------------------------------------------------------

    @FXML
    void weaponTypeToMelee(ActionEvent event) {
        setWeaponRange("Nahkampf");
    }

    @FXML
    void weaponTypeToRange(ActionEvent event) {
        setWeaponRange("Fernkampf");
    }

    // --- Getter and Setter ----------------------------------------------------------------------


    public VBox getRootBox() {
        return rootBox;
    }

    public NissGenerator getNissGenerator() {
        return nissGenerator;
    }

    public void setNissGenerator(NissGenerator nissGenerator) {
        this.nissGenerator = nissGenerator;
    }

    public String getWeaponType() {
        return (String) this.weaponType.getSelectedToggle().getUserData();
    }

    public String getClassification() {
        return (String) this.classification.getSelectedToggle().getUserData();
    }

    public String getWeaponRange() {
        return weaponRange;
    }

    public void setWeaponRange(String weaponRange) {
        this.weaponRange = weaponRange;
    }
}
