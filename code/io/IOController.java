package io;

import io.dataLoading.ContentManager;

public class IOController {
	
	private ContentManager c = new ContentManager();
	
	public void loadStartingData() {
		c.createUsableData();
	}
	
}