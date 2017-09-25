package org.thread.chapter8;
/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class BalkingClient {
	public static void main(String[] args) {
		BalkingData balkingData = new BalkingData("D:\\prj_experience\\threadGit\\thread_pj\\src\\balking.txt", "====BEGIN====");
		new CustomerThread(balkingData).start();
		new WaiterThread(balkingData).start();
	}
}
