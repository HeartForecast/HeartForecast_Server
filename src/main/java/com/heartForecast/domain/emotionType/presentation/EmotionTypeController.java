package com.heartForecast.domain.emotionType.presentation;

import com.heartForecast.domain.emotionType.presentation.dto.EmotionTypeResponse;
import com.heartForecast.domain.emotionType.service.QueryEmotionTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "감정 종류 API", description = "감정 종류(긍정/중립/부정) 및 관련 정보 조회 API입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/emotionTypes")
public class EmotionTypeController {

  private final QueryEmotionTypeService queryEmotionTypeService;

  @Operation(summary = "특정 감정 정보 조회", description = "emotionType-id를 통해 감정 정보를 조회합니다.")
  @GetMapping("{emotionType-id}")
  public EmotionTypeResponse getEmotionType(@PathVariable("emotionType-id") Long emotionTypeId) {
    return EmotionTypeResponse.from(queryEmotionTypeService.readOne(emotionTypeId));
  }

  @Operation(summary = "전체 감정 목록 조회", description = "모든 감정 정보를 리스트로 조회합니다.")
  @GetMapping("emotionType")
  public List<EmotionTypeResponse> getEmotionTypes() {
    return queryEmotionTypeService.readAll().stream()
        .map(EmotionTypeResponse::from)
        .toList();
  }
}
