package org.thread.chapter2;
/**
* 
* @author zzy 2017年9月23日
* @version
*/
public class User extends Thread {
	private final String myName;
	private final String myAddress;
	private Gate gate;
	public User(String myName, String myAddress, Gate gate) {
		super();
		this.myName = myName;
		this.myAddress = myAddress;
		this.gate = gate;
	}
	
	@Override
	public void run() {
		System.out.println(myName + " user begin");
		while (true) {
			gate.pass(myName, myAddress);
		}
	}
}
