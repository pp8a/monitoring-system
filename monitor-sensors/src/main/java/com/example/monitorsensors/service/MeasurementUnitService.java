package com.example.monitorsensors.service;

import java.util.List;
import java.util.Optional;

import com.example.monitorsensors.dto.MeasurementUnitDTO;

public interface MeasurementUnitService {
	List<MeasurementUnitDTO> getAllMeasurementUnits();
	Optional<MeasurementUnitDTO> getMeasurementUnitByName(String name);
}
