package com.oneHealth.APIGateway.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
//        		.route("default-path", r -> r.path("/").uri("lb://OneHealth-Default"))
                .route("user-service", r -> r.path("/users/**").uri("lb://OneHealth-User"))
                .route("PatientCheckout", r -> r.path("/patients/**").uri("lb://PatientCheckout"))
                // Add more routes for other microservices as needed
                .build();
    }
}
