package com.atguigu.apringcloud.service;


import com.atguigu.apringcloud.entities.Payment;

public interface PaymentService {
	int insert(Payment payment);
	
	Payment getPayment(int id);
}
