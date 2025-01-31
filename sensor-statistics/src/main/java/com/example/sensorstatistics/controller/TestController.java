package com.example.sensorstatistics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sensorstatistics.client.MonitorSensorsClient;
import com.example.sensorstatistics.dto.SensorDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {
	private final MonitorSensorsClient monitorSensorsClient;
	
	@GetMapping("/test")
    public List<SensorDTO> testFeign() {
        return monitorSensorsClient.getAllSensors();
    }
}
