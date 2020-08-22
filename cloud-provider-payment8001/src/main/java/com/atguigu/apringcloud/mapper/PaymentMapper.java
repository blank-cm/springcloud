package com.atguigu.apringcloud.mapper;

import org.apache.ibatis.annotations.Param;

import com.atguigu.apringcloud.entities.Payment;
public interface PaymentMapper {
	/**
	 * 根据ID查询流水信息
	 */
	Payment selById(@Param("id") int id);
	
	/**
	 * 插入一条流水
	 */
	int insPayment(Payment payment);
}
