package com.heartforecast.domain.forecast.presentation;

import com.heartforecast.domain.forecast.presentation.dto.request.ForecastCreateRequest;
import com.heartforecast.domain.forecast.presentation.dto.response.ForecastResponse;
import com.heartforecast.domain.forecast.service.CommandForecastService;
import com.heartforecast.domain.forecast.service.QueryForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forecasts")
public class ForecastController {

  private final CommandForecastService commandForecastService;
  private final QueryForecastService queryForecastService;

  @PostMapping("/forecast")
  public void createForecast(@RequestBody ForecastCreateRequest request) {
    commandForecastService.create(request);
  }

  @GetMapping("/{child-id}/{date}")
  public List<ForecastResponse> getForecast(@PathVariable("child-id") Long childId, @PathVariable LocalDate date) {
    return queryForecastService.findDate(date, childId).stream()
        .map(ForecastResponse::from)
        .toList();
  }

  @GetMapping("/{child-id}")
  public List<ForecastResponse> getForecasts(@PathVariable("child-id") Long childId) {
    return queryForecastService.readAll(childId).stream()
        .map(ForecastResponse::from)
        .toList();
  }
}
