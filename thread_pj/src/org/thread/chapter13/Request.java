package org.thread.chapter13;
/**
* 
* @author zzy 2017年9月29日
* @version
*/
public class Request {
	private final String name;
	
	private final int number;
	
	public Request(final String name, final int number) {
		this.name = name;
		this.number = number;
	}
	
	public void execute() {
		System.out.println(Thread.currentThread().getName() + " executed " + this);
	}
	
	@Override
	public String toString() {
		return "Request >> No." + number + " Name." + name;
	}
}
