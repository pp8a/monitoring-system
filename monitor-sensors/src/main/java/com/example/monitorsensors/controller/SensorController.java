package com.example.monitorsensors.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.monitorsensors.dto.SensorDTO;
import com.example.monitorsensors.service.SensorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {
	
	private final SensorService sensorService;
	
	@PostMapping
    public ResponseEntity<SensorDTO> createSensor(@Valid @RequestBody SensorDTO dto) {
        return ResponseEntity.ok(sensorService.createSensor(dto));
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<SensorDTO> updateSensor(@PathVariable Long id, @Valid @RequestBody SensorDTO dto) {
        return ResponseEntity.ok(sensorService.updateSensor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SensorDTO>> getAllSensors() {
        return ResponseEntity.ok(sensorService.getAllSensors());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SensorDTO>> searchSensors(@RequestParam String name, @RequestParam String model) {
        return ResponseEntity.ok(sensorService.searchSensors(name, model));
    }

}
