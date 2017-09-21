package org.thread.chapter2.observerPattern;
/**
* 
* @author zzy 2017年9月21日
* @version
*/
public interface LifeCycleListener {
	void onEvent(ObservableRunnable.RunnableEvent event) ;
}
