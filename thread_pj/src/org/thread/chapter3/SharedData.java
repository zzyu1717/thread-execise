package org.thread.chapter3;
/**
* 
* @author zzy 2017年9月23日
* @version
*/
public class SharedData {
	private char[] buffer;
	
	ReadWriteLock lock = new ReadWriteLock();
	
	public SharedData(int size) {
		buffer = new char[size];
		for (int i = 0; i < size; i++) {
			buffer[i] = '*';
		}
	}
	
	public char[] read() throws InterruptedException {
		try {
			lock.readLock();
			return doRead();
		} finally {
			lock.readUnlock();
		}
	}
	
	public void write(char c) throws InterruptedException {
		try {
			lock.writeLock();
			doWrite(c);
		} finally {
			lock.writeUnlock();
		}
	}
	
	private char[] doRead() {
		char[] newBuffer = new char[buffer.length];
		for (int i = 0; i < buffer.length; i++) {
			newBuffer[i] = buffer[i];
		}
		slowly(20);
		return newBuffer;
	}
	
	private void doWrite(char c) {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = c;
		}
		slowly(20);
	}
	
	private void slowly(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
