package org.thread.chapter2.observerPattern;
/**
* 
* @author zzy 2017年9月19日
* @version
*/
public class OctalObserver extends Observer{
	
	public OctalObserver(Subject subject) {
		super(subject);
	}
	
	@Override
	public void update() {
		 System.out.println("OctalObserver update state = " + Integer.toOctalString(subject.getState()));
		
	}
	
}
