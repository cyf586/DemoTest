package com.cyf.test.thread;

import java.util.concurrent.TimeUnit;

public class WaitNotify {

	private boolean flag = true;
	
	private Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		WaitNotify demo = new WaitNotify();
		Thread wait = new Thread(demo.new Wait());
		wait.start();
		TimeUnit.SECONDS.sleep(3);
		Thread notify = new Thread(demo.new Notify());
		notify.start();
	}
	
	class Wait implements Runnable{

		@Override
		public void run() {
			synchronized (lock) {
				while(flag) {
					System.out.println("wait");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				System.out.println("continue");
			}
		}
		
	}
	
	class Notify implements Runnable{

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println("get lock, notify");
				lock.notifyAll();
				flag = false;
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
