package com.eugene.springcloud.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ExampleZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleZuulApplication.class, args);
	}
}
