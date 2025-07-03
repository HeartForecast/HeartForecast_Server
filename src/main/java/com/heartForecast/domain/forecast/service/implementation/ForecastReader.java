package com.heartForecast.domain.forecast.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecast.domain.repository.ForecastRepository;
import com.heartForecast.domain.forecast.exception.ForecastNotFoundException;
import com.heartForecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ForecastReader {

  private final ForecastRepository forecastRepository;
  private final ForecastRecordRepository forecastRecordRepository;

  public Forecast findByChild(Long id, Child child) {
    return forecastRepository.findByIdAndChild(id, child)
        .orElseThrow(ForecastNotFoundException::new);
  }

  public List<Forecast> findAllByChild(Child child) {
    return forecastRepository.findByChild(child);
  }

  public List<Forecast> findByDateAndChild(LocalDate date, Child child) {
    return forecastRepository.findByDateAndChild(date, child);
  }

  public boolean existsByForecast(Forecast forecast) {
    return forecastRecordRepository.existsByForecast(forecast);
  }
}
