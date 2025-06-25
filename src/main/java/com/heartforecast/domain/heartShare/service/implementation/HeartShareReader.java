package com.heartforecast.domain.heartShare.service.implementation;

import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.heartShare.domain.repository.HeartShareRepository;
import com.heartforecast.domain.heartShare.exception.HeartShareNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartShareReader {

  private final HeartShareRepository heartShareRepository;

  public HeartShare findById(Long id) {
    return heartShareRepository.findById(id)
        .orElseThrow(HeartShareNotFoundException::new);
  }
}
