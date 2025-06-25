package com.heartforecast.domain.heartShare.presentatioin;

import com.heartforecast.domain.heartShare.presentatioin.dto.request.HeartShareCreateRequest;
import com.heartforecast.domain.heartShare.service.CommandHeartShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.heartforecast.common.jwt.util.AuthenticationUtil.getMemberId;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heartShares")
public class HeartShareController {

  private final CommandHeartShareService commandHeartShareService;

  @PostMapping("/heartShare")
  public void createHeartShare(@RequestBody HeartShareCreateRequest request) {
    commandHeartShareService.create(request, getMemberId());
  }
}
