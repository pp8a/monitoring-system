package com.example.monitorsensors.service;

import java.util.Optional;

import com.example.monitorsensors.dto.UserDTO;

public interface UserService {
	Optional<UserDTO> getUserByUsername(String username);
}
