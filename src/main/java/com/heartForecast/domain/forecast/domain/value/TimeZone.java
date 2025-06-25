package com.heartForecast.domain.forecast.domain.value;

import lombok.Getter;

@Getter
public enum TimeZone {
  아침(1), 점심(2), 저녁(3);

  private final int order;

  TimeZone(int order) {
    this.order = order;
  }
}

