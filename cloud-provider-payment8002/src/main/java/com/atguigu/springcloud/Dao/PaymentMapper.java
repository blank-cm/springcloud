package com.atguigu.springcloud.Dao;


import com.atguigu.springcloud.entities.Payment;
public interface PaymentMapper {
	
	int insertPayment(Payment payment);
	
	Payment selectPaymentById(int id);
}
