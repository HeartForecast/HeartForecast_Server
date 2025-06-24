package com.heartforecast.domain.forecast.presentation;

import com.heartforecast.domain.forecast.presentation.dto.request.ForecastCreateRequest;
import com.heartforecast.domain.forecast.service.CommandForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forecasts")
public class ForecastController {

  private final CommandForecastService commandForecastService;

  @PostMapping("/forecast")
  public void createForecast(@RequestBody ForecastCreateRequest request) {
    commandForecastService.create(request);
  }
}
