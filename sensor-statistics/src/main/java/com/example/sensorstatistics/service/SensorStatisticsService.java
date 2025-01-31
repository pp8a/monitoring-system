package com.example.sensorstatistics.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.sensorstatistics.client.MonitorSensorsClient;
import com.example.sensorstatistics.dto.SensorDTO;
import com.example.sensorstatistics.dto.SensorStatisticsDTO;
import com.example.sensorstatistics.entity.SensorStatistics;
import com.example.sensorstatistics.enums.SensorType;
import com.example.sensorstatistics.mapper.SensorStatisticsMapper;
import com.example.sensorstatistics.repository.SensorStatisticsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SensorStatisticsService {
	
	private final SensorStatisticsRepository statisticsRepository;
    private final SensorStatisticsMapper statisticsMapper;
    private final MonitorSensorsClient monitorSensorsClient;
    
    @Scheduled(cron = "0 0 2 * * ?")
    public void collectSensorStatistics() {
    	log.info("Starting sensor statistics collection...");

        try {
            List<SensorDTO> sensors = monitorSensorsClient.getAllSensors();
            log.info("Fetched {} sensors from Monitor-Sensors service.", sensors.size());
            
            SensorStatisticsDTO dto = buildSensorStatisticsDTO(sensors);
            
            SensorStatistics statistics = statisticsMapper.toEntity(dto);
            statisticsRepository.save(statistics);
            log.info("Sensor statistics saved successfully: {}", statistics);

        } catch (Exception e) {
            log.error("Error collecting sensor statistics: ", e);
        }
    }
    
    public List<SensorStatisticsDTO> getStatistics(LocalDate startDate, LocalDate endDate) {
        log.info("Fetching sensor statistics from {} to {}", startDate, endDate);
        return statisticsRepository.findByDateBetween(startDate, endDate)
                .stream()
                .map(statisticsMapper::toDto) // Используем маппер
                .collect(Collectors.toList());
    }
    
    private SensorStatisticsDTO buildSensorStatisticsDTO(List<SensorDTO> sensors) {
        Map<SensorType, Long> typeCounts = sensors.stream()
                .collect(Collectors.groupingBy(s -> SensorType.fromCode(s.getType()), Collectors.counting()));

        return new SensorStatisticsDTO(
                LocalDate.now(),
                sensors.size(),
                typeCounts.getOrDefault(SensorType.TEMPERATURE, 0L).intValue(),
                typeCounts.getOrDefault(SensorType.HUMIDITY, 0L).intValue(),
                typeCounts.getOrDefault(SensorType.PRESSURE, 0L).intValue()                
        );
    }
}
