package com.example.sensorstatistics.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {
    private String name;
    private String model;
    private Integer type;
    private Integer unit;
    private Integer rangeFrom;
    private Integer rangeTo;
    private String location;
    private String description;
}
