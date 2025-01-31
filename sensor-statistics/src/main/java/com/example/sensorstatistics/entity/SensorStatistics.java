package com.example.sensorstatistics.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sensor_statistics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int totalSensors;

    @Column(nullable = false)
    private int temperatureSensors;

    @Column(nullable = false)
    private int humiditySensors;

    @Column(nullable = false)
    private int pressureSensors;

}
