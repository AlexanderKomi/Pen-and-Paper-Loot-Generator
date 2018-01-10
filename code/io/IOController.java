package io;

import io.dataLoading.ContentManager;

public class IOController {
	
	public IOController() {
	
	}
	
	public void loadData() {
		ContentManager c = new ContentManager();
		c.createUsableData();
	}
	
}