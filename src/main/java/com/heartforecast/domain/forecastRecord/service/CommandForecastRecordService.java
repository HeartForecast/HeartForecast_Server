package com.heartforecast.domain.forecastRecord.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecast.service.QueryForecastService;
import com.heartforecast.domain.forecastRecord.domain.ForecastRecord;
import com.heartforecast.domain.forecastRecord.exception.ForecastRecordInvalidDateTimeException;
import com.heartforecast.domain.forecastRecord.presentation.dto.request.ForecastRecordCreateRequest;
import com.heartforecast.domain.forecastRecord.presentation.dto.request.ForecastRecordUpdateRequest;
import com.heartforecast.domain.forecastRecord.service.implementation.ForecastRecordCreator;
import com.heartforecast.domain.forecastRecord.service.implementation.ForecastRecordUpdater;
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
    Forecast forecast = queryForecastService.readOne(request.forecastId(), request.childId());

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
