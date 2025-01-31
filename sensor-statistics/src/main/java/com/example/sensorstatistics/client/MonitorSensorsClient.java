package com.example.sensorstatistics.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sensorstatistics.config.FeignConfig;
import com.example.sensorstatistics.dto.SensorDTO;

@FeignClient(name = "monitor-sensors", url = "${MONITOR_SENSORS_URL:defaultUrl}", configuration = FeignConfig.class)
public interface MonitorSensorsClient {
	
	@GetMapping("/sensors")
    List<SensorDTO> getAllSensors();

}
