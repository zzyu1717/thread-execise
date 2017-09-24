package org.thread.chapter6;

import java.util.HashMap;
import java.util.Map;

/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class SimulatorThreadLocal<T> {
	
	private final Map<Thread,T> map = new HashMap<>();
	
	protected T initValue() {
		return null;
	}
	
	public void set(T t) {
		synchronized (this) {
			Thread thread = Thread.currentThread();
			map.put(thread, t);
		}
	}
	
	public T get() {
		synchronized (this) {
			T value = map.get(Thread.currentThread());
			if (null == value) {
				return initValue();
			}
			return value;
		}
	}
}
