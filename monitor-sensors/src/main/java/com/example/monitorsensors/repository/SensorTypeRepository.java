package com.example.monitorsensors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.monitorsensors.entity.SensorType;
import java.util.Optional;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Integer> {
	Optional<SensorType> findByName(String name);

}
