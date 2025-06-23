package com.heartforecast.domain.SpecialForecastRecord.presentation;

import com.heartforecast.domain.SpecialForecastRecord.presentation.dto.request.SpecialForecastRecordCreateRequest;
import com.heartforecast.domain.SpecialForecastRecord.presentation.dto.response.SpecialForecastRecordResponse;
import com.heartforecast.domain.SpecialForecastRecord.service.CommandSpecialForecastRecordService;
import com.heartforecast.domain.SpecialForecastRecord.service.QuerySpecialForecastRecordService;
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
}
