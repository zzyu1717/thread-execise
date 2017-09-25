package org.thread.chapter8;

import java.io.FileWriter;
import java.io.IOException;

/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class BalkingData {
	private final String fileName;
	
	private String content;
	
	private boolean changed;
	
	public BalkingData(String fileName, String content) {
		this.fileName = fileName;
		this.content = content;
		this.changed = true;
	}
	
	public synchronized void changed(String newContent) {
		this.content = newContent;
		this.changed = true;
	}
	
	public synchronized void save() throws IOException {
		if (!changed) {
			return ;
		}
		doSave();
		this.changed = false;
	}

	private void doSave() throws IOException {
		System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
		FileWriter writer = new FileWriter(fileName, true);
		writer.write(content);
		writer.write("\n");
		writer.flush();
		writer.close();
	}
}
