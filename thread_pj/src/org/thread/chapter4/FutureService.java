package org.thread.chapter4;

import java.util.function.Consumer;

/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class FutureService {
	
	public <T> Future<T> submit(final FutureTask<T> task) {
		AsynFuture<T> asynFuture = new AsynFuture<>();
		
		new Thread(()->{
			T result = task.call();
			asynFuture.done(result);
		}).start();
		
		return asynFuture;
	}
	
	/**
	 * 加入callback回调函数,系统不仅可以通过返回的future不断轮询，也可通过回调函数接收通知
	 * @param task
	 * @param consumer
	 * @return
	 */
	public <T> Future<T> submit(final FutureTask<T> task, Consumer<T> consumer) {
		AsynFuture<T> asynFuture = new AsynFuture<>();
		
		new Thread(()->{
			T result = task.call();
			asynFuture.done(result);
			consumer.accept(result);
		}).start();
		
		return asynFuture;
	}
}
