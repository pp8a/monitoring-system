package com.example.monitorsensors.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.example.monitorsensors.dto.SensorTypeDTO;
import com.example.monitorsensors.entity.SensorType;

@Mapper(componentModel = "spring")
public interface SensorTypeMapper {
	SensorType toEntity(SensorTypeDTO dto);
    SensorTypeDTO toDto(SensorType entity);
    
    @Named("mapTypeId")
    default SensorType mapTypeId(Integer id) {
        if (id == null) return null;
        SensorType type = new SensorType();
        type.setId(id);
        return type;
    }

    @Named("mapTypeToId")
    default Integer mapTypeToId(SensorType type) {
        return type != null ? type.getId() : null;
    }
}
