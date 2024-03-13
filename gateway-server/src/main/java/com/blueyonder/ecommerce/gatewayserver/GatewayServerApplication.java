package com.blueyonder.ecommerce.gatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
*/

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

/*	@Bean
	public RouteLocator routeLocator (RouteLocatorBuilder builder) {
		return builder.routes()
				// route unique id / name, path to identify, destination endpoint
				.route("user-service-route", r -> r.path("/api/v2/ecommerce/user/**")
						.uri("lb://user-service"))
				.route("product-category-service-route", r -> r.path("/api/v2/ecommerce/product/**" )
						.uri("lb://product-category-service"))
				.route("product-category-service-route", r -> r.path("/api/v2/ecommerce/category/**" )
						.uri("lb://product-category-service"))
				.build();
	}*/
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("user-service-route", r -> r
						.path("/api/v2/ecommerce/user/**")
						.uri("lb://USER-SERVICE"))
				.route("product-category-service-route", r -> r
						.path("/api/v2/ecommerce/product/**", "/api/v2/ecommerce/category/**")
						.uri("lb://PRODUCT-CATEGORY-SERVICE"))
				.build();
	}

}




