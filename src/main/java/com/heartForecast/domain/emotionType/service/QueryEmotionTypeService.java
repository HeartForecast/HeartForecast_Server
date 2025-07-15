package com.heartForecast.domain.emotionType.service;

import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.emotionType.service.implementation.EmotionTypeReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryEmotionTypeService {

  private final EmotionTypeReader emotionTypeReader;

  public EmotionType readOne(Long id) {
    return emotionTypeReader.findById(id);
  }

  public List<EmotionType> readAll() {
    return emotionTypeReader.findAll();
  }
}
