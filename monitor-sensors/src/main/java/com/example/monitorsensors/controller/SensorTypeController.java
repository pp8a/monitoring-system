package com.example.monitorsensors.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.monitorsensors.dto.SensorTypeDTO;
import com.example.monitorsensors.service.SensorTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sensor-types")
@RequiredArgsConstructor
public class SensorTypeController {
	
	private final SensorTypeService sensorTypeService;
	
	@GetMapping
	public ResponseEntity<List<SensorTypeDTO>> getAllSensorTypes() {
        return ResponseEntity.ok(sensorTypeService.getAllSensorTypes());
    }
	
	@GetMapping("/{name}")
    public ResponseEntity<Optional<SensorTypeDTO>> getSensorTypeByName(@PathVariable String name) {
        return ResponseEntity.ok(sensorTypeService.getSensorTypeByName(name));
    }
}
