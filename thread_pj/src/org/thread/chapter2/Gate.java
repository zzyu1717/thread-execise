package org.thread.chapter2;
/**
* 
* @author zzy 2017年9月23日
* @version
*/
public class Gate {
	private int counter;
	private String name = "nobody";
	private String address = "nowhere";
	
	public synchronized void pass(String name, String address) {
		this.counter ++;
		this.name = name;
		this.address = address;
		verify();
	}

	private void verify() {
		if (this.name.charAt(0) != this.address.charAt(0)) {
			System.out.println("=================broken===================" + toSring());
		}
	}

	private synchronized String toSring() {
		return "No." + counter + " name = " + name + ", address = " + address;
	}
}
