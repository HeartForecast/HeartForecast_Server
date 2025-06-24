package com.heartforecast.domain.forecastRecord.service.implementation;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecastRecord.domain.value.TimeZone;
import com.heartforecast.domain.forecast.exception.ForecastAlreadyExistsException;
import com.heartforecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import com.heartforecast.domain.forecastRecord.exception.ForecastRecordAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ForecastRecordValidator {

  private final ForecastRecordRepository forecastRecordRepository;

  public void existsByForecast(Forecast forecast) {
    if (forecastRecordRepository.existsByForecast(forecast)) throw new ForecastRecordAlreadyExistsException();
  }

  public void existsByChildAndDateAndTimeZone(Child child, LocalDate date, TimeZone timeZone) {
    if (forecastRecordRepository.existsByChildAndDateAndTimeZone(child, date, timeZone)) throw new ForecastAlreadyExistsException();
  }
}