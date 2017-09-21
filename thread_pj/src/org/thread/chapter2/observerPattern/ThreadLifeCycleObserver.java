package org.thread.chapter2.observerPattern;

import java.util.List;

import org.thread.chapter2.observerPattern.ObservableRunnable.RunnableEvent;

/**
* 
* @author zzy 2017年9月21日
* @version
*/
public class ThreadLifeCycleObserver implements LifeCycleListener{

	private final Object lock = new Object();
	
	public void concurrentQuery(List<String> ids) {
		if (ids == null || ids.isEmpty()) {
			return ;
		}
		ids.stream().forEach(id -> new Thread(new ObservableRunnable(this) {
			
			@Override
			public void run() {
				try {
					this.notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
					System.out.println("query for the id " + id);
					this.notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
					Thread.sleep(1_000L);
				} catch (InterruptedException e) {
					this.notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
				}
			}
		},id).start());
	}
	@Override
	public void onEvent(RunnableEvent event) {
		synchronized (lock) {
			System.out.println("The runnable [ "+ event.getThread().getName() + " ] data changed and state is [ " + event.getState() + "]" );
			if (event.getCause() != null) {
				System.out.println("The runnable [ " + event.getThread().getName() + " ] process failed.");
				event.getCause().printStackTrace();
			}
		}
	}
	
}
