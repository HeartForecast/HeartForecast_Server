package com.heartforecast.domain.forecastRecord.domain;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.emotionType.domain.EmotionType;
import com.heartforecast.domain.forecast.domain.Forecast;
import com.heartforecast.domain.forecastRecord.domain.value.TimeZone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class ForecastRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  private Forecast forecast;

  @ManyToOne(fetch = FetchType.LAZY)
  private Child child;

  @ManyToOne(fetch = FetchType.LAZY)
  private EmotionType emotionType;

  @NotNull
  private LocalDate date;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TimeZone timeZone;

  private String memo;

  @CreatedDate
  private LocalDateTime createdAt;

  @Builder
  public ForecastRecord(Forecast forecast, Child child, EmotionType emotionType, LocalDate date, TimeZone timeZone, String memo) {
    this.forecast = forecast;
    this.child = child;
    this.emotionType = emotionType;
    this.date = date;
    this.timeZone = timeZone;
    this.memo = memo;
  }

  public void update(EmotionType emotionType, String memo) {
    this.emotionType = emotionType;
    this.memo = memo;
  }
}
