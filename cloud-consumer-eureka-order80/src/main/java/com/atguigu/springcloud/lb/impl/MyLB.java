package com.atguigu.springcloud.lb.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import com.atguigu.springcloud.lb.LoadBalancer;

@Component
public class MyLB implements LoadBalancer{
	private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);
	@Override
	public ServiceInstance instance(List<ServiceInstance> services) {
		int index = getAndIncrement()%services.size();
			ServiceInstance service = services.get(index);
			return service;
	}
	
	public final int getAndIncrement(){
		int current;
		int next;
		do {
			current = nextServerCyclicCounter.get();
			next = current>2147483647?0:current+1;
		} while (!nextServerCyclicCounter.compareAndSet(current, next));
		System.out.println("*************第几次访问:"+next);
		return next;
	}
	
}
