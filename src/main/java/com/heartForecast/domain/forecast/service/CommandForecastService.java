package com.heartForecast.domain.forecast.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecast.presentation.dto.request.ForecastCreateRequest;
import com.heartForecast.domain.forecast.presentation.dto.request.ForecastUpdateRequest;
import com.heartForecast.domain.forecast.service.implementation.ForecastCreator;
import com.heartForecast.domain.forecast.service.implementation.ForecastUpdater;
import com.heartForecast.domain.forecastRecord.service.QueryForecastRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandForecastService {

  private final ForecastCreator forecastCreator;
  private final ForecastUpdater forecastUpdater;
  private final QueryForecastService queryForecastService;
  private final QueryForecastRecordService queryForecastRecordService;
  private final QueryChildService queryChildService;
  private final QueryEmotionTypeService queryEmotionTypeService;

  public void create(ForecastCreateRequest request) {
    Child child = queryChildService.readOne(request.childId());
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());

    queryForecastService.existsByDateAndTimeZone(request.childId(), request.date(), request.timeZone());

    Forecast forecast = Forecast.builder()
        .child(child)
        .emotionType(emotionType)
        .date(request.date())
        .timeZone(request.timeZone())
        .memo(request.memo())
        .build();
    forecastCreator.create(forecast);
  }

  public void update(ForecastUpdateRequest request) {
    Forecast forecast = queryForecastService.readOne(request.forecastId(), request.childId());
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());

    queryForecastRecordService.existsByForecast(request.forecastId(), request.childId());

    forecastUpdater.update(forecast, emotionType, request.memo());
  }
}
