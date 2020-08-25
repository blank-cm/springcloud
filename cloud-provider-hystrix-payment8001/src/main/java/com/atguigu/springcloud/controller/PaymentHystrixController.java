package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.PaymentHystrixService;

@RestController
public class PaymentHystrixController {

	@Resource
	private PaymentHystrixService paymentHystrixService;
	
	@RequestMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") int id){
		return paymentHystrixService.paymentInfo_OK(id);
	}
	
	@RequestMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_Timeout(@PathVariable("id") int id){
		return paymentHystrixService.paymentInfo_Timeout(id);
	}
	
	@RequestMapping("/payment/hystrix/circuitbreaker/{id}")
	public String paymentCircuitBreaker(@PathVariable("id") int id){
		return paymentHystrixService.paymentCircuitBreaker(id);
	}
}
