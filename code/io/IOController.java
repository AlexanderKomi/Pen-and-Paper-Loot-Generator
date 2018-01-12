package io;

import io.dataLoading.ContentManager;

public class IOController {
	
	private static ContentManager c = new ContentManager();
	
	public static void loadStartingData() {
		c.createUsableData();
	}
	
}