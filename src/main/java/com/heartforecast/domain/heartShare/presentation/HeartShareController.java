package com.heartforecast.domain.heartShare.presentation;

import com.heartforecast.domain.heartShare.presentation.dto.request.HeartShareCreateRequest;
import com.heartforecast.domain.heartShare.presentation.dto.request.HeartShareUpdateRequest;
import com.heartforecast.domain.heartShare.presentation.dto.response.HeartShareResponse;
import com.heartforecast.domain.heartShare.service.CommandHeartShareService;
import com.heartforecast.domain.heartShare.service.QueryHeartShareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;

@Tag(name = "마음공유 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/heartShares")
public class HeartShareController {

  private final CommandHeartShareService commandHeartShareService;
  private final QueryHeartShareService queryHeartShareService;

  @Operation(summary = "마음공유 생성", description = "새로운 마음공유 게시글을 작성합니다.")
  @PostMapping("/heartShare")
  public void createHeartShare(@RequestBody HeartShareCreateRequest request) {
    commandHeartShareService.create(request, getMemberId());
  }

  @Operation(summary = "마음공유 단일 조회", description = "마음공유 게시글 하나를 조회합니다.")
  @GetMapping("/{heartShare-id}")
  public HeartShareResponse getHeartShare(@PathVariable("heartShare-id") Long heartShareId) {
    return HeartShareResponse.from(queryHeartShareService.readOne(heartShareId));
  }

  @Operation(summary = "전체 마음공유 목록 조회", description = "모든 마음공유 게시글 목록을 조회합니다.")
  @GetMapping
  public List<HeartShareResponse> getHeartShares() {
    return queryHeartShareService.readAll().stream()
        .map(HeartShareResponse::from)
        .toList();
  }

  @Operation(summary = "내 마음공유 목록 조회", description = "로그인한 사용자의 마음공유 게시글 목록을 조회합니다.")
  @GetMapping("/my")
  public List<HeartShareResponse> getMyHeartShares() {
    return queryHeartShareService.readAllByMine(getMemberId()).stream()
        .map(HeartShareResponse::from)
        .toList();
  }

  @Operation(summary = "마음공유 수정", description = "기존 마음공유 게시글을 수정합니다.")
  @PutMapping("/heartShare")
  public void updateHeartShare(@RequestBody HeartShareUpdateRequest request) {
    commandHeartShareService.update(request, getMemberId());
  }

  @Operation(summary = "마음공유 삭제", description = "마음공유 게시글을 삭제합니다.")
  @DeleteMapping("/{heartShare-id}")
  public void deleteHeartShare(@PathVariable("heartShare-id") Long heartShareId) {
    commandHeartShareService.delete(heartShareId, getMemberId());
  }
}