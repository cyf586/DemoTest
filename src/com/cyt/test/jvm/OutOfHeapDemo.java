package com.cyt.test.jvm;

import java.util.ArrayList;
import java.util.List;

import com.cyf.test.Demo;

public class OutOfHeapDemo {

	public static void main(String[] args) {
		List<Demo> list = new ArrayList<Demo>();
		while(true){
			list.add(new Demo());
		}
	}
}
