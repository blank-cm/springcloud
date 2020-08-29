package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class ReceiveMessageController {
	@Value("${server.port}")
	public String port;
	@StreamListener(Sink.INPUT)
	public void getMessage(Message<String> message){
		System.out.println("消费者1号,----->接受到的消息: "+message.getPayload()+"\t  port: "+port);
	} 

}
