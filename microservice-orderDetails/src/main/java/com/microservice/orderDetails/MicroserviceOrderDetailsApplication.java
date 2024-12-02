package com.microservice.orderDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceOrderDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOrderDetailsApplication.class, args);
	}

}
