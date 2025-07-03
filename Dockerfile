# =======================
# 1단계: 빌드용 이미지
# =======================
FROM gradle:8.4-jdk17-alpine AS builder

# 캐싱 최적화용 라이브러리 디렉토리 미리 생성
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradle gradle
RUN gradle dependencies --no-daemon || return 0

# 나머지 전체 복사 및 빌드
COPY . .
RUN gradle clean bootJar --no-daemon

# =======================
# 2단계: 실행용 이미지
# =======================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 필수 설정 (시간대 및 Spring profile)
ENV TZ=Asia/Seoul
ENV SPRING_PROFILES_ACTIVE=prod

# Alpine에서 시간대 정상화
RUN apk add --no-cache tzdata

# 빌드된 JAR 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트 개방
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
