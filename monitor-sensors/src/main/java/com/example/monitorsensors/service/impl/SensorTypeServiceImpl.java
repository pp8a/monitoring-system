package com.example.monitorsensors.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monitorsensors.dto.SensorTypeDTO;
import com.example.monitorsensors.mapper.SensorTypeMapper;
import com.example.monitorsensors.repository.SensorTypeRepository;
import com.example.monitorsensors.service.SensorTypeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SensorTypeServiceImpl implements SensorTypeService {
	private final SensorTypeRepository sensorTypeRepository;
    private final SensorTypeMapper sensorTypeMapper;	

	@Override
	public List<SensorTypeDTO> getAllSensorTypes() {
		return sensorTypeRepository.findAll().stream()
                .map(sensorTypeMapper::toDto)
                .collect(Collectors.toList());
	}

	@Override
	public Optional<SensorTypeDTO> getSensorTypeByName(String name) {
		return sensorTypeRepository.findByName(name).map(sensorTypeMapper::toDto);
	}
}
