package org.thread.chapter7;
/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class QueryFromDBAction {
	public void execute() {
		try {
			Thread.sleep(1000L);
			String name = "zzy_" + Thread.currentThread().getName();
			ActionContext.getInstance().getContext().setName(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
