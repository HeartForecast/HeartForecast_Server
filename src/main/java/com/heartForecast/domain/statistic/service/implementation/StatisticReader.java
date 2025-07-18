package com.heartForecast.domain.statistic.service.implementation;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.forecastRecord.domain.repository.ForecastRecordRepository;
import com.heartForecast.domain.statistic.presentation.dto.response.DateTempResponse;
import com.heartForecast.domain.statistic.presentation.dto.response.TimeZoneEmotionCountResponse;
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

  public List<TimeZoneEmotionCountResponse> getEmotionCountByTimeZone(Child child, LocalDate startDate, LocalDate endDate) {
    return forecastRecordRepository.findEmotionCountByTimeZone(child, startDate, endDate);
  }

  public List<Object[]> countEmotionGroupByName(Child child, LocalDate startDate, LocalDate endDate) {
    return forecastRecordRepository.countEmotionsByNameInPeriod(child, startDate, endDate);
  }

  public Double getAverageTemperature(Child child, LocalDate startDate, LocalDate endDate) {
    return forecastRecordRepository.findAverageTemperatureByChildAndDateRange(child, startDate, endDate);
  }
}
