package com.heartForecast.domain.forecastRecord.presentation;

import com.heartForecast.domain.forecastRecord.presentation.dto.request.ForecastRecordCreateRequest;
import com.heartForecast.domain.forecastRecord.presentation.dto.request.ForecastRecordUpdateRequest;
import com.heartForecast.domain.forecastRecord.presentation.dto.response.ForecastRecordResponse;
import com.heartForecast.domain.forecastRecord.service.CommandForecastRecordService;
import com.heartForecast.domain.forecastRecord.service.QueryForecastRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "예보 기록 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/forecastRecords")
public class ForecastRecordController {

  private final CommandForecastRecordService commandForecastRecordService;
  private final QueryForecastRecordService queryForecastRecordService;

  @Operation(summary = "예보 기록 생성", description = "새로운 예보 기록 데이터를 생성합니다.")
  @PostMapping("/forecastRecord")
  public void createForecastRecord(@RequestBody ForecastRecordCreateRequest request) {
    commandForecastRecordService.create(request);
  }

  @Operation(summary = "특정 날짜 예보 기록 조회", description = "아이 ID와 날짜로 해당 날짜의 예보 기록 목록을 조회합니다.")
  @GetMapping("/{child-id}/{date}")
  public List<ForecastRecordResponse> getForecastRecord(@PathVariable("child-id") Long childId, @PathVariable LocalDate date) {
    return queryForecastRecordService.findDate(date, childId).stream()
        .map(ForecastRecordResponse::from)
        .toList();
  }

  @Operation(summary = "아이 전체 예보 기록 조회", description = "아이 ID로 모든 예보 기록을 조회합니다.")
  @GetMapping("/{child-id}")
  public List<ForecastRecordResponse> getForecastRecords(@PathVariable("child-id") Long childId) {
    return queryForecastRecordService.readAll(childId).stream()
        .map(ForecastRecordResponse::from)
        .toList();
  }

  @Operation(summary = "예보 기록 수정", description = "기존 예보 기록을 수정합니다.")
  @PutMapping("/forecastRecord")
  public void updateForecastRecord(@RequestBody ForecastRecordUpdateRequest request) {
    commandForecastRecordService.update(request);
  }
}
