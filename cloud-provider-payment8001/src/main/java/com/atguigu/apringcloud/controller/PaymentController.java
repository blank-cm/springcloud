package com.atguigu.apringcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.apringcloud.entities.CommonResult;
import com.atguigu.apringcloud.entities.Payment;
import com.atguigu.apringcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice;
	@Value("${server.port}")
	private String port;
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@GetMapping("/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") int id){
		Payment payment = paymentservice.getPayment(id);
		if(payment!=null){
			return new CommonResult<Payment>(200, "查询成功:--"+port, payment);
		}else{
			return new CommonResult<>(444, "没有对应记录");
		}
	}
	/**
	 * 插入数据
	 * @param payment
	 * @return
	 */
	@PostMapping("/payment/create")
	public CommonResult insert(Payment payment){
		int index = paymentservice.insert(payment);
		log.info("**************插入结果"+index);
		if(index>0){
			return new CommonResult<>(200, "插入成功",index);
		}else{
			return new CommonResult<>(333, "插入失败");
		}
	}
}
