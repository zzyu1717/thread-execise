package org.thread.chapter7;
/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class QueryFromHttpAction {
	public void execute() {
		Context context = ActionContext.getInstance().getContext() ;
		String name = context.getName();
		String cardId = getCardId(name);
		context.setCardId(cardId);
	}
	
	public String getCardId(String name) {
		try {
			Thread.sleep(1000L);
			String id = name +"_"  + Thread.currentThread().getId();
			return id;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
