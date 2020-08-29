package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/payment/nacos/{id}")
	public String getPaymentPort(@PathVariable("id") int id){
		return "nacos registry, serverPort: "+ port+"\t id"+id;
	}
}
