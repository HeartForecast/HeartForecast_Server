package com.heartForecast.domain.specialForecastRecord.service;

import com.heartForecast.domain.specialForecastRecord.domain.SpecialForecastRecord;
import com.heartForecast.domain.specialForecastRecord.presentation.dto.request.SpecialForecastRecordCreateRequest;
import com.heartForecast.domain.specialForecastRecord.presentation.dto.request.SpecialForecastRecordUpdateRequest;
import com.heartForecast.domain.specialForecastRecord.service.implementation.*;
import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.service.QueryChildService;
import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartForecast.domain.specialForecast.domain.SpecialForecast;
import com.heartForecast.domain.specialForecast.service.QuerySpecialForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandSpecialForecastRecordService {

  private final SpecialForecastRecordCreator specialForecastRecordCreator;
  private final SpecialForecastRecordUpdater specialForecastRecordUpdater;
  private final SpecialForecastRecordDeleter specialForecastRecordDeleter;
  private final SpecialForecastRecordValidator specialForecastRecordValidator;
  private final QuerySpecialForecastRecordService querySpecialForecastRecordService;
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
        .date(request.date())
        .memo(request.memo())
        .build();
    specialForecastRecordCreator.create(specialForecastRecord);
  }

  public void update(SpecialForecastRecordUpdateRequest request) {
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());
    SpecialForecastRecord specialForecastRecord = querySpecialForecastRecordService.readOne(request.specialForecastRecordId(), request.childId());

    querySpecialForecastRecordService.overUpdateTimeExpire(request.specialForecastRecordId(), request.childId());

    specialForecastRecordUpdater.update(specialForecastRecord, emotionType, request.memo());
  }

  public void delete(Long specialForecastRecordId, Long childId) {
    specialForecastRecordDeleter.delete(querySpecialForecastRecordService.readOne(specialForecastRecordId, childId));
  }

  public void deleteBySpecialForecast(Long specialForecastId, Long childId) {
    specialForecastRecordDeleter.deleteBySpecialForecast(querySpecialForecastService.readOne(specialForecastId, childId));
  }
}
