package org.thread.chapter8;
/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class WaiterThread extends Thread {
	private final BalkingData balkingData;
	
	public WaiterThread(BalkingData balkingData) {
		super("Waiter");
		this.balkingData = balkingData;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				balkingData.save();
				Thread.sleep(1000);
			}
		} catch(Exception e) {}
	}
}
