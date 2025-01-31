package com.example.sensorstatistics.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sensorstatistics.entity.SensorStatistics;

@Repository
public interface SensorStatisticsRepository extends JpaRepository<SensorStatistics, Long> {
	List<SensorStatistics> findByDateBetween(LocalDate startDate, LocalDate endDate);
	Optional<SensorStatistics> findByDate(LocalDate date);
}
