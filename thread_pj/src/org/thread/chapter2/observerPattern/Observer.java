package org.thread.chapter2.observerPattern;
/**
* 
* @author zzy 2017年9月19日
* @version
*/
public abstract class Observer {
	
	protected Subject subject;
	
	protected Observer(Subject subject) {
		this.subject = subject;
		this.subject.observers.add(this);
	}
	
	public abstract void update() ;
}
