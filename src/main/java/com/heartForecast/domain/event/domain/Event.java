package com.heartForecast.domain.event.domain;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.user.domain.Users;
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
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Users user;

  @ManyToOne(fetch = FetchType.LAZY)
  private Child child;

  @NotNull
  private LocalDate date;

  @NotNull
  private String title;

  @NotNull
  private String description;

  @CreatedDate
  private LocalDateTime createdAt;

  @Builder
  public Event(Users user, Child child, LocalDate date, String title, String description) {
    this.user = user;
    this.child = child;
    this.date = date;
    this.title = title;
    this.description = description;
  }

  public void update(LocalDate date, String title, String description) {
    this.date = date;
    this.title = title;
    this.description = description;
  }
}
