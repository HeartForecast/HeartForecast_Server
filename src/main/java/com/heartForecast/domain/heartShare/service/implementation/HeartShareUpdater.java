package com.heartForecast.domain.heartShare.service.implementation;

import com.heartForecast.domain.heartShare.domain.HeartShare;
import org.springframework.stereotype.Service;

@Service
public class HeartShareUpdater {

  public void update(HeartShare heartShare, String title, String content) {
    heartShare.update(title, content);
  }
}
