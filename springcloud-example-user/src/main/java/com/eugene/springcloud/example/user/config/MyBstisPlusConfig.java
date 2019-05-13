package com.eugene.springcloud.example.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述类提供的功能
 *
 * @author Eugene
 * 2018-12-04 17:38
 */
@Configuration
public class MyBstisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
