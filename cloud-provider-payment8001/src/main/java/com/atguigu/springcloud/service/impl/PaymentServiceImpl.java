package com.atguigu.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.Dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentMapper paymentMapper;
	
	@Override
	public int insert(Payment payment) {
		return paymentMapper.insertPayment(payment);
	}

	@Override
	public Payment select(int id) {
		return paymentMapper.selectPaymentById(id);
	}

}
