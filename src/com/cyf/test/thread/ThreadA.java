package com.cyf.test.thread;

public class ThreadA extends Thread {
	
	private SynDemo a;
	
	public ThreadA(SynDemo demo) {
		a = demo;
	}

	public void run() {
		super.run();
		a.methodA();
	}
}
