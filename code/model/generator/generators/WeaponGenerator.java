package model.generator.generators;

import gui.controller.tabs.WeaponGeneratorTabController;
import model.LootController;
import model.generator.Generator;
import model.generator.generators.weaponGenerator.Weapon;
import model.generator.generators.weaponGenerator.WeaponConst;
import model.generator.generators.weaponGenerator.WeaponNameGenerator;

public class WeaponGenerator extends Generator {

    private WeaponGeneratorTabController ngtc;
    private String lootClass;                       //may use later.
    private static Weapon weapon = new Weapon();


    public WeaponGenerator(WeaponGeneratorTabController ngtc) {
        setNgtc(ngtc);
        try {
            lootClass = LootController.getLootClassByName("Waffen").getName();
        } catch (Exception e) {
            System.out.println("ERROR: Problem with LootClass name! @NissGenerator.");
            e.printStackTrace();
        }
    }

    // --- Methods --------------------------------------------------------------------------------

    @Override
    public String generateLoot() {
        try {
            if ( !WeaponConst.testSetup() ) {
                // TODO : Add exception handling here. Maybe an error message on gui ?
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        
        weapon.clear();
        String classification;

        if (ngtc.getWeaponType().equals("random")) {
            if ( Generator.getRandomIntInclusive( 0, 1 ) == 1 ) {
                if ( WeaponConst.weaponTypesMelee.length > 0 ) {
                    int type = Generator.getRandomIntInclusive( 0, WeaponConst.weaponTypesMelee.length - 1 );
                    weapon.setType( WeaponConst.weaponTypesMelee[ type ] );
                    weapon.setCategory( "Nahkampf" );
                }
                else {
                    try {
                        String e = "Melee weapon types are not set.";
                        throw new Exception( e );
                    }
                    catch ( Exception e1 ) {
                        e1.printStackTrace();
                    }
                }
            } else {
                if ( WeaponConst.weaponTypesRange.length > 0 ) {
                    int type = Generator.getRandomIntInclusive( 0, WeaponConst.weaponTypesRange.length - 1 );
                    weapon.setType( WeaponConst.weaponTypesRange[ type ] );
                    weapon.setCategory( "Fernkampf" );
                }
                else {
                    try {
                        String e = "Ranged weapon types are not set.";
                        throw new Exception( e );
                    }
                    catch ( Exception e1 ) {
                        e1.printStackTrace();
                    }
                }
            }

        } else {
            weapon.setType(ngtc.getWeaponType());
            weapon.setCategory(ngtc.getWeaponRange());
        }

        if (ngtc.getClassification().equals("random")) {      //schlecht / mittel / gut / legendär
            classification = WeaponConst.classifications[ Generator.getRandomIntInclusive( 0, WeaponConst.classifications.length - 1 ) ];
        } else {
            classification = ngtc.getClassification();
        }

        //category -> melee/range
        

        switch (weapon.getType()) {
            case "Waffenlos":
                generateWeaponlessWeapon(classification);
                break;
            case "Scharf":
                generateSharpWeapon(classification);
                break;
            case "Stumpf":
                generateBluntWeapon(classification);
                break;
            case "Spitz":
                generatePointyWeapon(classification);
                break;
            case "Exotisch":
                if (weapon.getCategory().equals("Nahkampf")) {
                    generateExoMeleeWeapon(classification);
                } else {
                    generateExoRangeWeapon(classification);
                }
                break;
            case "Wurf":
                generateThrowWeapon(classification);
                break;
            case "Pistole":
                generatePistolWeapon(classification);
                break;
            case "Gewehr":
                generateGunWeapon(classification);
                break;
            case "Bogen":
                generateBowWeapon(classification);
                break;
            default:
                System.out.println("Fehler bei der Typbestimmung der Waffe! ");
                break;
        }
        System.out.println( WeaponNameGenerator.generateName( weapon ) );
        
        return weapon.toPrintableFormat();
    }

    private void generateWeaponlessWeapon(String classification) {
        switch (classification) {
            case "schlecht":
                weapon.setName("Boxhandschuh");

                break;
            case "mittel":
                weapon.setName("Kubotan");

                break;
            case "gut":
                weapon.setName("Schlagring");

                break;
            case "legendär":
                weapon.setName("Plattenhandschuh");
                weapon.setAddition("Kann Waffen parieren");

                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generateSharpWeapon(String classification) {
        switch (classification) {
            case "schlecht":
                weapon.setName("Brotmesser");

                break;
            case "mittel":
                weapon.setName("Küchenmesser");

                break;
            case "gut":
                weapon.setName("Machete");

                break;
            case "legendär":
                weapon.setName("Säbel");

                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generateBluntWeapon(String classification) {
        switch (classification) {
            case "schlecht":
                weapon.setName("Holzlatte");

                break;
            case "mittel":
                weapon.setName("Schraubstock");

                break;
            case "gut":
                weapon.setName("Baseballschläger");

                break;
            case "legendär":
                weapon.setName("Vorschlagshammer");

                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generatePointyWeapon(String classification) {
        switch (classification) {
            case "schlecht":
                weapon.setName("Kugelschreiber");

                break;
            case "mittel":
                weapon.setName("Springmesser");

                break;
            case "gut":
                weapon.setName("Dolch");

                break;
            case "legendär":
                weapon.setName("Speer");

                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generateExoMeleeWeapon(String classification) {
        switch (classification) {
            case "schlecht":
                weapon.setName("Säge");

                break;
            case "mittel":
                weapon.setName("schwere Kette");

                break;
            case "gut":
                weapon.setName("Bohrmaschiene");

                break;
            case "legendär":
                weapon.setName("Kettensäge");
                weapon.setAddition("Batteriebetrieben");
                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generateThrowWeapon(String classification) {
        weapon.setMagazine("1");
        switch (classification) {
            case "schlecht":
                weapon.setName("Bola");
                weapon.setMagazine("1");
                break;
            case "mittel":
                weapon.setName("Wurfsterne");
                weapon.setMagazine("2");
                weapon.setAddition("Kann 2 mal angreifen");
                break;
            case "gut":
                weapon.setName("Schleuder");
                weapon.setMagazine("1");
                break;
            case "legendär":
                weapon.setName("Doppelschleuder");
                weapon.setMagazine("2");
                weapon.setAddition("Schaden mal 2");
                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generatePistolWeapon(String classification) {
        weapon.setMagazine("0");
        switch (classification) {
            case "schlecht":
                weapon.setName("Revolver");
                weapon.setMagazine("6");
                break;
            case "mittel":
                weapon.setName("Glock");
                weapon.setMagazine("12");
                break;
            case "gut":
                weapon.setName("Baretta");
                weapon.setMagazine("18");
                weapon.setAddition("Erweitertes Magazin");
                break;
            case "legendär":
                weapon.setName("G18");
                weapon.setMagazine("24");
                weapon.setAddition("Trommelmagazin");
                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generateGunWeapon(String classification) {
        weapon.setMagazine("0");
        switch (classification) {
            case "schlecht":
                weapon.setName("Schrotflinte");
                weapon.setMagazine("2");
                break;
            case "mittel":
                weapon.setName("MP");
                weapon.setMagazine("15");
                break;
            case "gut":
                weapon.setName("Karabiner");
                weapon.setMagazine("20");
                break;
            case "legendär":
                weapon.setName("Scharfschützengewehr");
                weapon.setMagazine("5");
                weapon.setAddition("Zielfernrohr 125m - 300m");
                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generateBowWeapon(String classification) {
        weapon.setMagazine("0");
        switch (classification) {
            case "schlecht":
                weapon.setName("Primitivbogen");
                weapon.setMagazine("1");
                break;
            case "mittel":
                weapon.setName("Langbogen");
                weapon.setMagazine("1");
                break;
            case "gut":
                weapon.setName("Reflexbogen");
                weapon.setMagazine("1");
                break;
            case "legendär":
                weapon.setName("Compoundbogen");
                weapon.setMagazine("2");
                weapon.setAddition("Kann 2 mal angreifen");
                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    private void generateExoRangeWeapon(String classification) {
        weapon.setMagazine("0");
        switch (classification) {
            case "schlecht":
                weapon.setName("Nagelschussgerät");
                weapon.setMagazine("10");
                weapon.setAddition("Sicherung entfernt um zu Schießen, benötigt Nägel");
                break;
            case "mittel":
                weapon.setName("Peitsche");
                weapon.setMagazine("0");
                weapon.setAddition("Jetzt fehlt nur noch der Hut");
                break;
            case "gut":
                weapon.setName("Harpunengewehr");
                weapon.setMagazine("1");
                weapon.setAddition("mit Seil ausgestattet um das Ziel zu fixieren");
                break;
            case "legendär":
                weapon.setName("Kartoffelkanone");
                weapon.setMagazine("1");
                weapon.setAddition("Verschießt Schrott durch Luftdruck");
                break;
            default:
                System.out.println("Waffe ist weder schlecht, mittel, gut oder legendär!");
                System.exit(1);
                break;
        }
    }

    // --- Getter and Setter ----------------------------------------------------------------------

    private void setNgtc(WeaponGeneratorTabController ngtc) {
        this.ngtc = ngtc;
    }

    private WeaponGeneratorTabController getNgtc() {
        return this.ngtc;
    }
    
    
}