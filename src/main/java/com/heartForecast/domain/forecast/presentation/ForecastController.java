package com.heartForecast.domain.forecast.presentation;

import com.heartForecast.domain.forecast.presentation.dto.request.ForecastCreateRequest;
import com.heartForecast.domain.forecast.presentation.dto.request.ForecastUpdateRequest;
import com.heartForecast.domain.forecast.presentation.dto.response.ForecastResponse;
import com.heartForecast.domain.forecast.service.CommandForecastService;
import com.heartForecast.domain.forecast.service.QueryForecastService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "예보 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/forecasts")
public class ForecastController {

  private final CommandForecastService commandForecastService;
  private final QueryForecastService queryForecastService;

  @Operation(summary = "예보 생성", description = "아이의 감정 예보 데이터를 생성합니다.")
  @PostMapping("/forecast")
  public void createForecast(@RequestBody ForecastCreateRequest request) {
    commandForecastService.create(request);
  }

  @Operation(summary = "예보 단일 조회", description = "예보 ID로 특정 예보 정보를 조회합니다.")
  @GetMapping("/forecast/{forecast-id}")
  public ForecastResponse getForecast(@PathVariable("forecast-id") Long forecastId) {
    return ForecastResponse.from(queryForecastService.readOne(forecastId));
  }

  @Operation(summary = "특정 날짜 예보 조회", description = "아이 ID와 날짜로 해당 날짜의 예보 목록을 조회합니다.")
  @GetMapping("/{child-id}/{date}")
  public List<ForecastResponse> getForecastByDate(
      @PathVariable("child-id") Long childId,
      @PathVariable LocalDate date) {
    return queryForecastService.findDate(date, childId).stream()
        .map(ForecastResponse::from)
        .toList();
  }

  @Operation(summary = "아이 전체 예보 조회", description = "아이 ID로 모든 예보 기록을 조회합니다.")
  @GetMapping("/{child-id}")
  public List<ForecastResponse> getForecasts(@PathVariable("child-id") Long childId) {
    return queryForecastService.readAll(childId).stream()
        .map(ForecastResponse::from)
        .toList();
  }

  @Operation(summary = "예보 기록 존재 여부 확인", description = "해당 아이 ID와 예보 ID로 예보 기록(ForecastRecord)의 존재 여부를 확인합니다.")
  @GetMapping("/{child-id}/{forecast-id}/exists")
  public boolean checkForecastRecordExist(
      @PathVariable("child-id") Long childId,
      @PathVariable("forecast-id") Long forecastId) {
    return queryForecastService.hasForecastRecord(forecastId, childId);
  }

  @Hidden
  @Operation(summary = "예보 정보 수정", description = "기존 예보 정보를 수정합니다.")
  @PutMapping("/forecast")
  public void updateForecast(@RequestBody ForecastUpdateRequest request) {
    commandForecastService.update(request);
  }
}
