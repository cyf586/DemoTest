package com.cyf.test.math;

public class MyArrayList {
	
	private Object os[] = new Object[8];
	
	private int size;
	
	public int getSize() {
		return size;
	}
	
	public void add(Object o) {
		if(size>=os.length) {
			Object temp[] = new Object[os.length*2];
			for(int i=0;i<temp.length;i++) {
				temp[i] = os[i];
			}
			os = temp;
		}
		os[size] = o;
		size++;
	}
	
}
