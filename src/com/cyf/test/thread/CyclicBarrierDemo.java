package com.cyf.test.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	public static void excute() {
		CyclicBarrier cb = new CyclicBarrier(3);
		for(int i=0;i<3;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("arrive " + (cb.getNumberWaiting() + 1));
						cb.await();
						System.out.println("start");
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	public static void main(String[] args) {
		excute();
	}
}
