package com.eugene.springcloud.example.rabbitmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExampleRabbitConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleRabbitConsumerApplication.class, args);
	}
}
