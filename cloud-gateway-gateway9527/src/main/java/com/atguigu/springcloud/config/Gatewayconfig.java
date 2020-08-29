package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Gatewayconfig {
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		Builder routes = builder.routes();
		routes.route("path_route_atguigu", 
				r->r.path("/guonei")
					.uri("http://news.baidu.com"));
		routes.route("path_route_atguigu2", 
						r->r.path("/guoji")
							.uri("http://news.baidu.com"));
		return routes.build();
	}
	

}
