package org.thread.chapter7;
/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class ExecutionTask implements Runnable {
	private QueryFromDBAction dbAction = new QueryFromDBAction();
	private QueryFromHttpAction httpActon = new QueryFromHttpAction();
	@Override
	public void run() {
		dbAction.execute();
		System.out.println("The name query sucessful");
		httpActon.execute();
		System.out.println("The card id query successful");
		
		Context context = ActionContext.getInstance().getContext();
		System.out.println("The Name is " + context.getName() + ", The Card id is " + context.getCardId());
	}
	
}
