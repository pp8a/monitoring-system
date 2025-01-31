package com.example.monitorsensors.service;

import java.util.List;
import java.util.Optional;

import com.example.monitorsensors.dto.SensorTypeDTO;

public interface SensorTypeService {
	List<SensorTypeDTO> getAllSensorTypes();
	Optional<SensorTypeDTO> getSensorTypeByName(String name);

}
