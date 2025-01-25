package com.htc.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LogFilter {
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain){
		logger.info("Received Request" + exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
