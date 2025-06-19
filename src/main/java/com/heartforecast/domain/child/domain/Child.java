package com.heartforecast.domain.child.domain;

import com.heartforecast.domain.child.domain.value.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Child {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private LocalDate birthdate;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  private String healthInfo;

  private Integer point;

  @Column(unique = true)
  private String inviteCode;

  @CreatedDate
  private LocalDateTime createdAt;


  @Builder
  public Child(String username, LocalDate birthdate, Gender gender, String healthInfo, String inviteCode) {
    this.username = username;
    this.birthdate = birthdate;
    this.gender = gender;
    this.healthInfo = healthInfo;
    this.point = 0;
    this.inviteCode = inviteCode;
  }

  public void updateHealthInfo(String healthInfo) {
    this.healthInfo = healthInfo;
  }
}
