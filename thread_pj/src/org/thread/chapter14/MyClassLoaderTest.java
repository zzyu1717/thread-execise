package org.thread.chapter14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
* 
* @author zzy 2017年10月28日
* @version
*/
public class MyClassLoaderTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		MyClassLoader load = new MyClassLoader("myClassLoader");
		try {
			Class<?> mlss = load.loadClass("org.thread.chapter14.MyObject");
			
			System.out.println(mlss);
			System.out.println(mlss.getClassLoader());
			System.out.println(mlss.getClassLoader().getParent());
			
			Object obj = mlss.newInstance();
			Method method = mlss.getMethod("hello", new Class<?>[] {});
			Object result = method.invoke(obj, new Object[] {});
			System.out.println(result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
