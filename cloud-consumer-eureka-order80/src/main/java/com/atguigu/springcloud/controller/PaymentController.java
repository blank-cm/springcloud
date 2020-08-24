package com.atguigu.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;

@RestController
public class PaymentController {
	public static final String PAYMENT_URL = "http://cloud-payment-service";
	@Resource
	private RestTemplate restTemplate;
	@Resource
	private LoadBalancer loadBalancer;
	@Resource
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult getPayment(@PathVariable("id") int id){
		return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
	}
	
	@GetMapping("/consumer/payment/insert")
	public CommonResult insert(Payment payment){
		return restTemplate.postForObject(PAYMENT_URL+"/payment/insert", payment, CommonResult.class);
	}
	
	@GetMapping("/consumer/payment/getForEntity/get/{id}")
	public CommonResult getPayment2(@PathVariable("id") int id){
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
		if(entity.getStatusCode().is2xxSuccessful()){
			return entity.getBody();
		}else{
			return new CommonResult(444, "失败", null);
		}
	}
	
	@GetMapping("/consumer/payment/lb")
	public String getPaymentLb(){
		List<ServiceInstance> services = discoveryClient.getInstances("cloud-payment-service");
		if(services==null||services.size()<=0){
			return "error message";
		}
		ServiceInstance instance = loadBalancer.instance(services);
		String result = restTemplate.getForObject(instance.getUri()+"/payment/lb", String.class);
		return result;
	}
}
