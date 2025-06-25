package com.heartforecast.domain.heartShare.domain.repository;

import com.heartforecast.domain.heartShare.domain.HeartShare;
import com.heartforecast.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartShareRepository extends JpaRepository<HeartShare, Long> {
  List<HeartShare> findAllByUser(Users user);
}
