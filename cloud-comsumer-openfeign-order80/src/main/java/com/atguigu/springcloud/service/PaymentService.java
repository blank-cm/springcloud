package com.atguigu.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.springcloud.entities.CommonResult;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentService {
	@RequestMapping("/payment/get/{id}")
	CommonResult getPayment(@PathVariable("id") int id);
	
	@GetMapping("/payment/feign/timeout")
	String paymentTomeout();
}
