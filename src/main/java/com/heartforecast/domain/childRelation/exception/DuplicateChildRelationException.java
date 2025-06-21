package com.heartforecast.domain.childRelation.exception;

import com.heartforecast.common.exception.HeartForecastException;
import org.springframework.http.HttpStatus;

public class DuplicateChildRelationException extends HeartForecastException {
  public DuplicateChildRelationException() {
    super(HttpStatus.CONFLICT, "DUPLICATED_CHILD_RELATION", "이미 존재하는 돌봄관계입니다.");
  }
}
