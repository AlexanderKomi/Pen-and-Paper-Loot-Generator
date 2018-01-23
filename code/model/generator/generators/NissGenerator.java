package model.generator.generators;

import gui.controller.tabs.NissGeneratorTabController;
import model.LootController;
import model.generator.Generator;

public class NissGenerator extends Generator {

    private NissGeneratorTabController ngtc;
    private String lootClass;                       //may use later.
    private static Weapon weapon = new Weapon();

    private String[] weaponTypesMelee = {"Waffenlos", "Scharf", "Stumpf", "Spitz", "Exotisch"};
    private String[] weaponTypesRange = {"Wurf", "Pistole", "Gewehr", "Bogen", "Exotisch"};
    private String[] classifications = {"schlecht", "mittel", "gut", "legendär"};

    public NissGenerator(NissGeneratorTabController ngtc) {
        setNgtc(ngtc);
        try {
            lootClass = LootController.getLootClassByName("Waffen").getName();
        } catch (Exception e) {
            System.out.println("ERROR: Problem with LootClass name! @NissGenerator.");
        }
    }

    // --- Methods --------------------------------------------------------------------------------

    @Override
    public String generateLoot() {
        weapon.clear();
        String classification;

        if (ngtc.getWeaponType().equals("random")) {
            if (randomIntBetween(0, 1) == 1) {
                weapon.setType(weaponTypesMelee[randomIntBetween(0, weaponTypesMelee.length - 1)]);
                weapon.setCategory("Nahkampf");
            } else {
                weapon.setType(weaponTypesRange[randomIntBetween(0, weaponTypesRange.length - 1)]);
                weapon.setCategory("Fernkampf");
            }

        } else {
            weapon.setType(ngtc.getWeaponType());
            weapon.setCategory(ngtc.getWeaponRange());
        }

        if (ngtc.getClassification().equals("random")) {      //schlecht / mittel / gut / legendär
            classification = classifications[randomIntBetween(0, classifications.length - 1)];
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

        return weapon.print();
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


    private int randomIntBetween(int from, int to) {
        to++;
        int number = (int) (Math.random() * to);

        while (number < from) {
            number = (int) (Math.random() * to);
        }
        return number;
    }

    // --- Getter and Setter ----------------------------------------------------------------------

    private void setNgtc(NissGeneratorTabController ngtc) {
        this.ngtc = ngtc;
    }

    private NissGeneratorTabController getNgtc() {
        return this.ngtc;
    }


    private static class Weapon {

        private String name = "";
        private String category = "";       //  Melee/Range
        private String type = "";           //  WeaponType -> Gun / Pointy
        private String quality = "";        //  1 to 5
        private String damageBase = "";
        private String damageThrown = "";
        private String hitchance = "";
        private String parade = "";
        private String magazine = "";
        private String description = "";
        private String addition = "";

        public Weapon() {

        }

        public void clear() {
            this.setName("-EMPTY-");
            this.setCategory("");
            this.setType("");
            this.setQuality("");
            this.setDamageBase("");
            this.setDamageThrown("");
            this.setHitchance("");
            this.setParade("");
            this.setMagazine("");
            this.setDescription("");
            this.setAddition("");
        }

        public String print() {
            StringBuffer s = new StringBuffer();

            s.append("Name:\t\t" + this.getName() + "\n");
            s.append("Kategorie:\t\t" + this.getCategory() + "\n");
            s.append("Typ:\t\t\t\t" + this.getType() + "\n");
            s.append("Qualität:\t\t\t" + this.getQuality() + "\n");
            s.append("Grund-Schade:\t\t" + this.getDamageBase() + "\n");
            s.append("Wurf-Schaden:\t\t" + this.getDamageThrown() + "\n");
            s.append("Treffer-Chance:\t" + this.getHitchance() + "\n");
            s.append("Parade:\t\t\t" + this.getParade() + "\n");
            s.append("Magazin:\t\t\t" + this.getMagazine() + "\n");
            s.append("Beschreibung:\t\t" + this.getDescription() + "\n");
            s.append("Anmerkung:\t\t" + this.getAddition() + "\n");

            return s.toString();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getDamageBase() {
            return damageBase;
        }

        public void setDamageBase(String damageBase) {
            this.damageBase = damageBase;
        }

        public String getDamageThrown() {
            return damageThrown;
        }

        public void setDamageThrown(String damageThrown) {
            this.damageThrown = damageThrown;
        }

        public String getHitchance() {
            return hitchance;
        }

        public void setHitchance(String hitchance) {
            this.hitchance = hitchance;
        }

        public String getParade() {
            return parade;
        }

        public void setParade(String parade) {
            this.parade = parade;
        }

        public String getMagazine() {
            return magazine;
        }

        public void setMagazine(String magazine) {
            this.magazine = magazine;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAddition() {
            return addition;
        }

        public void setAddition(String addition) {
            this.addition = addition;
        }
    }

}