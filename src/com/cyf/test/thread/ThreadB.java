package com.cyf.test.thread;

public class ThreadB extends Thread {

	private SynDemo b;
	
	public ThreadB(SynDemo demo) {
		b = demo;
	}

	
	public void run() {
		super.run();
		b.methodB();
	}
}
