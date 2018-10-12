package com.cyf.test.id;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderIncrImpl implements OrderService{
	
	private AtomicInteger num = new AtomicInteger();
			

	@Override
	public String getOrderNo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date())+num.getAndIncrement();
	}

}
