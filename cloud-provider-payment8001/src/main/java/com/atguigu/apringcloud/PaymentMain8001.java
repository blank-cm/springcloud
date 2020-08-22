package com.atguigu.apringcloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.apringcloud.mapper")
public class PaymentMain8001 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8001.class, args);
	}

}
