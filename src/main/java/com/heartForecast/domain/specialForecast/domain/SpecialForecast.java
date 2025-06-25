package com.heartForecast.domain.specialForecast.domain;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.emotionType.domain.EmotionType;
import com.heartForecast.domain.event.domain.Event;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
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

  @NotNull
  private LocalDate date;

  private String memo;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @Builder
  public SpecialForecast(Event event, Child child, EmotionType emotionType, LocalDate date, String memo) {
    this.event = event;
    this.child = child;
    this.emotionType = emotionType;
    this.date = date;
    this.memo = memo;
  }

  public void update(EmotionType emotionType, String memo) {
    this.emotionType = emotionType;
    this.memo = memo;
  }
}
