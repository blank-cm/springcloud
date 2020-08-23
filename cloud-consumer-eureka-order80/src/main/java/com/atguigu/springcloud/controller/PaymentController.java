package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

@RestController
public class PaymentController {
	public static final String PAYMENT_URL = "http://cloud-payment-service";
	@Resource
	private RestTemplate restTemplate;
	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult getPayment(@PathVariable("id") int id){
		return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
	}
	@GetMapping("/consumer/payment/insert")
	public CommonResult insert(Payment payment){
		return restTemplate.postForObject(PAYMENT_URL+"/payment/insert", payment, CommonResult.class);
	}
}
