package org.thread.chapter3;
/**
* 
* @author zzy 2017年9月23日
* @version
*/
public class ReadWriteLockClient {
	public static void main(String[] args) {
		
		SharedData data = new SharedData(10);
		
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		new ReadWorker(data).start();
		
		new WriteWork(data,"querydatahello").start();
		new WriteWork(data,"QUERYDATAHELLO").start();
		
	}
}
