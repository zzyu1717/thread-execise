package org.thread.chapter9;

import java.util.LinkedList;

/**
* 
* @author zzy 2017年9月26日
* @version
*/
public class MessageQueue {
	private final LinkedList<Message> queue;
	
	private final int limit;
	
	private static final int DEFAULT_MAX_LIMIT = 100;
	
	public MessageQueue(int limit) {
		this.queue = new LinkedList<>();
		this.limit = limit;
	}
	
	public MessageQueue() {
		this(DEFAULT_MAX_LIMIT);
	}
	
	public void put(Message message) throws InterruptedException {
		synchronized(queue) {
			while (queue.size() > limit) {
				queue.wait();
			}
			
			queue.add(message);
			queue.notifyAll();
		}
	}
	
	public Message take() throws InterruptedException {
		synchronized(queue) {
			while (queue.isEmpty()) {
				queue.wait();
			}
			Message message = queue.removeFirst();
			queue.notifyAll();
			return message;
		}
	}
	
	public int getMaxLimit() {
		return limit;
	}
	public int getMessageSize() {
		synchronized(queue) {
			return queue.size();
		}
	}
}
