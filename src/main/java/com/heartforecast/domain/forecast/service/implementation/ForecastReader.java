package com.heartforecast.domain.forecast.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecast.domain.repository.ForecastRepository;
import com.heartforecast.domain.forecast.exception.ForecastNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ForecastReader {

  private final ForecastRepository forecastRepository;

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
}
