package com.example.sensorstatistics.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class FeignConfig {
	
	@Value("${MONITOR_SENSORS_USERNAME:defaultAdmin}") 
    private String username;

    @Value("${MONITOR_SENSORS_PASSWORD:defaultPass}")
    private String password;

    @Bean
    RequestInterceptor basicAuthRequestInterceptor() {
    	log.info("Feign Basic Auth: Using username {}", username);
        return requestTemplate -> {
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
            String authHeader = "Basic " + new String(encodedAuth);
            requestTemplate.header("Authorization", authHeader);
        };
    }

}
