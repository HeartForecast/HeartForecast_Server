package com.heartforecast.domain.specialForecast.service;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.service.QueryChildService;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.emotionType.service.QueryEmotionTypeService;
import com.heartforecast.domain.event.domain.Event;
import com.heartforecast.domain.event.service.QueryEventService;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastCreateRequest;
import com.heartforecast.domain.specialForecast.service.implementation.SpecialForecastCreator;
import com.heartforecast.domain.specialForecast.service.implementation.SpecialForecastValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandSpecialForecastService {

  private final SpecialForecastCreator specialForecastCreator;
  private final SpecialForecastValidator specialForecastValidator;
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
}
