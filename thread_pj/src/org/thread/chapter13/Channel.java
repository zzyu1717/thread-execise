package org.thread.chapter13;

import java.util.Arrays;

/**
* 
* @author zzy 2017年9月29日
* @version
*/
public class Channel {
	private final static int MAX_REQUEST = 100;
	
	private final Request[] requestQueue;
	
	private int head;
	
	private int tail;
	// 记录有多少数据
	private int count;
	
	private final WorkerThread[] workerPool;
	
	public Channel(int workers) {
		this.requestQueue = new Request[MAX_REQUEST];
		this.workerPool = new WorkerThread[workers];
		this.init();
	}

	private void init() {
		for (int i = 0; i < workerPool.length; i++) {
			workerPool[i] = new WorkerThread("Worker-" + i, this);
		}
	}
	
	public void startWorker() {
		Arrays.asList(workerPool).forEach(WorkerThread::start);
	}
	
	public synchronized void put(Request request) {
		while (count >= requestQueue.length) {
			try {
				this.wait();
			} catch (Exception e) {
				
			}
		}
		requestQueue[tail] = request;
		tail = (tail + 1) % requestQueue.length;
		count ++;
		this.notifyAll();
	}
	
	public synchronized Request take() {
		while (count <= 0) {
			try {
				this.wait();
			} catch (Exception e) {
				
			}
		}
		Request request = requestQueue[head];
		head = (head+1) % requestQueue.length;
		count --;
		this.notifyAll();
		return request;
	}
	
	
}
