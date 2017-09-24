package org.thread.chapter5;

import java.lang.Thread.State;

/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class SuspensionClient {
	public static void main(String[] args) {
		final RequestQueue queue = new RequestQueue();
		
		Thread client = new ClientThread(queue,"zzy");
		client.start();
		ServerThread server = new ServerThread(queue);
		server.start();
		
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		server.close();
	}
}
