package com.heartforecast.domain.SpecialForecastRecord.domain.repository;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialForecastRecordRepository extends JpaRepository<SpecialForecastRecord, Long> {
  boolean existsBySpecialForecast(SpecialForecast specialForecast);
}
