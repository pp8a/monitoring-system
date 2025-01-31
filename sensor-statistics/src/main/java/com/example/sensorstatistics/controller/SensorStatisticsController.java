package com.example.sensorstatistics.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sensorstatistics.dto.SensorStatisticsDTO;
import com.example.sensorstatistics.service.SensorStatisticsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "Sensor Statistics", description = "Endpoints for collecting and retrieving sensor statistics")
@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class SensorStatisticsController {
	
	private final SensorStatisticsService statisticsService;
	
	@Operation(summary = "Trigger statistics collection", 
            description = "Manually triggers the collection of sensor statistics. Useful for testing purposes.")
    @ApiResponse(responseCode = "200", description = "Statistics collection started successfully",
         content = @Content(mediaType = "application/json"))
	@PostMapping("/collect")
    public ResponseEntity<String> collectStatistics() {
        statisticsService.collectSensorStatistics();
        return ResponseEntity.ok("Statistics collection triggered successfully.");
    }
	
	@Operation(summary = "Retrieve statistics for a date range", 
            description = "Fetches stored sensor statistics within the specified time range.")
	@ApiResponses(value = {
     @ApiResponse(responseCode = "200", description = "Statistics retrieved successfully",
             content = @Content(mediaType = "application/json", 
             schema = @Schema(implementation = SensorStatisticsDTO.class))),
     @ApiResponse(responseCode = "400", description = "Invalid date range format"),
     @ApiResponse(responseCode = "404", description = "No statistics found for the given date range")
 })
	@GetMapping
    public ResponseEntity<List<SensorStatisticsDTO>> getStatistics(
    		@Parameter(description = "Start date (ISO format: YYYY-MM-DD)", required = true) 
    		@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
    		@Parameter(description = "End date (ISO format: YYYY-MM-DD)", required = true) 
    		@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<SensorStatisticsDTO> statistics = statisticsService.getStatistics(startDate, endDate);
        return ResponseEntity.ok(statistics);
    }

}
