package com.heartforecast.domain.specialForecast.presentation;

import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastCreateRequest;
import com.heartforecast.domain.specialForecast.presentation.dto.request.SpecialForecastUpdateRequest;
import com.heartforecast.domain.specialForecast.presentation.dto.response.SpecialForecastResponse;
import com.heartforecast.domain.specialForecast.service.CommandSpecialForecastService;
import com.heartforecast.domain.specialForecast.service.QuerySpecialForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "특보 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/specialForecasts")
public class SpecialForecastController {

  private final CommandSpecialForecastService commandSpecialForecastService;
  private final QuerySpecialForecastService querySpecialForecastService;

  @Operation(summary = "특보 생성", description = "새로운 특보를 생성합니다.")
  @PostMapping("/specialForecast")
  public void createSpecialForecast(@RequestBody SpecialForecastCreateRequest request) {
    commandSpecialForecastService.create(request);
  }

  @Operation(summary = "특보 단일 조회", description = "특정 아이의 특정 특보를 조회합니다.")
  @GetMapping("/{child-id}/{specialForecast-id}")
  public SpecialForecastResponse getSpecialForecast(
      @PathVariable("child-id") Long childId,
      @PathVariable("specialForecast-id") Long specialForecastId) {
    return SpecialForecastResponse.from(querySpecialForecastService.readOne(specialForecastId, childId));
  }

  @Operation(summary = "특보 목록 조회", description = "특정 아이의 모든 특보 목록을 조회합니다.")
  @GetMapping("/{child-id}")
  public List<SpecialForecastResponse> getSpecialForecasts(@PathVariable("child-id") Long childId) {
    return querySpecialForecastService.readAll(childId).stream()
        .map(SpecialForecastResponse::from)
        .toList();
  }

  @Operation(summary = "특보 수정", description = "특보 정보를 수정합니다.")
  @PutMapping("/specialForecast")
  public void updateSpecialForecast(@RequestBody SpecialForecastUpdateRequest request) {
    commandSpecialForecastService.update(request);
  }

  @Operation(summary = "특보 삭제", description = "특정 아이의 특정 특보를 삭제합니다.")
  @DeleteMapping("/{child-id}/{specialForecast-id}")
  public void deleteSpecialForecast(
      @PathVariable("child-id") Long childId,
      @PathVariable("specialForecast-id") Long specialForecastId) {
    commandSpecialForecastService.delete(specialForecastId, childId);
  }
}
