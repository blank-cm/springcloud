package com.atguigu.springcloud.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.atguigu.springcloud.service.IMessageProvider;
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider{
	@Resource
	private MessageChannel output;
	@Override
	public String send() {
		String message = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(message).build());
		return null;
	}

}
