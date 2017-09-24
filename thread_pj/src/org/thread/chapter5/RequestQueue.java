package org.thread.chapter5;

import java.util.LinkedList;

/**
 * 
 * @author zzy 2017年9月24日
 * @version
 */
public class RequestQueue {
	private final LinkedList<Request> queue = new LinkedList<>();

	public Request getRequest() {
		synchronized (queue) {
			try {
				while (queue.size() <= 0) {
					queue.wait();
				}
			} catch (InterruptedException e) {
				return null;
			}
		}

		return queue.removeFirst();
	}
	
	public void putRequest(Request request) {
		synchronized(queue) {
			queue.addLast(request);
			queue.notifyAll();
		}
	}
}
