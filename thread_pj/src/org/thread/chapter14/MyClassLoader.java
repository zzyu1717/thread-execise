package org.thread.chapter14;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
* 
* @author zzy 2017年10月28日
* @version
*/
public class MyClassLoader extends ClassLoader {
	
	private static final String DEFAULT_DIR = "C:\\Users\\ZZY\\Desktop\\MyClassLoaderTest";
	
	private String dir = DEFAULT_DIR;
	
	private String classLoaderName;
	
	public MyClassLoader() {}
	
	public MyClassLoader(String classLoaderName) {
		this.classLoaderName = classLoaderName;
	}
	
	public MyClassLoader(String classLoaderName, ClassLoader parent) {
		super(parent);
		this.classLoaderName = classLoaderName;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classPath = name.replace(".", "/");
		File classFile = new File(dir,classPath+".class");
		if (!classFile.exists()) {
			throw new ClassNotFoundException("The class " + name + " is not foud !");
		}
		byte[] classBytes = loadClassBytes(classFile);
		if (null == classBytes || classBytes.length == 0) {
			throw new ClassNotFoundException("load class "+ name + " failed !");
		}
		
		return this.defineClass(name, classBytes, 0, classBytes.length);
	}
	
	private byte[] loadClassBytes(File classFile) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 FileInputStream fis = new FileInputStream(classFile);) {
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getClassLoaderName() {
		return classLoaderName;
	}
}
