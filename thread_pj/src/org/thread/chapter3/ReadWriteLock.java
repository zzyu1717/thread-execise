package org.thread.chapter3;

/**
 * 
 * @author zzy 2017年9月23日
 * @version
 */
public class ReadWriteLock {
	private int readingReaders = 0;
	private int waitingReaders = 0;
	private int writingWriters = 0;
	private int waitingWriters = 0;
	
	/**
	 * true,表示偏向写操作
	 */
	private boolean preferWrite = true;
	
	public ReadWriteLock() {
		this(true);
	}
	
	public ReadWriteLock(boolean preferWrite) {
		this.preferWrite = preferWrite;
	}

	public synchronized void readLock() throws InterruptedException {
		this.waitingReaders++;

		try {
			while (this.writingWriters > 0 || (preferWrite && this.waitingWriters>0)) {
				this.wait();
			}
		} finally {
			this.waitingReaders --;
		}

		this.readingReaders ++;
	}
	
	public synchronized void readUnlock() {
		this.readingReaders --;
		this.notifyAll();
	}
	
	public synchronized void writeLock() throws InterruptedException{
		this.waitingWriters ++;
		try {
			while (this.readingReaders > 0 || this.writingWriters > 0) {
				this.wait();
			}
		} finally {
			 this.waitingWriters--;
		}
		this.writingWriters ++;
	}
	
	public synchronized void writeUnlock() throws InterruptedException {
		this.writingWriters --;
		this.notifyAll();
	}

}
