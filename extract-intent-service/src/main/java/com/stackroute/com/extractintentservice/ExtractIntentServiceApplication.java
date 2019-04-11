package com.stackroute.com.extractintentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExtractIntentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtractIntentServiceApplication.class, args);
	}

}
