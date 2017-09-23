package org.thread.chapter2;
/**
* 
* @author zzy 2017年9月23日
* @version
*/
public class Client {
	public static void main(String[] args) {
		Gate gate = new Gate();
		
		User bj = new User("baobao", "beijing",gate);
		User sh = new User("shanglao", "shanghai",gate);
		
		bj.start();
		sh.start();
	}
}
