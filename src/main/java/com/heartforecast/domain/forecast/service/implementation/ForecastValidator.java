package com.heartforecast.domain.forecast.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.forecast.domain.repository.ForecastRepository;
import com.heartforecast.domain.forecast.domain.value.TimeZone;
import com.heartforecast.domain.forecast.exception.ForecastAlreadyExistsException;
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
