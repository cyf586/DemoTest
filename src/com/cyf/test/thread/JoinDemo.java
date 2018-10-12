package com.cyf.test.thread;

public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		JoinDemo jd = new JoinDemo();
		Thread t1 = new Thread(jd.new ThreadJoin("t1"));
		Thread t2 = new Thread(jd.new ThreadJoin("t2"));
		t1.start();
		t1.join();
		System.out.println("continue");
		t2.start();
	}
	
	class ThreadJoin implements Runnable{
		
		String name;
		
		public ThreadJoin(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println(name + " is run");
		}
		
	}
	
}
