package com.example.sensorstatistics.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorStatisticsDTO {
	
    private LocalDate date;
    private int totalSensors;
    private int temperatureSensors;
    private int humiditySensors;
    private int pressureSensors;

}
