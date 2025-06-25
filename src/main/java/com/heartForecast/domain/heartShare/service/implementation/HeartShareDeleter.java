package com.heartForecast.domain.heartShare.service.implementation;

import com.heartForecast.domain.heartShare.domain.HeartShare;
import com.heartForecast.domain.heartShare.domain.repository.HeartShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartShareDeleter {

  private final HeartShareRepository heartShareRepository;

  public void delete(HeartShare heartShare) {
    heartShareRepository.delete(heartShare);
  }
}
