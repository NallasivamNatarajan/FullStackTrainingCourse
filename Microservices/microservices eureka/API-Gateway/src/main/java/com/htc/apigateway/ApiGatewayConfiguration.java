package com.htc.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/books/**").uri("lb://book-service"))
				.route(p -> p.path("/books-new/**").filters(f -> f.rewritePath("/books-new/(?<segment>.*)", "/books/${segment}")).uri("lb://book-service"))
				.route(p -> p.path("/ratings/**").uri("lb://rating-service"))
				.build();
	}

}
