package com.heartforecast.domain.forecast.domain.repository;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.forecast.domain.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {
  Optional<Forecast> findByIdAndChild(Long id, Child child);
  List<Forecast> findByChild(Child child);
}
