package com.cyt.test.jvm;

public class StackTest {
	
	private int a= 3;

	public static void main(String[] args) {
//		new StackTest().test();
		String s1 = "123";
		String s2 = "123";
		System.out.println(s1==s2);
		String s3 = new String("123");
		System.out.println(s1==s3);
		String s4 = "1234";
		System.out.println(s1==s4);
	}
	
//	private void test() {
//		test();
//		
//	}
}
