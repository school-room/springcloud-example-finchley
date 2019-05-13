package com.eugene.springcloud.example.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ExampleAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleAccountApplication.class, args);
	}
}
