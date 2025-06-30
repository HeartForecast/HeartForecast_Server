package com.heartForecast.domain.statistic.presentation;

import com.heartForecast.domain.statistic.presentation.dto.response.DateTempResponse;
import com.heartForecast.domain.statistic.service.QueryStatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "감정 통계 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticController {

  private final QueryStatisticService queryStatisticService;

  @Operation(summary = "일별 평균 감정 온도 조회", description = "해당 아이의 기간 내 일별 평균 감정 온도를 반환합니다.")
  @GetMapping("/{childId}/temperature/daily")
  public List<DateTempResponse> getDailyAverageTemperature(
      @Parameter(description = "조회할 아이 ID") @PathVariable Long childId,
      @Parameter(description = "시작 날짜") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
      @Parameter(description = "종료 날짜") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    return queryStatisticService.getDailyAverageTemperature(childId, startDate, endDate);
  }
}
