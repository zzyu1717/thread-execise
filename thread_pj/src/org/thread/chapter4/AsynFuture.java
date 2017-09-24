package org.thread.chapter4;
/**
* 
* @author zzy 2017年9月24日
* @version
*/
public class AsynFuture<T> implements Future<T> {
	/**
	 * true,表示任务完成,能够返回结果
	 */
	private volatile boolean done = false;
	private T result;
	
	public void done(T result) {
		synchronized(this) {
			this.result = result;
			this.done = true;
			this.notifyAll();
		}
	}
	
	@Override
	public T get() throws InterruptedException {
		synchronized(this) {
			while (!done) {
				this.wait();
			}
		}
		return result;
	}
	
	
}
