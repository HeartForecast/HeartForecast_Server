package com.heartForecast.domain.statistic.presentation;

import com.heartForecast.domain.statistic.presentation.dto.response.*;
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
@RequestMapping("/api/statistics")
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

  @Operation(summary = "시간대별 감정 분포 통계 조회", description = "해당 아이의 기간 내 시간대별 감정 분포 통계를 반환합니다.")
  @GetMapping("/{childId}/emotions/timezones")
  public List<TimeZoneEmotionGroupResponse> getTimeZoneEmotionStats(
      @PathVariable Long childId,
      @RequestParam LocalDate startDate,
      @RequestParam LocalDate endDate
  ) {
    return queryStatisticService.getTimeZoneEmotionDistribution(childId, startDate, endDate);
  }

  @Operation(summary = "감정별 비율 통계 조회", description = "해당 아이의 기간 내 감정별 비율 통계를 반환합니다.")
  @GetMapping("/{childId}/emotions/ratio")
  public List<EmotionRatioResponse> getEmotionRatioStats(
      @PathVariable Long childId,
      @RequestParam LocalDate startDate,
      @RequestParam LocalDate endDate
  ) {
    return queryStatisticService.getEmotionRatioStats(childId, startDate, endDate);
  }

  @Operation(summary = "전체 기간 감정 온도 평균 조회", description = "해당 아이의 기간 내 전체 평균 감정 온도를 반환합니다.")
  @GetMapping("/{childId}/temperature/average")
  public AvgTempResponse getAverageTemperature(
      @Parameter(description = "조회할 아이 ID") @PathVariable Long childId,
      @Parameter(description = "시작 날짜") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
      @Parameter(description = "종료 날짜") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    return queryStatisticService.getAverageTemperature(childId, startDate, endDate);
  }

  @Operation(summary = "감정별 예외 오차율 조회", description = "해당 아이의 기간 내 감정별 발생 횟수 대비 평균 대비 오차율을 반환합니다.")
  @GetMapping("/{childId}/emotions/error-rate")
  public List<EmotionErrorRateResponse> getEmotionErrorRates(
      @Parameter(description = "조회할 아이 ID") @PathVariable Long childId,
      @Parameter(description = "시작 날짜") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
      @Parameter(description = "종료 날짜") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    return queryStatisticService.getEmotionErrorRates(childId, startDate, endDate);
  }
}
