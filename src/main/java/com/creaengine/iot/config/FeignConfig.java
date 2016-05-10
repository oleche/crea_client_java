package com.creaengine.iot.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Created by oleche on 11/14/15.
 */
@Configuration
@EnableFeignClients(basePackages = "com.creaengine.iot.http")
public class FeignConfig {
    @Bean
    public HttpMessageConverter httpMessageConverter(){
        return new FormHttpMessageConverter();
    }
}
