package org.thread.chapter2.observerPattern;
/**
* 
* @author zzy 2017年9月19日
* @version
*/
public class HexObserver extends Observer{
	
	public HexObserver(Subject subject) {
		super(subject);
	}
	
	@Override
	public void update() {
		System.out.println("HexObserver update the state = " + Integer.toHexString(subject.getState()));
	}
}
