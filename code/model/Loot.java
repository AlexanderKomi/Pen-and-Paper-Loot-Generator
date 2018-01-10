package model;

class Loot {
	
	private String name;
	private String qualityAsWord;
	private int    qualityAsNumber;
	
	
	// ------------------------------------------ GETTER AND SETTER ------------------------------------------
	
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public String getQualityAsWord() {
		return qualityAsWord;
	}
	
	public void setQualityAsWord( String qualityAsWord ) {
		this.qualityAsWord = qualityAsWord;
	}
	
	public int getQualityAsNumber() {
		return qualityAsNumber;
	}
	
	public void setQualityAsNumber( int qualityAsNumber ) {
		this.qualityAsNumber = qualityAsNumber;
	}
}