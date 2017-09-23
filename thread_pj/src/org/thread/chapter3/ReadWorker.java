package org.thread.chapter3;
/**
* 
* @author zzy 2017年9月23日
* @version
*/
public class ReadWorker extends Thread{
	private SharedData data;
	
	public ReadWorker(SharedData data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				char[] readBuf = data.read();
				System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
