package gui.elements;

import javafx.scene.control.Tab;
import model.generator.Generator;

public class GeneratorTab extends Tab implements Comparable<GeneratorTab> {
	
	private Generator generator;
	
	public GeneratorTab( Generator g ) {
		this.generator = g;
		this.setText( g.getName() );
	}
	
	public GeneratorTab( Generator g, Tab n ) {
		this.generator = g;
		this.setText( g.getName() );
		this.setContent( n.getContent() );
	}
	
	public String generateLoot() {
		return generator.generateLoot();
	}
	
	@Override
	public boolean equals( Object obj ) {
		return super.equals( obj );
	}
	
	@Override
	public int compareTo( GeneratorTab o ) {
		return 0;
	}
}
