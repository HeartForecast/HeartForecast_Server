package com.heartForecast.domain.specialForecastRecord.presentation;

import com.heartForecast.domain.specialForecastRecord.presentation.dto.request.SpecialForecastRecordCreateRequest;
import com.heartForecast.domain.specialForecastRecord.presentation.dto.request.SpecialForecastRecordUpdateRequest;
import com.heartForecast.domain.specialForecastRecord.presentation.dto.response.SpecialForecastRecordResponse;
import com.heartForecast.domain.specialForecastRecord.service.CommandSpecialForecastRecordService;
import com.heartForecast.domain.specialForecastRecord.service.QuerySpecialForecastRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialForecastRecords")
@Tag(name = "특보 기록 API")
public class SpecialForecastRecordController {

  private final CommandSpecialForecastRecordService commandSpecialForecastRecordService;
  private final QuerySpecialForecastRecordService querySpecialForecastRecordService;

  @Operation(summary = "특보 기록 생성", description = "새로운 특보 기록을 생성합니다.")
  @PostMapping("/specialForecastRecord")
  public void createSpecialForecastRecord(@RequestBody SpecialForecastRecordCreateRequest request) {
    commandSpecialForecastRecordService.create(request);
  }

  @Operation(summary = "특보 기록 단일 조회", description = "특정 아이의 특정 특보 기록을 조회합니다.")
  @GetMapping("/{child-id}/{specialForecastRecord-id}")
  public SpecialForecastRecordResponse getSpecialForecastRecord(
      @PathVariable("child-id") Long childId,
      @PathVariable("specialForecastRecord-id") Long specialForecastRecordId) {
    return SpecialForecastRecordResponse.from(querySpecialForecastRecordService.readOne(specialForecastRecordId, childId));
  }

  @Operation(summary = "특보 기록 목록 조회", description = "특정 아이의 모든 특보 기록 목록을 조회합니다.")
  @GetMapping("/{child-id}")
  public List<SpecialForecastRecordResponse> getSpecialForecastRecords(@PathVariable("child-id") Long childId) {
    return querySpecialForecastRecordService.readAll(childId).stream()
        .map(SpecialForecastRecordResponse::from)
        .toList();
  }

  @Operation(summary = "특보 기록 수정", description = "특보 기록 정보를 수정합니다.")
  @PutMapping("/specialForecastRecord")
  public void updateSpecialForecastRecord(@RequestBody SpecialForecastRecordUpdateRequest request) {
    commandSpecialForecastRecordService.update(request);
  }

  @Operation(summary = "특보 기록 삭제", description = "특정 아이의 특정 특보 기록을 삭제합니다.")
  @DeleteMapping("/{child-id}/{specialForecastRecord-id}")
  public void deleteSpecialForecastRecord(
      @PathVariable("child-id") Long childId,
      @PathVariable("specialForecastRecord-id") Long specialForecastRecordId) {
    commandSpecialForecastRecordService.delete(specialForecastRecordId, childId);
  }
}
