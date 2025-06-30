package com.heartForecast.domain.statistic.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import com.heartForecast.domain.statistic.presentation.dto.response.DateTempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticReader {

  private final ForecastRecordRepository forecastRecordRepository;

  public List<DateTempResponse> getDailyAverageTemperature(Child child, LocalDate startDate, LocalDate endDate) {
    return forecastRecordRepository.findDailyAverageTemperature(child, startDate, endDate);
  }
}
