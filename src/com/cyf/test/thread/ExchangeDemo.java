package com.cyf.test.thread;

import java.util.concurrent.Exchanger;

public class ExchangeDemo {

	public static void main(String[] args) {
		Exchanger<String> ex = new Exchanger<String>(); 
		for(int i=0;i<4;i++) {
			final int num = i;
			new Thread(new Runnable( ) {
				@Override
				public void run() {
					try {
						String res = null;
						if(num==0) {
							res = ex.exchange("a");
						}
						if(num==1) {
							res = ex.exchange("b");
						}
						if(num==2) {
							res = ex.exchange("c");
						}
						if(num==3) {
							res = ex.exchange("d");
						}
						System.out.println(num + " get " + res);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
