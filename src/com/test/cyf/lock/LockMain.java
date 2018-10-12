package com.test.cyf.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 理解对象锁 和 类锁
 * @author Administrator
 *
 */
public class LockMain {
	
	static int num = 0;

	public static synchronized void testLock() {
//		synchronized (LockMain.class) {
//			System.out.printf("%s线程进入\n", num++);
//		}
		System.out.printf("%s线程进入\n", num++);
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(5000);
		
		for(int i=0;i<5000;i++) {
			LockMain lock = new LockMain();
			service.execute(new Runnable() {
				
				@Override
				public void run() {
					lock.testLock();
					try {
						latch.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}
			});
		}
		latch.await();
		service.shutdown();
		System.out.println("===========" + num);

	}
}
