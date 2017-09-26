package org.thread.chapter10;
/**
* 
* @author zzy 2017年9月27日
* @version
*/
public class CustomCountDownLatch {
	private final int total;
	private int counter;
	
	public CustomCountDownLatch(int total) {
		this.total = total;
	}
	
	public synchronized void countdown() {
//		System.out.println(Thread.currentThread().getName());
		this.counter ++;
		this.notifyAll();
	}
	
	public synchronized void await() throws InterruptedException {
		while (counter != total) {
			this.wait();
		}
//		System.out.println(Thread.currentThread().getName());
	}
}
