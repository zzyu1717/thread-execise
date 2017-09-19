package org.thread.chapter2.observerPattern;
/**
* 
* @author zzy 2017年9月19日
* @version
*/
public class ObserverClient {
	public static void main(String[] args) {
		Subject subject = new Subject();
		HexObserver ho = new HexObserver(subject);
		OctalObserver oo = new OctalObserver(subject);
		System.out.println("=========================");
		subject.setState(10);
		System.out.println("=========================");
		System.out.println("=========================");
		subject.setState(10);
		System.out.println("=========================");
		System.out.println("=========================");
		subject.setState(15);
		System.out.println("=========================");
	}
}
