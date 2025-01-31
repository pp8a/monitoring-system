package com.example.monitorsensors.mapper;

import org.mapstruct.Mapper;

import com.example.monitorsensors.dto.UserDTO;
import com.example.monitorsensors.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User toEntity(UserDTO dto);
    UserDTO toDto(User entity);
}
