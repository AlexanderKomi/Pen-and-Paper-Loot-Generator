package arguments;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class handles all arguments passed to the program, when launched.
 *
 * @author Alex
 */
public final class Arguments {
	
	private static final String[] written_arguments = {
			"--version",    //This argument launches the current beta build.
			"--help",        //shows help for arguments
	};
	
	private static final String[] simple_arguments = {
			"-v",           //Equivalent to "--version"
			"-h",            //Equivalent to "--help"
	};
	
	private static final String[] explanation = {
			"This argument launches the current beta build.", //
			"shows help for arguments",
	};
	
	private static Map<String, String> legalArguments   = new HashMap<>();
	private static List<String>        illegalArguments = new LinkedList<>();
	
	//---------------------------------------- PUBLIC METHODS ---------------------------------------
	
	/**
	 * This checks if an existing argument is passed to the program, when launched and bypasses the illegal ones.
	 *
	 * @param args
	 * 		Program arguments
	 *
	 * @return A Map with the legal arguments as keys and an explanation as value.
	 */
	public static Map<String, String> checkIfArgumentsExists( String[] args ) {
		
		for ( String arg : args ) {
			if ( arg.startsWith( "-" ) ) {
				for ( int i = 0; i < simple_arguments.length; i++ ) {
					if ( arg.equals( simple_arguments[ i ] ) ) {
						legalArguments.put( written_arguments[ i ], explanation[ i ] );
					}
				}
				if ( legalArguments.get( arg ) == null ) {
					illegalArguments.add( arg );
				}
				
			}
			else if ( arg.startsWith( "--" ) ) {
				for ( int i = 0; i < written_arguments.length; i++ ) {
					if ( arg.equals( written_arguments[ i ] ) ) {
						legalArguments.put( arg, explanation[ i ] );
					}
				}
				if ( legalArguments.get( arg ) == null ) {
					illegalArguments.add( arg );
				}
			}
			else {
				illegalArguments.add( arg );
			}
			
		}
		
		return legalArguments;
	}
	
	
	public static boolean contains( String s ) {
		return legalArguments.keySet().contains( s );
	}
	
	
	// ----------------------------------- PRINTING ------------------------------------
	
	/**
	 * Prints all valid arguments.
	 */
	public static void printLegalArguments() {
		System.out.println( "Recognized arguments are : " );
		for ( String s : legalArguments.keySet() ) {
			System.out.println( "\t" + s + " :\t" + legalArguments.get( s ) );
		}
		System.out.println( "---------------------------------------------------" );
	}
	
	/**
	 * Prints all invalid arguments, which are passed by the program.
	 */
	public static void printIllegalArguments() {
		System.out.println( "Unrecognized arguments are : " );
		for ( String s : illegalArguments ) {
			System.out.println( "\t" + s );
		}
		System.out.println( "---------------------------------------------------" );
	}
	
	/**
	 * Prints out a help-page with all possible arguments.
	 */
	public static void printAllLegalArguments() {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < written_arguments.length; i++ ) {
			sb.append( written_arguments[ i ] ).append( " \t " ).append( simple_arguments[ i ] ).append( " \t " ).append( explanation[ i ] ).append( "\n" );
		}
		System.out.println( sb.toString() );
		
	}
	
	//--------------------------------------- GETTER AND SETTER --------------------------------------
	
	
	public static Map<String, String> getLegalArguments() {
		return legalArguments;
	}
}
