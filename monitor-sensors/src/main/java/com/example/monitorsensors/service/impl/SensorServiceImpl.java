package com.example.monitorsensors.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monitorsensors.dto.SensorDTO;
import com.example.monitorsensors.entity.Sensor;
import com.example.monitorsensors.exception.custom.EntityNotFoundException;
import com.example.monitorsensors.mapper.SensorMapper;
import com.example.monitorsensors.repository.SensorRepository;
import com.example.monitorsensors.service.SensorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SensorServiceImpl implements SensorService {	
	private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

	@Override
	public SensorDTO createSensor(SensorDTO dto) {
		Sensor sensor = sensorMapper.toEntity(dto);
		return sensorMapper.toDto(sensorRepository.save(sensor));
	}

	@Override
	public SensorDTO updateSensor(Long id, SensorDTO dto) {
		Sensor existingSensor = sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor not found"));

        sensorMapper.updateSensorFromDto(dto, existingSensor);

        return sensorMapper.toDto(sensorRepository.save(existingSensor));		
	}

	@Override
	public void deleteSensor(Long id) {
		if (!sensorRepository.existsById(id)) {
            throw new EntityNotFoundException("Sensor not found");
        }
        sensorRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SensorDTO> getAllSensors() {
		return sensorRepository.findAll().stream()
                .map(sensorMapper::toDto)
                .collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true) 
	public List<SensorDTO> searchSensors(String name, String model) {
		return sensorRepository.findByNameContainingIgnoreCaseAndModelContainingIgnoreCase(name, model).stream()
	            .map(sensorMapper::toDto)
	            .collect(Collectors.toList());
	}

}
