package com.heartforecast.domain.emotionType.service.implementation;

import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.emotionType.domain.repository.EmotionTypeRepository;
import com.heartforecast.domain.emotionType.exception.EmotionTypeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmotionTypeReader {

  private final EmotionTypeRepository emotionTypeRepository;

  public EmotionType findById(Long id) {
    return emotionTypeRepository.findById(id)
        .orElseThrow(EmotionTypeNotFoundException::new);
  }
}
