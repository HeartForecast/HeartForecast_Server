package com.heartForecast.domain.forecast.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecast.domain.repository.ForecastRepository;
import com.heartForecast.domain.forecast.domain.value.TimeZone;
import com.heartForecast.domain.forecast.exception.ForecastAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ForecastValidator {

  private final ForecastRepository forecastRepository;

  public void existsByChildAndDateAndTimeZone(Child child, LocalDate date, TimeZone timeZone) {
    if(forecastRepository.existsByChildAndDateAndTimeZone(child, date, timeZone)) throw new ForecastAlreadyExistsException();
  }
}
