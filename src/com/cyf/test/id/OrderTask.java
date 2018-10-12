package com.cyf.test.id;

import java.util.concurrent.CountDownLatch;

public class OrderTask implements Runnable {
	
	private CountDownLatch latch;
	private OrderService orderService;
	
	public OrderTask(CountDownLatch latch, OrderService orderService) {
		this.latch = latch;
		this.orderService = orderService;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("�߳���%s������%s\n", Thread.currentThread().getName(), orderService.getOrderNo());
	
	}

}
