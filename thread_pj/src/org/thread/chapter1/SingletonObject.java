package org.thread.chapter1;
/**
* 饿汉式单例模式是线程安全的，下面介绍三种安全的单例懒加载
* 
*/

/**
 * 使用volatile方式，进行double check
 * @author ZZY
 * @date   2017年9月17日
 */
public class SingletonObject {
	/**
	 * 使用volatile,防止出现NPE问题
	 */
	private static volatile SingletonObject INSTANCE ;
	
	private SingletonObject() {
		
	}
	
	public SingletonObject getInstance() {
		// double check
		if (INSTANCE == null) {
			synchronized(SingletonObject.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonObject();
				}
			}
		}
		return INSTANCE;
	}
}

/**
 * 使用枚举类型，枚举类型是线程安全的，且其构造方法只执行一次。
 * @author ZZY
 * @date   2017年9月17日
 */
class SingletonObject1 {
	private static SingletonObject1 instance;
	
	private enum Singleton {
		INSTANCE;
		Singleton() {
			instance = new SingletonObject1();
		}
		public SingletonObject1 getInstance() {
			return instance;
		}
	}
	
	public SingletonObject1 getInstance() {
		return Singleton.INSTANCE.getInstance();
	}
}

/**
 * 使用IntanceHoler实现
 * @author ZZY
 * @date   2017年9月17日
 */
class SingletonObject2 {
	private SingletonObject2() {}
	
	private static class  InstanceHolder{
		private static final SingletonObject2 instance = new SingletonObject2();
	}
	
	public SingletonObject2 getInstance() {
		return InstanceHolder.instance;
	}
}




















