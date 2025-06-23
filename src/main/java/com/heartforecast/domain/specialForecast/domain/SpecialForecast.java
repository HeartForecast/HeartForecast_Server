package com.heartforecast.domain.specialForecast.domain;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.event.domain.Event;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class SpecialForecast {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  private Event event;

  @ManyToOne(fetch = FetchType.LAZY)
  private Child child;

  @ManyToOne(fetch = FetchType.LAZY)
  private EmotionType emotionType;

  private String memo;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @Builder
  public SpecialForecast(Event event, Child child, EmotionType emotionType, String memo) {
    this.event = event;
    this.child = child;
    this.emotionType = emotionType;
    this.memo = memo;
  }

  public void update(EmotionType emotionType, String memo) {
    this.emotionType = emotionType;
    this.memo = memo;
  }
}
