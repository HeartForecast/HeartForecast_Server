package com.heartforecast.domain.SpecialForecastRecord.domain;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.specialForecast.domain.SpecialForecast;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class SpecialForecastRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  private SpecialForecast specialForecast;

  @ManyToOne(fetch = FetchType.LAZY)
  private Child child;

  @ManyToOne(fetch = FetchType.LAZY)
  private EmotionType emotionType;

  @NotNull
  private String memo;

  @CreatedDate
  private LocalDateTime createdAt;

  @Builder
  public SpecialForecastRecord(SpecialForecast specialForecast, Child child, EmotionType emotionType, String memo) {
    this.specialForecast = specialForecast;
    this.child = child;
    this.emotionType = emotionType;
    this.memo = memo;
  }

  public void update(EmotionType emotionType, String memo) {
    this.emotionType = emotionType;
    this.memo = memo;
  }
}
