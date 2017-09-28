package org.thread.chapter12;

import java.io.IOException;

/**
* 
* @author zzy 2017年9月28日
* @version
*/
public class AppServerClient {
	public static void main(String[] args) throws InterruptedException, IOException {
		AppServer server = new AppServer();
		server.start();
		Thread.sleep(40_000);
		server.shutdown();
	}
}
