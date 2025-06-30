package com.heartForecast.domain.statistic.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.statistic.presentation.dto.response.DateTempResponse;
import com.heartForecast.domain.statistic.presentation.dto.response.EmotionCountResponse;
import com.heartForecast.domain.statistic.presentation.dto.response.TimeZoneEmotionCountResponse;
import com.heartForecast.domain.statistic.presentation.dto.response.TimeZoneEmotionGroupResponse;
import com.heartForecast.domain.statistic.service.implementation.StatisticReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

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

  public List<TimeZoneEmotionGroupResponse> getTimeZoneEmotionDistribution(Long childId, LocalDate startDate, LocalDate endDate) {
    Child child = queryChildService.readOne(childId);
    List<TimeZoneEmotionCountResponse> flatData = statisticReader.getEmotionCountByTimeZone(child, startDate, endDate);

    return flatData.stream()
        .collect(Collectors.groupingBy(
            t -> t.timeZone().name(),
            LinkedHashMap::new,
            Collectors.mapping(
                t -> new EmotionCountResponse(t.emotionName(), t.count()),
                Collectors.toList()
            )
        ))
        .entrySet().stream()
        .map(e -> new TimeZoneEmotionGroupResponse(e.getKey(), e.getValue()))
        .toList();
  }
}
