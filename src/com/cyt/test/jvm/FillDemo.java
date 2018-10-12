package com.cyt.test.jvm;

import java.util.ArrayList;
import java.util.List;

import com.cyf.test.Demo;

public class FillDemo {
	
	byte b[] = new byte[128];

	public static void main(String[] args) throws Exception {
		Thread.sleep(5000);
		System.out.println("start");
		List<Demo> list = new ArrayList<Demo>();
		for(int i=0;i<1000;i++){
			Thread.sleep(100);
			list.add(new Demo());
		}
	}
}
