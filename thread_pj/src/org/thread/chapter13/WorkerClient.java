package org.thread.chapter13;
/**
* 
* @author zzy 2017年9月30日
* @version
*/
public class WorkerClient {
	public static void main(String[] args) {
		final Channel channel = new Channel(5);
		
		channel.startWorker();
		
		new ThransportThread("Jack", channel).start();
		new ThransportThread("Ma", channel).start();
		new ThransportThread("zzy", channel).start();
		
	}
}
