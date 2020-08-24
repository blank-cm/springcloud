package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="cloud-payment-service",configuration=MySelfRule.class)
public class OrderEureka80 {

	public static void main(String[] args) {
		SpringApplication.run(OrderEureka80.class, args);
	}

}
