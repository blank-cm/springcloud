package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.lang.UUID;

@RestController
public class PaymentController {
	
	@Value("${server.port}")
	private String port;
	@GetMapping("/payment/consul")
	public String paymentConsul(){
		return "spring cloud condul:"+port+"\t\t "+UUID.randomUUID().toString();
	}
}
