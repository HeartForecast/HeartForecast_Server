package com.heartforecast.domain.heartShare.service;


import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.heartShare.service.implementation.HeartShareReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryHeartShareService {

  private final HeartShareReader heartShareReader;

  public HeartShare readOne(Long id) {
    return heartShareReader.findById(id);
  }
}
