package com.atguigu.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Value("${server.port}")
	private String port;
	@GetMapping("/payment/get/{id}")
	public CommonResult getPayment(@PathVariable("id") int id){
		Payment payment = paymentService.select(id);
		if(payment!=null){
			return new CommonResult(200, "查询成功----"+port, payment);
		}else{
			return new CommonResult(444,"查询失败",null);
		}
	}
	@PostMapping("/payment/insert")
	public CommonResult insert(@RequestBody Payment payment){
		int result = paymentService.insert(payment);
		log.info("插入一条数据-----"+result);
		if(result>0){
			return new CommonResult(200, "插入数据成功----"+port, result);
		}else{
			return new CommonResult(444, "插入数据失败", null);
		}
	}
	
	@GetMapping("/payment/lb")
	public String getPaymentLb(){
		return port;
	}
	
	@GetMapping("/payment/feign/timeout")
	public String paymentTomeout(){
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return port;
	}
}
