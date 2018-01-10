package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	public String readFile( String fileLocation ) {
		String everything = "";
		try ( BufferedReader br = new BufferedReader( new FileReader( fileLocation ) ) ) {
			StringBuilder sb   = new StringBuilder();
			String        line = br.readLine();
			
			while ( line != null ) {
				sb.append( line );
				sb.append( System.lineSeparator() );
				line = br.readLine();
			}
			everything = sb.toString();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		return everything;
	}
	
}
