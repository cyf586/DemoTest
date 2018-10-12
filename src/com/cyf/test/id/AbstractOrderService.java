package com.cyf.test.id;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractOrderService implements OrderService {
	
	static int num = 0;
	
	public static String getOrderNoStatic() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date())+num++;
	}

	@Override
	public String getOrderNo() {
		return getOrderNoStatic();
	}

}
