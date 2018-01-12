import io.IOController;
import model.generator.LootGeneratorController;

public class MainController {
	
	
	public static void initialize() {
		IOController.loadStartingData();
		LootGeneratorController.addGenerators();
	}
	
}
