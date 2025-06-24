package com.heartforecast.domain.forecastRecord.presentation;

import com.heartforecast.domain.forecastRecord.presentation.dto.request.ForecastRecordCreateRequest;
import com.heartforecast.domain.forecastRecord.service.CommandForecastRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forecastRecords")
public class ForecastRecordController {

  private final CommandForecastRecordService commandForecastRecordService;

  @PostMapping("/forecastRecord")
  public void createForecastRecord(@RequestBody ForecastRecordCreateRequest request) {
    commandForecastRecordService.create(request);
  }
}
