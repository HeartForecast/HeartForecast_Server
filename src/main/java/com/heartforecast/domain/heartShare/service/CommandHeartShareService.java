package com.heartforecast.domain.heartShare.service;


import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.heartShare.presentation.dto.request.HeartShareCreateRequest;
import com.heartforecast.domain.heartShare.presentation.dto.request.HeartShareUpdateRequest;
import com.heartforecast.domain.heartShare.service.implementation.HeartShareCreator;
import com.heartforecast.domain.heartShare.service.implementation.HeartShareDeleter;
import com.heartforecast.domain.heartShare.service.implementation.HeartShareUpdater;
import com.heartforecast.domain.heartShare.service.implementation.HeartShareValidator;
import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandHeartShareService {

  private final HeartShareCreator heartShareCreator;
  private final HeartShareUpdater heartShareUpdater;
  private final HeartShareDeleter heartShareDeleter;
  private final HeartShareValidator heartShareValidator;
  private final QueryHeartShareService queryHeartShareService;
  private final QueryUserService queryUserService;

  public void create(HeartShareCreateRequest request, Long userId) {
    Users user = queryUserService.readOne(userId);

    HeartShare heartShare = HeartShare.builder()
        .user(user)
        .title(request.title())
        .content(request.content())
        .build();
    heartShareCreator.create(heartShare);
  }

  public void update(HeartShareUpdateRequest request, Long userId) {
    HeartShare heartShare = queryHeartShareService.readOne(request.heartShareId());

    heartShareValidator.ownership(heartShare, userId);

    heartShareUpdater.update(heartShare, request.title(), request.content());
  }

  public void delete(Long heartShareId, Long userId) {
    HeartShare heartShare = queryHeartShareService.readOne(heartShareId);

    heartShareValidator.ownership(heartShare, userId);

    heartShareDeleter.delete(heartShare);
  }
}
