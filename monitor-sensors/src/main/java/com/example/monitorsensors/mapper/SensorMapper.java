package com.example.monitorsensors.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.example.monitorsensors.dto.SensorDTO;
import com.example.monitorsensors.entity.Sensor;


@Mapper(componentModel = "spring", uses = {SensorTypeMapper.class, MeasurementUnitMapper.class})
public interface SensorMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "type", source = "type", qualifiedByName = "mapTypeId")  // ID - SensorType
    @Mapping(target = "unit", source = "unit", qualifiedByName = "mapUnitId")  // ID - MeasurementUnit
    Sensor toEntity(SensorDTO dto);

    @Mapping(target = "type", source = "type", qualifiedByName = "mapTypeToId") // SensorType - ID
    @Mapping(target = "unit", source = "unit", qualifiedByName = "mapUnitToId") // MeasurementUnit - ID
    SensorDTO toDto(Sensor entity);
    
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "type", source = "type", qualifiedByName = "mapTypeId")
    @Mapping(target = "unit", source = "unit", qualifiedByName = "mapUnitId")
    @Mapping(target = "rangeFrom", source = "rangeFrom")
    @Mapping(target = "rangeTo", source = "rangeTo")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "description", source = "description")
    void updateSensorFromDto(SensorDTO dto, @MappingTarget Sensor entity);
    
    
}
