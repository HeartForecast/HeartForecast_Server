package com.heartForecast.domain.forecast.domain.repository;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecast.domain.value.TimeZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {
  Optional<Forecast> findByIdAndChild(Long id, Child child);
  List<Forecast> findByChild(Child child);
  List<Forecast> findByDateAndChild(LocalDate date, Child child);
  boolean existsByChildAndDateAndTimeZone(Child child, LocalDate date, TimeZone timeZone);
}
