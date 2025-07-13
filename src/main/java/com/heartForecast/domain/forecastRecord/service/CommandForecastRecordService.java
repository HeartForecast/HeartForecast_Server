package com.heartForecast.domain.forecastRecord.service;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartForecast.domain.forecast.domain.Forecast;
import com.heartForecast.domain.forecast.service.QueryForecastService;
import com.heartForecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartForecast.domain.forecastRecord.exception.ForecastRecordInvalidDateTimeException;
import com.heartForecast.domain.forecastRecord.presentation.dto.request.ForecastRecordCreateRequest;
import com.heartForecast.domain.forecastRecord.presentation.dto.request.ForecastRecordUpdateRequest;
import com.heartForecast.domain.forecastRecord.service.implementation.ForecastRecordCreator;
import com.heartForecast.domain.forecastRecord.service.implementation.ForecastRecordUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandForecastRecordService {

  private final ForecastRecordCreator forecastRecordCreator;
  private final ForecastRecordUpdater forecastRecordUpdater;
  private final QueryForecastRecordService queryForecastRecordService;
  private final QueryChildService queryChildService;
  private final QueryEmotionTypeService queryEmotionTypeService;
  private final QueryForecastService queryForecastService;

  public void create(ForecastRecordCreateRequest request) {
    Forecast forecast = queryForecastService.findOne(request.forecastId(), request.childId());

    if (!forecast.getDate().equals(request.date()) || forecast.getTimeZone().getOrder() != request.timeZone().getOrder()) throw new ForecastRecordInvalidDateTimeException();

    queryForecastRecordService.existsByForecast(request.forecastId(), request.childId());

    Child child = queryChildService.readOne(request.childId());
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());

    ForecastRecord forecastRecord = ForecastRecord.builder()
        .forecast(forecast)
        .child(child)
        .emotionType(emotionType)
        .date(request.date())
        .timeZone(request.timeZone())
        .memo(request.memo())
        .build();
    forecastRecordCreator.create(forecastRecord);
  }

  public void update(ForecastRecordUpdateRequest request) {
    ForecastRecord forecastRecord = queryForecastRecordService.readOne(request.forecastRecordId(), request.childId());
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());

    queryForecastRecordService.overUpdateTimeExpire(request.forecastRecordId(), request.childId());

    forecastRecordUpdater.update(forecastRecord, emotionType, request.memo());
  }
}
