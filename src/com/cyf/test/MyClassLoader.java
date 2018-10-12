package com.cyf.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

	private String path;
	private String name;
	
	public MyClassLoader(String name, String path){
		super();
		this.name = name;
		this.path = path;
	}
	
	public MyClassLoader(ClassLoader parent, String name, String path){
		super(parent);
		this.name = name;
		this.path = path;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte data[] = readFileNameToByteArray(name);
		return super.defineClass(name, data, 0, data.length);
	}

	
	/**
	 * @param name
	 * D:\workspace\TestDemo\bin\com\cyf\test
	 * @return
	 */
	private byte[] readFileNameToByteArray(String name) {
		InputStream is = null;
		byte[] returnData = null;
		String path = this.path + name + ".class";
		File file = new File(path);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(file);
			int len = 0;
			while((len=is.read())!=-1){
				bos.write(len);
			}
			returnData = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return returnData;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
