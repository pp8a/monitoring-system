package com.example.monitorsensors.service;

import java.util.List;

import com.example.monitorsensors.dto.SensorDTO;

public interface SensorService {
	SensorDTO createSensor(SensorDTO dto);
    SensorDTO updateSensor(Long id, SensorDTO dto);
    void deleteSensor(Long id);
    List<SensorDTO> getAllSensors();
    List<SensorDTO> searchSensors(String name, String model);
}
