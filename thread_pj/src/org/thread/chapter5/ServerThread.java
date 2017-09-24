package org.thread.chapter5;

import java.util.Random;

/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class ServerThread extends Thread{
	private final Random random;
	private final RequestQueue queue;
	
	private volatile boolean closed = false;
	
	public ServerThread(RequestQueue queue) {
		this.queue = queue;
		random = new Random(System.currentTimeMillis());
	}
	
	@Override
	public void run() {
		while (!closed) {
			Request request = queue.getRequest();
			if (null == request) {
				continue;
			}
			System.out.println("Server -> " + request.getValue());
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				return ;
			}
		}
	}
	
	public void close() {
		this.closed = true;
		this.interrupt();
	}
}
