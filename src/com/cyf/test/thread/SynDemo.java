package com.cyf.test.thread;

public class SynDemo {
	
	private String name = "";

	public synchronized void methodA() {
		name = "a";
		System.out.println("method a:" + name);
		
	}
	
	public synchronized void methodB() {
		name = "b";
		System.out.println("method b:" + name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
