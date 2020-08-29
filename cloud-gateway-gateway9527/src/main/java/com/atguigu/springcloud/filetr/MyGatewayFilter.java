package com.atguigu.springcloud.filetr;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter,Ordered{

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String name = exchange.getRequest().getQueryParams().getFirst("username");
		if(name==null||name.equals("")){
			log.info("用户名不能为空");
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

}
