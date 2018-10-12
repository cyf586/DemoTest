package com.cyf.test.id;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceImpl extends AbstractOrderService implements OrderService {
	
	static int num = 0;

	@Override
	public synchronized String getOrderNo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date())+num++;
	}

}
