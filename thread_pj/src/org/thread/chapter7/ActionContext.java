package org.thread.chapter7;
/**
* 
* @author zzy 2017年9月25日
* @version
*/
public class ActionContext {
	private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>() {
		@Override
		public Context initialValue() {
			return new Context();
		}
	};
	
	//单例设计
	private static class ContextHolder {
		private final static ActionContext instance = new ActionContext();
	}
	public static  ActionContext getInstance() {
		return ContextHolder.instance;
	}
	
	public Context getContext() {
		return threadLocal.get();
	}
	
	// ActionContext为单例设计模式
	private ActionContext() {}
	
}
