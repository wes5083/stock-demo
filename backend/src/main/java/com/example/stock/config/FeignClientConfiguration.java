package com.example.stock.config;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FeignAutoConfiguration.class)
@Configuration
public class FeignClientConfiguration {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
