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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class SensorStatisticsController {
	
	private final SensorStatisticsService statisticsService;
	
	/**
	 * Trigger statistics collection manually (e.g., for testing) 
	 */
	@PostMapping("/collect")
    public ResponseEntity<String> collectStatistics() {
        statisticsService.collectSensorStatistics();
        return ResponseEntity.ok("Statistics collection triggered successfully.");
    }
	
	/**
	 * Retrieve statistics for a specified time range
	 */
	@GetMapping
    public ResponseEntity<List<SensorStatisticsDTO>> getStatistics(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<SensorStatisticsDTO> statistics = statisticsService.getStatistics(startDate, endDate);
        return ResponseEntity.ok(statistics);
    }

}
