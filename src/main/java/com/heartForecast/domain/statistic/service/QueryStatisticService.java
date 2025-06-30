package com.heartForecast.domain.statistic.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.statistic.presentation.dto.response.*;
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

  public List<EmotionRatioResponse> getEmotionRatioStats(Long childId, LocalDate startDate, LocalDate endDate) {
    Child child = queryChildService.readOne(childId);
    List<Object[]> rawCounts = statisticReader.countEmotionGroupByName(child, startDate, endDate);

    long total = rawCounts.stream()
        .mapToLong(r -> (Long) r[1])
        .sum();

    return rawCounts.stream()
        .map(r -> {
          String name = (String) r[0];
          Long count = (Long) r[1];
          double ratio = total == 0 ? 0 : ((double) count / total);
          return new EmotionRatioResponse(name, count, Math.round(ratio * 1000) / 1000.0);
        })
        .toList();
  }
}
