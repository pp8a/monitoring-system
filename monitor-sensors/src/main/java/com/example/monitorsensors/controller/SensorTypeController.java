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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@Tag(name = "Sensor Types", description = "Endpoints for managing sensor types")
@RestController
@RequestMapping("/sensor-types")
@RequiredArgsConstructor
public class SensorTypeController {
	
	private final SensorTypeService sensorTypeService;
	
	@Operation(summary = "Get all sensor types", description = "Retrieves a list of all available sensor types.")
    @ApiResponse(responseCode = "200", description = "List of sensor types retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = SensorTypeDTO.class)))
	@GetMapping
	public ResponseEntity<List<SensorTypeDTO>> getAllSensorTypes() {
        return ResponseEntity.ok(sensorTypeService.getAllSensorTypes());
    }
	
	@Operation(summary = "Get a sensor type by name", description = "Retrieves a specific sensor type by its name.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sensor type found",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = SensorTypeDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sensor type not found")
    })
	@GetMapping("/{name}")
    public ResponseEntity<Optional<SensorTypeDTO>> getSensorTypeByName(
    		@Parameter(description = "Name of the sensor type", required = true) @PathVariable String name) {
        return ResponseEntity.ok(sensorTypeService.getSensorTypeByName(name));
    }
}
