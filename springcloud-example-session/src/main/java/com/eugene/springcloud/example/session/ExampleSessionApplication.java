package com.eugene.springcloud.example.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExampleSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSessionApplication.class, args);
	}
}
