package com.cyf.test;

import java.lang.reflect.Field;

public class SwapDemo {

	public static void main(String[] args) throws Exception {
		Integer a = 5, b =6;
		swap(a, b);
		System.out.println("a=" + a + ",b=" + b);
//		Demo a = new Demo();
//		a.setName("a");
//		Demo b = new Demo();
//		b.setName("b");
//		swapDemo(a, b);
//		System.out.println("a=" + a.getName() + ",b=" + b.getName());
	}

	/** 基本类型传递是变量副本 任何改动不影响实参 ；
	 *  对象引用传递的是内存地址 可以操作该引用指向的堆内容  形参改变引用 不会影响实参
	 * @param a
	 * @param b
	 */
	private static void swapDemo(Demo a, Demo b) {
//		Demo t = a;
//		a = b;
//		b = t;
		a.setName("b");
		b.setName("a");
		System.out.println("swap a=" + a.getName() + ",b=" + b.getName());
	}

	
	/** Integer -128 到 127 缓存地址是一个 ；new Integer会申请新的内存空间
	 * 反射 改变final变量 需setAccessible true
	 * @param a
	 * @param b
	 * @throws Exception
	 */
	private static void swap(Integer a, Integer b) throws Exception {
//		Integer t = a;
//		a = b;
//		b = t;
//		System.out.println("swap a=" + a + ",b=" + b);
		Integer t = new Integer(b.intValue());
		Field field = Integer.class.getDeclaredField("value");
		field.setAccessible(true);
		System.out.println(a);
		System.out.println(b);
		System.out.println(t);
		System.out.println(a==b);
		System.out.println(a==t);
		field.set(b, a.intValue());
		field.set(a, t);
		
		System.out.println("swap a=" + a + ",b=" + b);
	}
}
