package model.generator.generators.weaponGenerator;

public class Weapon {
	
	private String name         = "";
	private String category     = "";       //  Melee/Range
	private String type         = "";           //  WeaponType -> Gun / Pointy
	private String quality      = "";        //  1 to 5
	private String damageBase   = "";
	private String damageThrown = "";
	private String hitchance    = "";
	private String parade       = "";
	private String magazine     = "";
	private String description  = "";
	private String addition     = "";
	
	public void clear() {
		this.setName( "-EMPTY-" );
		this.setCategory( "" );
		this.setType( "" );
		this.setQuality( "" );
		this.setDamageBase( "" );
		this.setDamageThrown( "" );
		this.setHitchance( "" );
		this.setParade( "" );
		this.setMagazine( "" );
		this.setDescription( "" );
		this.setAddition( "" );
	}
	
	public String toPrintableFormat() {
		StringBuilder s = new StringBuilder();
		
		s.append( "Name:\t\t" ).append( this.getName() ).append( "\n" );
		s.append( "Kategorie:\t\t" ).append( this.getCategory() ).append( "\n" );
		s.append( "Typ:\t\t\t\t" ).append( this.getType() ).append( "\n" );
		s.append( "Qualität:\t\t\t" ).append( this.getQuality() ).append( "\n" );
		s.append( "Grund-Schade:\t\t" ).append( this.getDamageBase() ).append( "\n" );
		s.append( "Wurf-Schaden:\t\t" ).append( this.getDamageThrown() ).append( "\n" );
		s.append( "Treffer-Chance:\t" ).append( this.getHitchance() ).append( "\n" );
		s.append( "Parade:\t\t\t" ).append( this.getParade() ).append( "\n" );
		s.append( "Magazin:\t\t\t" ).append( this.getMagazine() ).append( "\n" );
		s.append( "Beschreibung:\t\t" ).append( this.getDescription() ).append( "\n" );
		s.append( "Anmerkung:\t\t" ).append( this.getAddition() ).append( "\n" );
		
		return s.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory( String category ) {
		this.category = category;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType( String type ) {
		this.type = type;
	}
	
	public String getQuality() {
		return quality;
	}
	
	public void setQuality( String quality ) {
		this.quality = quality;
	}
	
	public String getDamageBase() {
		return damageBase;
	}
	
	public void setDamageBase( String damageBase ) {
		this.damageBase = damageBase;
	}
	
	public String getDamageThrown() {
		return damageThrown;
	}
	
	public void setDamageThrown( String damageThrown ) {
		this.damageThrown = damageThrown;
	}
	
	public String getHitchance() {
		return hitchance;
	}
	
	public void setHitchance( String hitchance ) {
		this.hitchance = hitchance;
	}
	
	public String getParade() {
		return parade;
	}
	
	public void setParade( String parade ) {
		this.parade = parade;
	}
	
	public String getMagazine() {
		return magazine;
	}
	
	public void setMagazine( String magazine ) {
		this.magazine = magazine;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription( String description ) {
		this.description = description;
	}
	
	public String getAddition() {
		return addition;
	}
	
	public void setAddition( String addition ) {
		this.addition = addition;
	}
	
}