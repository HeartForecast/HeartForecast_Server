package com.heartforecast.domain.SpecialForecastRecord.presentation;

import com.heartforecast.domain.SpecialForecastRecord.presentation.dto.request.SpecialForecastRecordCreateRequest;
import com.heartforecast.domain.SpecialForecastRecord.service.CommandSpecialForecastRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialForecastRecords")
public class SpecialForecastRecordController {

  private final CommandSpecialForecastRecordService commandSpecialForecastRecordService;

  @PostMapping("specialForecastRecord")
  public void createSpecialForecastRecord(@RequestBody SpecialForecastRecordCreateRequest request) {
    commandSpecialForecastRecordService.create(request);
  }
}
