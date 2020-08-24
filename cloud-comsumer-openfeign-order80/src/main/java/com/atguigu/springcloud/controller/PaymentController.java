package com.atguigu.springcloud.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentService;

@RestController
public class PaymentController {
	@Resource
	private PaymentService paymentService;
	
	@RequestMapping("/consumer/payment/get/{id}")
	public CommonResult getPayment(@PathVariable("id") int id){
		return paymentService.getPayment(id);
	}
	
	@GetMapping("/consumer/payment/feign/timeout")
	public String paymentTomeout(){
		return paymentService.paymentTomeout();
	}
}
