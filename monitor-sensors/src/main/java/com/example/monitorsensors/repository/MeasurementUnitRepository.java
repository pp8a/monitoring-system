package com.example.monitorsensors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.monitorsensors.entity.MeasurementUnit;
import java.util.Optional;

@Repository
public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Integer> {
	Optional<MeasurementUnit> findByName(String name);

}
