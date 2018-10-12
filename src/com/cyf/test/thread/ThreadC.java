package com.cyf.test.thread;

public class ThreadC extends Thread {

	private String name;
	
	public ThreadC(String name) {
		this.name = name;
	}
	
	public void run() {
		synchronized (this) {
			System.out.println("t run");
			while(true) {
				
			}
		}
	}
}
