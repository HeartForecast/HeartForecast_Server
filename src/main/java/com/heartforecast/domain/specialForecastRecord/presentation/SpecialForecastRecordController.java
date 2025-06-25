package com.heartforecast.domain.specialForecastRecord.presentation;

import com.heartforecast.domain.specialForecastRecord.presentation.dto.request.SpecialForecastRecordCreateRequest;
import com.heartforecast.domain.specialForecastRecord.presentation.dto.request.SpecialForecastRecordUpdateRequest;
import com.heartforecast.domain.specialForecastRecord.presentation.dto.response.SpecialForecastRecordResponse;
import com.heartforecast.domain.specialForecastRecord.service.CommandSpecialForecastRecordService;
import com.heartforecast.domain.specialForecastRecord.service.QuerySpecialForecastRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialForecastRecords")
public class SpecialForecastRecordController {

  private final CommandSpecialForecastRecordService commandSpecialForecastRecordService;
  private final QuerySpecialForecastRecordService querySpecialForecastRecordService;

  @PostMapping("specialForecastRecord")
  public void createSpecialForecastRecord(@RequestBody SpecialForecastRecordCreateRequest request) {
    commandSpecialForecastRecordService.create(request);
  }

  @GetMapping("/{child-id}/{specialForecastRecord-id}")
  public SpecialForecastRecordResponse getSpecialForecastRecord(
      @PathVariable("child-id") Long childId,
      @PathVariable("specialForecastRecord-id") Long specialForecastRecordId) {
    return SpecialForecastRecordResponse.from(querySpecialForecastRecordService.readOne(specialForecastRecordId, childId));
  }

  @GetMapping("/{child-id}")
  public List<SpecialForecastRecordResponse> getSpecialForecastRecords(@PathVariable("child-id") Long childId) {
    return querySpecialForecastRecordService.readAll(childId).stream()
        .map(SpecialForecastRecordResponse::from)
        .toList();
  }

  @PutMapping("specialForecastRecord")
  public void updateSpecialForecastRecord(@RequestBody SpecialForecastRecordUpdateRequest request) {
    commandSpecialForecastRecordService.update(request);
  }

  @DeleteMapping("/{child-id}/{specialForecastRecord-id}")
  public void deleteSpecialForecastRecord(
      @PathVariable("child-id") Long childId,
      @PathVariable("specialForecastRecord-id") Long specialForecastRecordId) {
    commandSpecialForecastRecordService.delete(specialForecastRecordId, childId);
  }
}
