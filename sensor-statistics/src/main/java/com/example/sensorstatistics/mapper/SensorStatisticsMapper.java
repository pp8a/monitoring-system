package com.example.sensorstatistics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.example.sensorstatistics.dto.SensorStatisticsDTO;
import com.example.sensorstatistics.entity.SensorStatistics;

@Mapper(componentModel = "spring")
public interface SensorStatisticsMapper {
    SensorStatisticsMapper INSTANCE = Mappers.getMapper(SensorStatisticsMapper.class);

    SensorStatisticsDTO toDto(SensorStatistics entity);
    
    @Mapping(target = "id", ignore = true)
    SensorStatistics toEntity(SensorStatisticsDTO dto);
    
    @Mapping(target = "id", ignore = true) 
    void updateEntityFromDto(SensorStatisticsDTO dto, @MappingTarget SensorStatistics entity);

}
