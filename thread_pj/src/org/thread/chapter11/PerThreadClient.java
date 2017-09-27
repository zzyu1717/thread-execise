package org.thread.chapter11;

import java.util.stream.IntStream;

/**
* 
* @author zzy 2017年9月27日
* @version
*/
public class PerThreadClient {
	public static void main(String[] args) {
		final MessageHandler handler = new MessageHandler();
		IntStream.range(0,10).forEach(i -> handler.request(new Message(String.valueOf(i))));
	}
}
