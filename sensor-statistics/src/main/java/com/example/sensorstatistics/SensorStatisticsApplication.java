package com.example.sensorstatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "com.example.sensorstatistics.client")
public class SensorStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensorStatisticsApplication.class, args);
	}

}
