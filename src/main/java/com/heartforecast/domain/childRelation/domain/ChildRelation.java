package com.heartforecast.domain.childRelation.domain;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.user.domain.Users;
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
public class ChildRelation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Users user;

  @ManyToOne(fetch = FetchType.LAZY)
  private Child child;

  @NotNull
  private String role;

  @CreatedDate
  private LocalDateTime createdAt;

  @Builder
  public ChildRelation(Users user, Child child, String role) {
    this.user = user;
    this.child = child;
    this.role = role;
  }

  public void updateRole(String role) {
    this.role = role;
  }
}
