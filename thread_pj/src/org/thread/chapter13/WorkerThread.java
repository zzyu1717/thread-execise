package org.thread.chapter13;

import java.util.Random;

/**
* 
* @author zzy 2017年9月29日
* @version
*/
public class WorkerThread extends Thread {

	private final Channel channel;
	
	private static final Random random = new Random(System.currentTimeMillis());
	
	public WorkerThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}
	
	@Override
	public void run() {
		while (true) {
			channel.take().execute();
			try {
				Thread.sleep(random.nextInt(10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
