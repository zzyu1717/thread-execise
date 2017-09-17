package org.thread.chapter1;

import java.util.stream.IntStream;

/**
* 
* @author zzy 2017年9月17日
* @version
*/

/**
 * 1、所有对象都会有一个wait set, 用来存放调用了该对象wait方法之后进入block状态的线程 
 * 2、线程被notify之后，不一定立即得到执行
 * 3、线程从wait set中被唤醒顺序不一定是FIFO 
 * 4、线程唤醒后，必须重新获取锁
 * 
 * @author ZZY
 * @date 2017年9月17日
 */
public class WaitSet {
	private static final Object LOCK = new Object();

	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10).forEach(i -> new Thread(String.valueOf(i)) {
			@Override
			public void run() {
				synchronized (LOCK) {
					System.out.println(Thread.currentThread().getName() + " coming lock");
					try {
						LOCK.wait();
						System.out.println("\t" + Thread.currentThread().getName() + " leaving lock");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		IntStream.rangeClosed(1, 10).forEach(i -> new Thread(String.valueOf(i)) {
			@Override
			public void run() {
				synchronized (LOCK) {
					LOCK.notify();
				}
			}
		}.start());

	}
}
