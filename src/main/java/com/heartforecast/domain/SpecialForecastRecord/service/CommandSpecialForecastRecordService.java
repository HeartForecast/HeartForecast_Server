package com.heartforecast.domain.SpecialForecastRecord.service;

import com.heartforecast.domain.SpecialForecastRecord.domain.SpecialForecastRecord;
import com.heartforecast.domain.SpecialForecastRecord.presentation.dto.request.SpecialForecastRecordCreateRequest;
import com.heartforecast.domain.SpecialForecastRecord.service.implementation.SpecialForecastRecordCreator;
import com.heartforecast.domain.SpecialForecastRecord.service.implementation.SpecialForecastRecordValidator;
import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import com.heartforecast.domain.specialForecast.service.QuerySpecialForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandSpecialForecastRecordService {

  private final SpecialForecastRecordCreator specialForecastRecordCreator;
  private final SpecialForecastRecordValidator specialForecastRecordValidator;
  private final QueryChildService queryChildService;
  private final QueryEmotionTypeService queryEmotionTypeService;
  private final QuerySpecialForecastService querySpecialForecastService;

  public void create(SpecialForecastRecordCreateRequest request) {
    SpecialForecast specialForecast = querySpecialForecastService.readOne(request.specialForecastId(), request.childId());
    Child child = queryChildService.readOne(request.childId());
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());

    specialForecastRecordValidator.validate(specialForecast);

    SpecialForecastRecord specialForecastRecord = SpecialForecastRecord.builder()
        .specialForecast(specialForecast)
        .child(child)
        .emotionType(emotionType)
        .memo(request.memo())
        .build();
    specialForecastRecordCreator.create(specialForecastRecord);
  }
}
