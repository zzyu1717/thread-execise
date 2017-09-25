package org.thread.chapter7;

import java.util.stream.IntStream;

/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class ContextTest {
	public static void main(String[] args) {
		IntStream.range(0,5).forEach(i -> new Thread(new ExecutionTask()).start());
	}
}
