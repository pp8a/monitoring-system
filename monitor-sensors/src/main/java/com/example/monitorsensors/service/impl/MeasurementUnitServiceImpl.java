package com.example.monitorsensors.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.monitorsensors.dto.MeasurementUnitDTO;
import com.example.monitorsensors.mapper.MeasurementUnitMapper;
import com.example.monitorsensors.repository.MeasurementUnitRepository;
import com.example.monitorsensors.service.MeasurementUnitService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MeasurementUnitServiceImpl implements MeasurementUnitService {	
	private final MeasurementUnitRepository measurementUnitRepository;
    private final MeasurementUnitMapper measurementUnitMapper;

	@Override
	public List<MeasurementUnitDTO> getAllMeasurementUnits() {
		return measurementUnitRepository.findAll().stream()
                .map(measurementUnitMapper::toDto)
                .collect(Collectors.toList());
	}

	@Override
	public Optional<MeasurementUnitDTO> getMeasurementUnitByName(String name) {
		return measurementUnitRepository.findByName(name).map(measurementUnitMapper::toDto);
	}

}
