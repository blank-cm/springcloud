package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsulController {
	@Resource
	private RestTemplate restTemplate;
	private static final String URL_PAYMENT="http://consul-provider-payment";
	
	@GetMapping("/consumer/payment/consul")
	public String paymentInfo(){
		return restTemplate.getForObject(URL_PAYMENT+"/payment/consul",String.class);
	}
}
