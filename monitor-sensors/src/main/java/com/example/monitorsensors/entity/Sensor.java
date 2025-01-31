package com.example.monitorsensors.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 15)
    private String model;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private SensorType type;

    @ManyToOne
    @JoinColumn(name = "unit")
    private MeasurementUnit unit;

    @Column(nullable = false)
    private Integer rangeFrom;

    @Column(nullable = false)
    private Integer rangeTo;

    @Column(length = 40)
    private String location;

    @Column(length = 200)
    private String description;

}
