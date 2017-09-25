package org.thread.chapter8;

import java.io.IOException;
import java.util.Random;

/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class CustomerThread extends Thread {
	private final BalkingData balkingData;
	
	private final Random random = new Random(System.currentTimeMillis());
	
	public CustomerThread(BalkingData balkingData) {
		super("customer");
		this.balkingData = balkingData;
	}
	
	@Override
	public void run() {
		try {
			balkingData.save();
			for (int i = 0; i < 20; i++) {
				balkingData.changed("NO." + i);
				Thread.sleep(random.nextInt(1000));
				balkingData.save();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
