package com.heartforecast.domain.childRelation.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class ChildRelationFoundException extends HeartForecastException {
  public ChildRelationFoundException() {
    super(HttpStatus.NOT_FOUND, "CHILD_RELATION_NOT_FOUND","아이와의 관계를 찾을 수 없습니다.");
  }
}
