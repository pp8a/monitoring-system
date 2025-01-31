package com.example.monitorsensors.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.monitorsensors.dto.MeasurementUnitDTO;
import com.example.monitorsensors.service.MeasurementUnitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/measurement-units")
@RequiredArgsConstructor
public class MeasurementUnitController {
	
	private final MeasurementUnitService measurementUnitService;
	
	@GetMapping
    public ResponseEntity<List<MeasurementUnitDTO>> getAllMeasurementUnits() {
        return ResponseEntity.ok(measurementUnitService.getAllMeasurementUnits());
    }
	
	@GetMapping("/{name}")
    public ResponseEntity<Optional<MeasurementUnitDTO>> getMeasurementUnitByName(@PathVariable String name) {
        return ResponseEntity.ok(measurementUnitService.getMeasurementUnitByName(name));
    }

}
