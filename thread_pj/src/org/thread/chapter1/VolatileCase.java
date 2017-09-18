package org.thread.chapter1;
/**
* 
* @author zzy 2017年9月18日
* @version
*/
public class VolatileCase {
	
	private static  volatile int initValue = 0;
	
	private static final int MAX_LIMIT = 10;
	
	public static void main(String[] args) {
		new Thread(()->{
			int localValue = initValue;
			while (localValue < MAX_LIMIT) {
				if (localValue != initValue) {
					System.out.println(Thread.currentThread().getName() + " read initValue = " + initValue);
					localValue = initValue;
				}
			}
		},"reader").start();
		
		new Thread(()->{
			while (initValue < MAX_LIMIT) {
				int localValue = initValue;
				System.out.println("\t" + Thread.currentThread().getName() + " update initValue = " + ++localValue );
				initValue = localValue;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"updater").start();
	}
}
