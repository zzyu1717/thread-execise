package org.thread.chapter9;
/**
* 
* @author zzy 2017年9月26日
* @version
*/
public class ProducerAndConsumerClient {
	public static void main(String[] args) {
		MessageQueue messageQueue = new MessageQueue();
		
		new ProducerThread(messageQueue, 1).start();
		new ProducerThread(messageQueue, 2).start();
		new ConsumerThread(messageQueue,1).start();
		new ConsumerThread(messageQueue,2).start();
		new ConsumerThread(messageQueue,3).start();
	}
}
