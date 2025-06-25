package com.heartForecast.domain.forecastRecord.domain.repository;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecastRecord.domain.value.TimeZone;
import com.heartForecast.domain.forecastRecord.domain.ForecastRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRecordRepository extends JpaRepository<ForecastRecord, Long> {
  Optional<ForecastRecord> findByIdAndChild(Long id, Child child);
  List<ForecastRecord> findByChild(Child child);
  List<ForecastRecord> findByDateAndChild(LocalDate date, Child child);
  boolean existsByForecast(Forecast forecast);
  boolean existsByChildAndDateAndTimeZone(Child child, LocalDate date, TimeZone timeZone);
}
