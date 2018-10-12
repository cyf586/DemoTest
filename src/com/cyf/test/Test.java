package com.cyf.test;

public class Test {

	public static void main(String[] args) throws Exception {
		MyClassLoader cl = new MyClassLoader("cyf", "D:/tmp/");
		Class<?> claz = cl.loadClass("Demo");
		claz.newInstance();
	}
}
