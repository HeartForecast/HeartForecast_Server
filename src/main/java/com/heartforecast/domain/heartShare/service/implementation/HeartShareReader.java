package com.heartforecast.domain.heartShare.service.implementation;

import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.heartShare.domain.repository.HeartShareRepository;
import com.heartforecast.domain.heartShare.exception.HeartShareNotFoundException;
import com.heartforecast.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeartShareReader {

  private final HeartShareRepository heartShareRepository;

  public HeartShare findById(Long id) {
    return heartShareRepository.findById(id)
        .orElseThrow(HeartShareNotFoundException::new);
  }

  public List<HeartShare> findAll() {
    return heartShareRepository.findAll();
  }

  public List<HeartShare> findAllByUser(Users user) {
    return heartShareRepository.findAllByUser(user);
  }
}
