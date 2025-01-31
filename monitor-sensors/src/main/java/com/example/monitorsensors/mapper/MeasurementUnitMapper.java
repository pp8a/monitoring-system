package com.example.monitorsensors.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.example.monitorsensors.dto.MeasurementUnitDTO;
import com.example.monitorsensors.entity.MeasurementUnit;

@Mapper(componentModel = "spring")
public interface MeasurementUnitMapper {
	MeasurementUnit toEntity(MeasurementUnitDTO dto);
    MeasurementUnitDTO toDto(MeasurementUnit entity);
    
    @Named("mapUnitId")
    default MeasurementUnit mapUnitId(Integer id) {
        if (id == null) return null;
        MeasurementUnit unit = new MeasurementUnit();
        unit.setId(id);
        return unit;
    }

    @Named("mapUnitToId")
    default Integer mapUnitToId(MeasurementUnit unit) {
        return unit != null ? unit.getId() : null;
    }
}
