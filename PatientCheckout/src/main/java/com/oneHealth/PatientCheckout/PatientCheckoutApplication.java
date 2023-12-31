package com.oneHealth.PatientCheckout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class PatientCheckoutApplication {
	public static void main(String[] args) {
		SpringApplication.run(PatientCheckoutApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello From OneHealth-PatientCheckout";
	}
	
	 @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}
