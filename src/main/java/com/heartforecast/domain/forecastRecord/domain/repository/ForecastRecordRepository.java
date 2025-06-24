package com.heartforecast.domain.forecastRecord.domain.repository;

import com.heartforecast.domain.forecastRecord.domain.ForecastRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRecordRepository extends JpaRepository<ForecastRecord, Long> {
}
