package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
//@DefaultProperties(defaultFallback="globalFallback")
public class PaymentHystrixController {
	@Resource
	private PaymentHystrixService paymentHystrixService;
	
	@RequestMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") int id){
		return paymentHystrixService.paymentInfo_OK(id);
	}
	
	@RequestMapping("/consumer/payment/hystrix/timeout/{id}")
	/*@HystrixCommand(fallbackMethod="paymentInfo_TimeoutFallback",commandProperties={
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
	})*/
	public String paymentInfo_Timeout(@PathVariable("id") int id){
		return paymentHystrixService.paymentInfo_Timeout(id);
	}
	
	/*public String paymentInfo_TimeoutFallback(int id){
		return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
	}*/
	
	public String globalFallback(){
		return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
	}
}
