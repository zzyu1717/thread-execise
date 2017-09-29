package org.thread.chapter13;

import java.util.Random;

/**
* 
* @author zzy 2017年9月30日
* @version
*/
public class ThransportThread extends Thread {
	private final Channel channel;
	
	private final Random random = new Random();
	
	public ThransportThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}
	
	
	@Override
	public void run() {
		try {
			for (int i = 0; true; i++) {
				Request request = new Request(getName(), i);
				this.channel.put(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (Exception e) {
			
		}
	}
}
