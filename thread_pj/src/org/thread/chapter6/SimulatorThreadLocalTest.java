package org.thread.chapter6;

import java.util.Random;

/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class SimulatorThreadLocalTest {
	/**
	 * 自定义ThreadLocal
	 */
	private final static SimulatorThreadLocal<String> threadLocal = new SimulatorThreadLocal<String>() {
		@Override
		public String initValue() {
			return "NOValue";
		}
	};
	
	private final static Random random = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			threadLocal.set( ">>Thread_0");
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +threadLocal.get());
		});
		
		Thread t2 = new Thread(()->{
			threadLocal.set( ">>Thread_1");
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +threadLocal.get());
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			//ignore
		}
		System.out.println("=====================");
		System.out.println(Thread.currentThread().getName() +" "+threadLocal.get());
	}
}
