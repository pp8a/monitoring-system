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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@Tag(name = "Measurement Units", description = "Endpoints for managing measurement units")
@RestController
@RequestMapping("/measurement-units")
@RequiredArgsConstructor
public class MeasurementUnitController {
	
	private final MeasurementUnitService measurementUnitService;
	
	@Operation(summary = "Get all measurement units", 
			description = "Retrieves a list of all available measurement units.")
    @ApiResponse(responseCode = "200", description = "List of measurement units retrieved successfully",
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = MeasurementUnitDTO.class)))
	@GetMapping
    public ResponseEntity<List<MeasurementUnitDTO>> getAllMeasurementUnits() {
        return ResponseEntity.ok(measurementUnitService.getAllMeasurementUnits());
    }
	
	@Operation(summary = "Get a measurement unit by name", description = "Retrieves a specific measurement unit by its name.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Measurement unit found",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = MeasurementUnitDTO.class))),
        @ApiResponse(responseCode = "404", description = "Measurement unit not found")
    })
	@GetMapping("/{name}")
    public ResponseEntity<Optional<MeasurementUnitDTO>> getMeasurementUnitByName(
    		@Parameter(description = "Name of the measurement unit", required = true) @PathVariable String name) {
        return ResponseEntity.ok(measurementUnitService.getMeasurementUnitByName(name));
    }

}
