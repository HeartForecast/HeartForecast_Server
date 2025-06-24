package com.heartforecast.domain.forecastRecord.presentation;

import com.heartforecast.domain.forecastRecord.presentation.dto.request.ForecastRecordCreateRequest;
import com.heartforecast.domain.forecastRecord.presentation.dto.request.ForecastRecordUpdateRequest;
import com.heartforecast.domain.forecastRecord.presentation.dto.response.ForecastRecordResponse;
import com.heartforecast.domain.forecastRecord.service.CommandForecastRecordService;
import com.heartforecast.domain.forecastRecord.service.QueryForecastRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forecastRecords")
public class ForecastRecordController {

  private final CommandForecastRecordService commandForecastRecordService;
  private final QueryForecastRecordService queryForecastRecordService;

  @PostMapping("/forecastRecord")
  public void createForecastRecord(@RequestBody ForecastRecordCreateRequest request) {
    commandForecastRecordService.create(request);
  }

  @GetMapping("/{child-id}/{date}")
  public List<ForecastRecordResponse> getForecastRecord(@PathVariable("child-id") Long childId, @PathVariable LocalDate date) {
    return queryForecastRecordService.findDate(date, childId).stream()
        .map(ForecastRecordResponse::from)
        .toList();
  }

  @GetMapping("/{child-id}")
  public List<ForecastRecordResponse> getForecastRecords(@PathVariable("child-id") Long childId) {
    return queryForecastRecordService.readAll(childId).stream()
        .map(ForecastRecordResponse::from)
        .toList();
  }

  @PutMapping("/forecastRecord")
  public void updateForecastRecord(@RequestBody ForecastRecordUpdateRequest request) {
    commandForecastRecordService.update(request);
  }
}
