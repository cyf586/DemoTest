package com.cyf.test.thread;

public class ThreadTestMain {

	public static void testSyn() {
		SynDemo demo = new SynDemo();
		ThreadA a = new ThreadA(demo);
		ThreadB b = new ThreadB(demo);
		a.start();
		b.start();
	}
	
	public static void testnotify() {
		ThreadC t = new ThreadC("c");
		synchronized (t) {
			try {
				System.out.println(Thread.currentThread().getName() + " start");
				t.start();
				System.out.println(Thread.currentThread().getName() + " wait");
				t.wait(3000);
				System.out.println(Thread.currentThread().getName() + " continue");
			}catch(Exception e) {
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		testnotify();
	}
}
