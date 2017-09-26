package org.thread.chapter10;

import java.util.Random;
import java.util.stream.IntStream;

/**
* 
* @author zzy 2017年9月27日
* @version
*/
public class CutomCountDownLatchClient {
	
	private static final Random random = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) {
		CustomCountDownLatch latch = new CustomCountDownLatch(5);
		System.out.println("准备开始第一阶段任务");
		IntStream.rangeClosed(1,5).forEach(i->new Thread(()->{
			try {
				System.out.println("\t"+Thread.currentThread().getName() + " is working");
				Thread.sleep(random.nextInt(1000));
				latch.countdown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, String.valueOf(i)).start());
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("准备开始第二阶段任务！");
		System.out.println("\t..............");
		System.out.println("FINISH");
		
	}
}
