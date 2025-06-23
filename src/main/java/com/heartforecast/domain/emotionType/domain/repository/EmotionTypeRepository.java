package com.heartforecast.domain.emotionType.domain.repository;

import com.heartforecast.domain.emotionType.domain.EmotionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionTypeRepository extends JpaRepository<EmotionType, Long> {
}
