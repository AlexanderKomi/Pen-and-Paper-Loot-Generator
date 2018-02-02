package testing;

import js.JSManager;
import kt.TestFile;
import kt.testingObject;

public class LanguageSupportTest {
	
	public static void test() {
		javascriptTest();
		kotlinTest();
	}
	
	private static void javascriptTest() {
		JSManager.demo();
	}
	
	private static void kotlinTest() {
		
		TestFile f = new TestFile();
		f.printStuff( "Test" );         // private non-static call
		f.printStuff( testingObject.constant );
	}
	
}
