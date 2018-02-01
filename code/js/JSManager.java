package js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;


/**
 * Link for reference : https://www.n-k.de/riding-the-nashorn/
 *
 * @author Alex
 */
public class JSManager {
	
	private final static String       scriptLocation = "code/js/scripts/";
	private static       ScriptEngine engine         = new ScriptEngineManager().getEngineByName( "nashorn" );
	
	public static void demo() {
		
		System.out.println( "-----------------------------------------------------------------" );
		System.out.println( "Start of JS-Demo" );
		System.out.println( "Look at js package for more information" );
		System.out.println( "-----------------------------------------------------------------" );
		try {
			engine.eval( "print(1+1)" );
			
			//-----------------------------------------------------------------------
			
			
			FileReader f = new FileReader( scriptLocation + "Example.js" );
			engine.eval( f );
			Invocable invocable = (Invocable) engine;
			
			Object result = invocable.invokeFunction( "sayHello", "John Doe" );
			System.out.println( result );
			System.out.println( result.getClass() );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		
		System.out.println( "-----------------------------------------------------------------" );
		System.out.println( "End of JS-Demo" );
		System.out.println( "-----------------------------------------------------------------" );
	}
	
}
