package gui.elements;

import javafx.scene.control.Tab;
import model.generator.Generator;

public class GeneratorTab extends Tab {
	
	private Generator generator;
	
	public GeneratorTab( Generator g ) {
		this.generator = g;
		this.setText( g.getName() );
	}
	
	public String generateLoot() {
		return generator.generateLoot();
	}
}
