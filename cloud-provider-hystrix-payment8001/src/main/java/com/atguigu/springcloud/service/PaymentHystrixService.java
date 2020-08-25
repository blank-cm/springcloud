package com.atguigu.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

@Service
public class PaymentHystrixService {

	public String paymentInfo_OK(int id){
		return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t O(∩_∩)O哈哈~";
	}
	
	@HystrixCommand(fallbackMethod="paymentInfo_TimeOutHandler",commandProperties={
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
	})
	public String paymentInfo_Timeout(int id){
		//int a = 10/0;
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池"+Thread.currentThread().getName()+"paymentInfo_Timeout,id:"+id+"\t O(∩_∩)O哈哈~";
	}
	
	public String paymentInfo_TimeOutHandler(int id){
		return "线程池:  "+Thread.currentThread().getName()+"  8001系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
	}
	//服务熔断
	@HystrixCommand(fallbackMethod="paymentCircuitBreaker_fallback",commandProperties={
			@HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")//失败率达到多少跳闸
	})
	public String paymentCircuitBreaker(int id){
		if(id<0){
			throw new RuntimeException();
		}
		String uuid = IdUtil.simpleUUID();
		return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " +uuid;
	}
	
	public String paymentCircuitBreaker_fallback(int id){
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
	
	
}
