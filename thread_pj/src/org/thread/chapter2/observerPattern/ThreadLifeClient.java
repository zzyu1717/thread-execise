package org.thread.chapter2.observerPattern;

import java.util.Arrays;

/**
* 
* @author zzy 2017年9月21日
* @version
*/
public class ThreadLifeClient {
	public static void main(String[] args) {
		new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2","3"));;
	}
}
