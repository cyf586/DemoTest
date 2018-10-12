package com.cyf.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch count = new CountDownLatch(3);
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			final int num = i;
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(num + " task start");
					try {
						Thread.sleep((long)(Math.random()*10000));
						count.countDown();
						System.out.println(num + " task end");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		System.out.println("main task back");
		count.await();
		System.out.println("main task continue");
	}
}
