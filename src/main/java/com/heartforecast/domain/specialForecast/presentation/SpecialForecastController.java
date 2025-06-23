package com.heartforecast.domain.specialForecast.presentation;

import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastCreateRequest;
import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastUpdateRequest;
import com.heartforecast.domain.specialForecast.presentation.dto.response.SpecialForecastResponse;
import com.heartforecast.domain.specialForecast.service.CommandSpecialForecastService;
import com.heartforecast.domain.specialForecast.service.QuerySpecialForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialForecasts")
public class SpecialForecastController {

  private final CommandSpecialForecastService commandSpecialForecastService;
  private final QuerySpecialForecastService querySpecialForecastService;

  @PostMapping("/specialForecast")
  public void createSpecialForecast(@RequestBody SpecialForecastCreateRequest request) {
    commandSpecialForecastService.create(request);
  }

  @GetMapping("/{child-id}/{specialForecast-id}")
  public SpecialForecastResponse getSpecialForecast(
      @PathVariable("child-id") Long childId,
      @PathVariable("specialForecast-id") Long specialForecastId) {
    return SpecialForecastResponse.from(querySpecialForecastService.readOne(specialForecastId, childId));
  }

  @GetMapping("/{child-id}")
  public List<SpecialForecastResponse> getSpecialForecasts(@PathVariable("child-id") Long childId) {
    return querySpecialForecastService.readAll(childId).stream()
        .map(SpecialForecastResponse::from)
        .toList();
  }

  @PutMapping("/specialForecast")
  public void updateSpecialForecast(@RequestBody SpecialForecastUpdateRequest request) {
    commandSpecialForecastService.update(request);
  }
}
