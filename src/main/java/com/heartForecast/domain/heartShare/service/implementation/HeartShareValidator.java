package com.heartForecast.domain.heartShare.service.implementation;

import com.heartForecast.domain.heartShare.domain.HeartShare;
import com.heartForecast.domain.heartShare.exception.HeartShareAccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class HeartShareValidator {

  public void ownership(HeartShare heartShare, Long userId) {
    if (!heartShare.getUser().getId().equals(userId)) throw new HeartShareAccessDeniedException();
  }
}
