package org.thread.chapter4;
/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class SyncInvoker {
	public static void main(String[] args) throws InterruptedException{
		
		FutureService futureService = new FutureService();
	/*	主动轮询
		Future<String> future = futureService.submit(()->{
			try {
				Thread.sleep(10_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "FINISH";
		});*/
		/**
		 * 通过回调函数接收返回值
		 */
		futureService.submit(()->{
			try {
				Thread.sleep(10_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "FINISH";
		}, System.out::println);
		
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println(">>> do other things!");
		Thread.sleep(1000L);
		System.out.println("+++++++++++++++++++++++++++");
		 
	}
	 
}
