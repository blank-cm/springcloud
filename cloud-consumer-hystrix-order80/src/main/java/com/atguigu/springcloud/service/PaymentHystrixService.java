package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value="CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback=PaymentFallbackService.class)
public interface PaymentHystrixService {
	
	@RequestMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") int id);
	
	@RequestMapping("/payment/hystrix/timeout/{id}")
	String paymentInfo_Timeout(@PathVariable("id") int id);
}
