package com.heartForecast.domain.emotionType.domain.repository;

import com.heartForecast.domain.emotionType.domain.EmotionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionTypeRepository extends JpaRepository<EmotionType, Long> {
}
