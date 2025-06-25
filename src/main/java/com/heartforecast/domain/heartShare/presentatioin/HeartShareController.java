package com.heartforecast.domain.heartShare.presentatioin;

import com.heartforecast.domain.heartShare.presentatioin.dto.request.HeartShareCreateRequest;
import com.heartforecast.domain.heartShare.presentatioin.dto.response.HeartShareResponse;
import com.heartforecast.domain.heartShare.service.CommandHeartShareService;
import com.heartforecast.domain.heartShare.service.QueryHeartShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heartShares")
public class HeartShareController {

  private final CommandHeartShareService commandHeartShareService;
  private final QueryHeartShareService queryHeartShareService;

  @PostMapping("/heartShare")
  public void createHeartShare(@RequestBody HeartShareCreateRequest request) {
    commandHeartShareService.create(request, getMemberId());
  }

  @GetMapping("/{heartShare-id}")
  public HeartShareResponse getHeartShare(@PathVariable("heartShare-id") Long heartShareId) {
    return HeartShareResponse.from(queryHeartShareService.readOne(heartShareId));
  }
}
