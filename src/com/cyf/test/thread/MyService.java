package com.cyf.test.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();

	public void methodA() {
//		synchronized (this) {
//			System.out.println("a get lock");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try {
			lock.lock();
			System.out.println("a get lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void methodB() {
//		synchronized (this) {
//			System.out.println("b get lock");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try {
			lock.lock();
			System.out.println("b get lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		MyService service = new MyService();
		new Thread(new Runnable() {

			@Override
			public void run() {
				service.methodA();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				service.methodA();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				service.methodB();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				service.methodB();
			}
		}).start();
	}
}
