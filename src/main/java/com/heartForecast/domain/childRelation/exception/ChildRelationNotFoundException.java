package com.heartForecast.domain.childRelation.exception;

import com.heartForecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ChildRelationNotFoundException extends HeartForecastException {
  public ChildRelationNotFoundException() {
    super(HttpStatus.NOT_FOUND, "CHILD_RELATION_NOT_FOUND","아이와의 관계를 찾을 수 없습니다.");
  }
}
