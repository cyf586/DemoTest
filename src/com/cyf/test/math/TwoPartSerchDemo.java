package com.cyf.test.math;

public class TwoPartSerchDemo {
	
	private static int a[] = {1,3,7,9,12,16,18};

	public static int twoPartSerch(int tar, int low, int high, int a[]) {
		System.out.println(tar + " " + low + " " + high);
		if(tar<a[low]||tar>a[high]||low>high) {
			return -1;
		}
		if(tar==a[low]) {
			return low;
		}
		if(tar==a[high]) {
			return high;
		}
		int mid = (low + high)/2;
		if(a[mid]>tar) {
			return twoPartSerch(tar, low, mid, a);
		}else if(a[mid]<tar) {
			return twoPartSerch(tar, mid, high, a);
		}else {
			return mid;
		}
	}
	
	public static void main(String[] args) {
		int res = twoPartSerch(1, 0, a.length-1, a);
		System.out.println(a[res]);
	}
}
