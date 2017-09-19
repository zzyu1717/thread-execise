package org.thread.chapter2.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
* 事件源、被观察者
* @author zzy 2017年9月19日
* @version
*/
public class Subject {
	// 变化变量
	private int state;
	
	List<Observer> observers = new ArrayList<Observer>();
	
	public void setState(int state) {
		if (state != this.state) {
			this.state = state;
			notifyAllObserver();
		}
	}
	
	public int getState() {
		return state;
	}
	
	private void notifyAllObserver() {
		observers.stream().forEach(Observer::update);
	}
}
