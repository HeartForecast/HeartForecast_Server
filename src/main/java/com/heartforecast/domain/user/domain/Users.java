package com.heartforecast.domain.user.domain;

import com.heartforecast.domain.user.domain.value.Role;
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
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String email;

  private String password;

  @NotNull
  private String username;

  @NotNull
  private String type;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Role role;

  @CreatedDate
  private LocalDateTime createdAt;

  @Builder(builderMethodName = "normalUserBuilder")
  public Users(String username, String password, String email, String type, Role role) {
    this.username = username;
    this.role = role;
    this.type = type;
    this.email = email;
    this.password = password;
  }

  @Builder(builderMethodName = "socialUserBuilder")
  public Users(String email, String username, Role role, String type) {
    this.email = email;
    this.username = username;
    this.role = role;
    this.type = type;
  }

  @Builder(builderMethodName = "jwtUserBuilder")
  public Users(String email, String password, Role role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public void updateSocial(String email, String type) {
    this.email = email;
    this.type = type;
  }

  public void updateRole(Role role) {
    this.role = role;
  }
}
