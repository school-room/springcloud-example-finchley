package com.eugene.springcloud.example.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExampleRabbitmqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleRabbitmqProducerApplication.class, args);
	}
}
