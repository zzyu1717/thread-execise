package org.thread.chapter5;

import java.util.Random;
import java.util.stream.IntStream;

/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class ClientThread extends Thread{
	private final RequestQueue queue;
	private final Random random;
	private final String sendValue;
	
	public ClientThread(RequestQueue queue,String sendValue) {
		this.queue = queue;
		this.sendValue = sendValue;
		random = new Random(System.currentTimeMillis());
	}
	
	@Override
	public void run() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			System.out.println("Client request -> " + sendValue);
			queue.putRequest(new Request(sendValue));
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
