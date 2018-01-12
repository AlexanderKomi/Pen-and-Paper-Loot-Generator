import io.IOController;

public class MainController {
	
	private static IOController ioController = new IOController();
	
	public static void initialize() {
		ioController.loadStartingData();
	}
	
}
