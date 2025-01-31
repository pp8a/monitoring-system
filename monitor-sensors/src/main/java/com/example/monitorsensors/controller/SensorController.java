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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sensors", description = "API for managing sensors")
@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {
	
	private final SensorService sensorService;
	
	@Operation(summary = "Create a new sensor", description = "Creates a new sensor and returns its details.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sensor created successfully",
                content = @Content(schema = @Schema(implementation = SensorDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
	@PostMapping
    public ResponseEntity<SensorDTO> createSensor(@Valid @RequestBody SensorDTO dto) {
        return ResponseEntity.ok(sensorService.createSensor(dto));
    }
	
	@Operation(summary = "Update an existing sensor", description = "Updates the sensor with the given ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sensor updated successfully",
                content = @Content(schema = @Schema(implementation = SensorDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sensor not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
	@PutMapping("/{id}")
    public ResponseEntity<SensorDTO> updateSensor(
    		@Parameter(description = "ID of the sensor to be updated") @PathVariable Long id, 
    		@Valid @RequestBody SensorDTO dto) {
        return ResponseEntity.ok(sensorService.updateSensor(id, dto));
    }
		
	@Operation(summary = "Delete a sensor", description = "Deletes the sensor with the given ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Sensor deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Sensor not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(
    		@Parameter(description = "ID of the sensor to be deleted") @PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }
	
	@Operation(summary = "Get all sensors", description = "Retrieves a list of all available sensors.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of sensors retrieved",
                content = @Content(schema = @Schema(implementation = SensorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<List<SensorDTO>> getAllSensors() {
        return ResponseEntity.ok(sensorService.getAllSensors());
    }
	
	@Operation(summary = "Search for sensors", description = "Searches for sensors by name and model.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of matching sensors",
                content = @Content(schema = @Schema(implementation = SensorDTO.class)))
    })
    @GetMapping("/search")
    public ResponseEntity<List<SensorDTO>> searchSensors(
    		@Parameter(description = "Sensor name to search for") @RequestParam String name, 
    		@Parameter(description = "Sensor model to search for") @RequestParam String model) {
        return ResponseEntity.ok(sensorService.searchSensors(name, model));
    }

}
