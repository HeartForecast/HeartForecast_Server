package com.heartforecast.domain.forecast.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecast.presentation.dto.request.ForecastCreateRequest;
import com.heartforecast.domain.forecast.presentation.dto.request.ForecastUpdateRequest;
import com.heartforecast.domain.forecast.service.implementation.ForecastCreator;
import com.heartforecast.domain.forecast.service.implementation.ForecastUpdater;
import com.heartforecast.domain.forecastRecord.service.QueryForecastRecordService;
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
