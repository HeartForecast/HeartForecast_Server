package com.heartForecast.common.logging;

import com.heartForecast.common.exception.HeartForecastException;
import com.heartForecast.common.exception.security.HeartForecastSecurityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
public class LoggingUtils {
    public static void warn(HeartForecastException exception) {
        String message = getExceptionMessage(exception.getMessage());
      log.warn("{}\n \t {}", message, exception);
    }

    public static void warn(HeartForecastSecurityException exception) {
        String message = getExceptionMessage(exception.getMessage());
      log.warn("{}\n \t {}", message, exception);
    }

    public static void warn(MethodArgumentTypeMismatchException exception) {
        String message = getExceptionMessage(exception.getMessage());
      log.warn("{}\n \t {}", message, exception);
    }

    public static void warn(IllegalArgumentException exception) {
        String message = getExceptionMessage(exception.getMessage());
      log.warn("{}\n \t {}", message, exception);
    }

    public static void warn(NullPointerException exception) {
        String message = getExceptionMessage(exception.getMessage());
      log.warn("{}\n \t {}", message, exception);
    }

    private static String getExceptionMessage(String message) {
        if (message == null || message.isBlank()) {
            return "";
        }
        return message;
    }

    public static void error(RuntimeException exception) {
        String message = getExceptionMessage(exception.getMessage());
      log.error("{}\n \t {}", message, exception);
    }
}