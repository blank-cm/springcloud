package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
	int insert(Payment payment);
	
	Payment select(int id);
}
