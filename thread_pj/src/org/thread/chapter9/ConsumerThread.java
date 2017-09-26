package org.thread.chapter9;

import java.util.Random;

/**
* 
* @author zzy 2017年9月26日
* @version
*/
public class ConsumerThread extends Thread {
	private final MessageQueue messageQueue;
	
	private final static Random random = new Random(System.currentTimeMillis());
	
	public ConsumerThread(MessageQueue messageQueue, int seq) {
		super("Consumer_" + seq);
		this.messageQueue = messageQueue;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Message message = messageQueue.take();
				System.out.println("\t"+Thread.currentThread().getName() + " take message: " + message.getData());
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
