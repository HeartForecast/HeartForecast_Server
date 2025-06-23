package com.heartforecast.domain.emotionType.service;

import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.emotionType.service.implementation.EmotionTypeReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryEmotionTypeService {

  private final EmotionTypeReader emotionTypeReader;

  public EmotionType readOne(Long id) {
    return emotionTypeReader.findById(id);
  }
}
