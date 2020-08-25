package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentHystrixService{

	@Override
	public String paymentInfo_OK(int id) {
		return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
	}

	@Override
	public String paymentInfo_Timeout(int id) {
		return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
	}

}
