package com.heartForecast.domain.statistic.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.statistic.presentation.dto.response.DateTempResponse;
import com.heartForecast.domain.statistic.service.implementation.StatisticReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryStatisticService {

  private final StatisticReader statisticReader;
  private final QueryChildService queryChildService;

  public List<DateTempResponse> getDailyAverageTemperature(Long childId, LocalDate startDate, LocalDate endDate) {
    Child child = queryChildService.readOne(childId);

    return statisticReader.getDailyAverageTemperature(child, startDate, endDate);
  }
}
