package com.cyf.test.math;

public class SortDemo {
	
	private static int a[] = {3,1,5,7,2,8,0};

	public static void bubbleSortAsc() {
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		bubbleSortAsc();
	}
}
