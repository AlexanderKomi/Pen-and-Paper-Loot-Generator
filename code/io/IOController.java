package io;

import io.dataLoading.ContentManager;

public class IOController {
	
	private static FileLogger     logger = new FileLogger();
	private static ContentManager c      = new ContentManager();
	
	public static void loadStartingData() {
		c.createUsableData();
	}
	
	public static FileLogger getLogger() {
		return logger;
	}
}