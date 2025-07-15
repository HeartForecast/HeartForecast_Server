package com.heartForecast.domain.emotionType.service.implementation;

import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.emotionType.domain.repository.EmotionTypeRepository;
import com.heartForecast.domain.emotionType.exception.EmotionTypeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmotionTypeReader {

  private final EmotionTypeRepository emotionTypeRepository;

  public EmotionType findById(Long id) {
    return emotionTypeRepository.findById(id)
        .orElseThrow(EmotionTypeNotFoundException::new);
  }

  public List<EmotionType> findAll() {
    return emotionTypeRepository.findAll();
  }
}
