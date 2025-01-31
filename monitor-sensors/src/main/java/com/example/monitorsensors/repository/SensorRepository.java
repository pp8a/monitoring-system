package com.example.monitorsensors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.monitorsensors.entity.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
	/**
	 * Finds a list of sensors where the name and model contain the given search terms,
	 * ignoring case sensitivity.
	 *
	 * - `findBy` → Spring Data JPA interprets this as a database query.
	 * - `NameContainingIgnoreCase` → Searches for a partial match in the `name` field (ILIKE in PostgreSQL).
	 * - `And` → Combines the two conditions (`name` and `model`).
	 * - `ModelContainingIgnoreCase` → Searches for a partial match in the `model` field (ILIKE in PostgreSQL).
	 *
	 * @param name  The search term for the sensor name (case-insensitive, partial match).
	 * @param model The search term for the sensor model (case-insensitive, partial match).
	 * @return A list of sensors that match both search criteria.
	 */
	List<Sensor> findByNameContainingIgnoreCaseAndModelContainingIgnoreCase(String name, String model);
}
