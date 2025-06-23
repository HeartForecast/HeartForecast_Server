package com.heartforecast.domain.specialForecast.presentation;

import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastCreateRequest;
import com.heartforecast.domain.specialForecast.service.CommandSpecialForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialForecasts")
public class SpecialForecastController {

  private final CommandSpecialForecastService commandSpecialForecastService;

  @PostMapping("/specialForecast")
  public void createSpecialForecast(@RequestBody SpecialForecastCreateRequest request) {
    commandSpecialForecastService.create(request);
  }
}
