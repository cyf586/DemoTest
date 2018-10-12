package com.cyf.test.id;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoLock {

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(1);
		OrderService orderService = new OrderIncrImpl();   
		for(int i=0;i<10;i++) {
			                     
			service.execute(new OrderTask(latch, orderService));
		}
		latch.countDown();
		service.shutdown();
	}
}
