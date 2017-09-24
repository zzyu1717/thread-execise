package org.thread.chapter4;
/**
* 
* @author zzy 2017年9月24日
* @version
*/
public interface Future<T> {
	T get() throws InterruptedException;
}
