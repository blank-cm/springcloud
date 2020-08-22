package com.atguigu.apringcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.apringcloud.entities.Payment;
import com.atguigu.apringcloud.mapper.PaymentMapper;
import com.atguigu.apringcloud.service.PaymentService;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentMapper paymentMapper;
	
	@Override
	public int insert(Payment payment) {
		return paymentMapper.insPayment(payment);
	}

	@Override
	public Payment getPayment(int id) {
		return paymentMapper.selById(id);
	}

}
