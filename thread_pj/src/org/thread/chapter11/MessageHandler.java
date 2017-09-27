package org.thread.chapter11;

import java.util.Random;

/**
* 
* @author zzy 2017年9月27日
* @version
*/
public class MessageHandler {
	private final Random random = new Random(System.currentTimeMillis());
	
	public void request(Message message) {
		new Thread(()->{
			String value = message.getValue();
			try {
				Thread.sleep(random.nextInt(1000));
				System.out.println("The request will be handled by " + Thread.currentThread().getName() + " " + value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
