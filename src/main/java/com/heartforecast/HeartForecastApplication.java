package com.heartforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HeartForecastApplication {

  public static void main(String[] args) {
    SpringApplication.run(HeartForecastApplication.class, args);
  }

}

