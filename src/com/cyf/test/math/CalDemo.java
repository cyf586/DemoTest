package com.cyf.test.math;

public class CalDemo {

	/**
	 * Ëã½×³Ë
	 * @param num
	 * @param a
	 * @return
	 */
	public static int[] plusDemo(int num, int a[]) {
		for(int i=0;i<a.length;i++) {
			a[i] *= num;
		}
 		for(int i=a.length-1;i>0;i--) {
 			a[i-1]+=a[i]/10;
			a[i]=a[i]%10;
		}
		return a;
	}
	
	public static void main(String[] args) {
//		int a[] = {3,5,7};
//		a = plusDemo(5, a);
		int a[] = new int[100];
		a[a.length-1] = 1;
		int n =50;
		for(int i=1;i<=n;i++) {
			a = plusDemo(i, a);
		}
		int temp = 0;
		boolean flag = false;
		for(int i=0;i<a.length;i++) {
			temp = a[i];
			if(a[i]!=0) {
				System.out.print(a[i]);
				flag = true;
			}else if(a[i]==0&&flag) {
				System.out.print(a[i]);
			}
		}
	}
}
