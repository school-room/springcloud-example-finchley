package com.eugene.springcloud.example.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringCloud Example Gateway RESTful APIs")
                .description("内部学习SpringCloud Gateway的RESTful APIs")
                .contact(new Contact("Eugene", "http://www.github.com/eugeneheen", "eugeneheen_chen@126.com"))
                .version("1.0")
                .build();
    }
}
