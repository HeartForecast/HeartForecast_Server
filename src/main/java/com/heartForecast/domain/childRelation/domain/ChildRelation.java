package com.heartForecast.domain.childRelation.domain;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.user.domain.Users;
import jakarta.persistence.*;
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
public class ChildRelation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Users user;

  @ManyToOne(fetch = FetchType.LAZY)
  private Child child;

  @CreatedDate
  private LocalDateTime createdAt;

  @Builder
  public ChildRelation(Users user, Child child) {
    this.user = user;
    this.child = child;
  }
}
