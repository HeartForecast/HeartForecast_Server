package com.heartforecast.domain.specialForecast.service;

import com.heartforecast.domain.SpecialForecastRecord.service.CommandSpecialForecastRecordService;
import com.heartforecast.domain.SpecialForecastRecord.service.implementation.SpecialForecastRecordValidator;
import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.event.service.QueryEventService;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastCreateRequest;
import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastUpdateRequest;
import com.heartforecast.domain.specialForecast.service.implementation.SpecialForecastCreator;
import com.heartforecast.domain.specialForecast.service.implementation.SpecialForecastDeleter;
import com.heartforecast.domain.specialForecast.service.implementation.SpecialForecastUpdater;
import com.heartforecast.domain.specialForecast.service.implementation.SpecialForecastValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandSpecialForecastService {

  private final SpecialForecastCreator specialForecastCreator;
  private final SpecialForecastUpdater specialForecastUpdater;
  private final SpecialForecastDeleter specialForecastDeleter;
  private final SpecialForecastValidator specialForecastValidator;
  private final SpecialForecastRecordValidator specialForecastRecordValidator;
  private final CommandSpecialForecastRecordService commandSpecialForecastRecordService;
  private final QuerySpecialForecastService querySpecialForecastService;
  private final QueryChildService queryChildService;
  private final QueryEmotionTypeService queryEmotionTypeService;
  private final QueryEventService queryEventService;

  public void create(SpecialForecastCreateRequest request) {
    Child child = queryChildService.readOne(request.childId());
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());
    Event event = queryEventService.findOneByChild(request.eventId(), request.childId());

    specialForecastValidator.validate(event);

    SpecialForecast specialForecast = SpecialForecast.builder()
        .event(event)
        .child(child)
        .emotionType(emotionType)
        .memo(request.memo())
        .build();
    specialForecastCreator.create(specialForecast);
  }

  public void update(SpecialForecastUpdateRequest request) {
    SpecialForecast specialForecast = querySpecialForecastService.readOne(request.specialForecastId(), request.childId());
    EmotionType emotionType = queryEmotionTypeService.readOne(request.emotionTypeId());

    specialForecastRecordValidator.validate(specialForecast);

    specialForecastUpdater.update(specialForecast, emotionType, request.memo());
  }

  public void delete(Long specialForecastId, Long childId) {
    SpecialForecast specialForecast = querySpecialForecastService.readOne(specialForecastId, childId);

    commandSpecialForecastRecordService.deleteBySpecialForecast(specialForecastId, childId);
    specialForecastDeleter.delete(specialForecast);
  }

  public void deleteByEvent(Long eventId, Long userId) {
    SpecialForecast specialForecast = querySpecialForecastService.findByEvent(eventId, userId);

    commandSpecialForecastRecordService.deleteBySpecialForecast(specialForecast.getId(), specialForecast.getChild().getId());
    specialForecastDeleter.deleteByEvent(queryEventService.findOneByUser(eventId, userId));
  }
}
