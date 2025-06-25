package com.heartforecast.domain.heartShare.service.implementation;

import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.heartShare.domain.repository.HeartShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartShareCreator {

  private final HeartShareRepository heartShareRepository;

  public void create(HeartShare heartShare) {
    heartShareRepository.save(heartShare);
  }
}
