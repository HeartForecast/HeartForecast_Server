package com.heartforecast.domain.heartShare.service;


import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.heartShare.service.implementation.HeartShareReader;
import com.heartforecast.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryHeartShareService {

  private final HeartShareReader heartShareReader;
  private final QueryUserService queryUserService;

  public HeartShare readOne(Long id) {
    return heartShareReader.findById(id);
  }

  public List<HeartShare> readAll() {
    return heartShareReader.findAll();
  }

  public List<HeartShare> readAllByMine(Long userId) {
    return heartShareReader.findAllByUser(queryUserService.readOne(userId));
  }
}
