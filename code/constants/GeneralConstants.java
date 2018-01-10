package constants;

/**
 * THis class contains all information as constants about the program, like version and authors.
 *
 * @author Alexander Komischke
 * @version 1.0
 */
public final class GeneralConstants {
	
	/*Naming conventions for versions :
	 *
	 * [STABILITY]_[BUILD NUMBER]_[STATUS]
	 *
	 * STABILITY :
	 *       - u : unstable
	 *       - s : stable
	 *
	 * BUILD NUMBER : [MAJOR RELEASE] . [FEATURE RELEASE] [UPDATE RELEASE]
	 *       - MAJOR RELEASE :   Includes multiple new features and is fully tested.
	 *       - MINOR RELEASE :   Includes not fully tested features or a single feature.
	 *       - UPDATE :          Updates existing features.
	 *
	 * STATUS : [ALPHA | BETA | RELEASE]
	 *       - ALPHA :   Contains bugs and is not ready for stability testing
	 *       - BETA :    Some features are not fully implemented, but ready for stability testing.
	 *       - RELEASE : Finished part of the project.
	 *
	 * */
	public static final  String   current_version = "0.1a";
	public static final  String[] authors         = { "Alexander Komischke" };
	private static final String[] stable_versions = {};
	private static final String[] versions        = { current_version };
	
	private GeneralConstants() {
	}
	
}
