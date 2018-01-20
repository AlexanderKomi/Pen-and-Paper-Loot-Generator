package gui.controller.tabs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import model.generator.generators.NissGenerator;

public class NissGeneratorTabController {

    private NissGenerator nissGenerator = new NissGenerator(this);

    // --- Fxml -----------------------------------------------------------------------------------

    @FXML
    private VBox rootBox;

    @FXML
    private Label label_magazin;

    // --- RadioButtons ---------------------------------------------------------------------------

    @FXML
    private RadioButton rb_weaponless;

    @FXML
    private RadioButton rb_sharp;

    @FXML
    private RadioButton rb_blunt;

    @FXML
    private RadioButton rb_pointy;

    @FXML
    private RadioButton rb_throwing;

    @FXML
    private RadioButton rb_pistol;

    @FXML
    private RadioButton rb_gun_crossbow;

    @FXML
    private RadioButton rb_bow;

    @FXML
    private RadioButton rb_classification_user;

    @FXML
    private RadioButton rb_classification_poor;

    @FXML
    private RadioButton rb_classification_medium;

    @FXML
    private RadioButton rb_classification_good;

    @FXML
    private RadioButton rb_classification_legendary;

    @FXML
    private RadioButton rb_quality_random;

    @FXML
    private RadioButton rb_quality_1;

    @FXML
    private RadioButton rb_quality_2;

    @FXML
    private RadioButton rb_quality_3;

    @FXML
    private RadioButton rb_quality_4;

    @FXML
    private RadioButton rb_quality_5;

    @FXML
    private RadioButton rb_damage_random;

    @FXML
    private RadioButton rb_damage_weak;

    @FXML
    private RadioButton rb_damage_medium;

    @FXML
    private RadioButton rb_damage_strong;

    @FXML
    private RadioButton rb_hitchance_random;

    @FXML
    private RadioButton rb_hitchance_poor;

    @FXML
    private RadioButton rb_hitchance_medium;

    @FXML
    private RadioButton rb_hitchance_good;

    @FXML
    private RadioButton rb_parade_random;

    @FXML
    private RadioButton rb_parade_poor;

    @FXML
    private RadioButton rb_parade_medium;

    @FXML
    private RadioButton rb_parade_good;

    @FXML
    private RadioButton rb_magazine_random;

    @FXML
    private RadioButton rb_magazine_little;

    @FXML
    private RadioButton rb_magazine_medium;

    @FXML
    private RadioButton rb_magazine_much;

    @FXML
    private RadioButton rb_addition_random;

    @FXML
    private RadioButton rb_addition_no;

    @FXML
    private RadioButton rb_addition_negative;

    @FXML
    private RadioButton rb_addition_neutral;

    @FXML
    private RadioButton rb_addition_positive;


    // --- ToggleGroups ---------------------------------------------------------------------------


    @FXML
    private ToggleGroup addition;

    @FXML
    private ToggleGroup classification;

    @FXML
    private ToggleGroup damage;

    @FXML
    private ToggleGroup hitchance;

    @FXML
    private ToggleGroup magazine;

    @FXML
    private ToggleGroup parade;

    @FXML
    private ToggleGroup quality;

    @FXML
    private ToggleGroup weaponType;


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

    public String getWeaponType() {return (String) weaponType.getSelectedToggle().getUserData();}

    public String getClassification() {return (String) classification.getSelectedToggle().getUserData();}

    public String getQuality(){return (String) quality.getSelectedToggle().getUserData();}

    public String getDamage(){return (String) damage.getSelectedToggle().getUserData();}

    public String getHitchance(){return (String) hitchance.getSelectedToggle().getUserData();}

    public String getParade(){return (String) parade.getSelectedToggle().getUserData();}

    public String getMagazine(){return (String) magazine.getSelectedToggle().getUserData();}

    public String getAddition(){return (String) addition.getSelectedToggle().getUserData();}

    // --- Methods --------------------------------------------------------------------------------

    /**
     * Passes all selected values as an StringArray using "RadioButton".getUserData().
     *
     * @return values Array of all selected values
     */
    public String[] getValues() {

        String[] values = new String[8];

        values[0] = getWeaponType();
        values[1] = getClassification();
        values[2] = getQuality();
        values[3] = getDamage();
        values[4] = getHitchance();
        values[5] = getParade();
        values[6] = getMagazine();
        values[7] = getAddition();

        return values;
    }
}
