package com.heartforecast.domain.forecast.domain.repository;

import com.heartforecast.domain.forecast.domain.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {
}
