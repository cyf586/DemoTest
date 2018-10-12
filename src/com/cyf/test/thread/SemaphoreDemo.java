package com.cyf.test.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;


public class SemaphoreDemo {

	class SemaphoreDemoRunnale implements Callable<Integer> {
		
		private Semaphore semaphore;
		private int userId;
		
		public SemaphoreDemoRunnale(int userId, Semaphore semaphore) {
			this.semaphore = semaphore;
			this.userId = userId;
		}

		@Override
		public Integer call() throws Exception {
			try {
				semaphore.acquire();
				System.out.println("�ÿͣ�" + userId + " ������Ʊ��ʱ�䣺" + new Date());
				Thread.sleep((long)(Math.random()*10000));
				semaphore.release();
				System.out.println("�ÿͣ�" + userId + " ��Ʊ����뿪��ʱ�䣺" + new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
	}
	
	private void excute() throws Exception {
		Semaphore semaphore = new Semaphore(2);
		ExecutorService exec = Executors.newCachedThreadPool();
		List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
		
		for(int i=0;i<20;i++) {
			FutureTask<Integer> task = new FutureTask<Integer>(new SemaphoreDemoRunnale(i, semaphore));
			taskList.add(task);
			exec.submit(task);
			//new SemaphoreDemoRunnale(i, semaphore)
		}
		for(int i=0;i<taskList.size();i++) {
			taskList.get(i).get();
		}
		exec.shutdown();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("��Ʊ���ڿ���");
		new SemaphoreDemo().excute();
		System.out.println("��Ʊ���ڹر�");
	}
}
