package com.heartForecast.common.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.*;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import java.util.*;

@Configuration
public class SwaggerConfig {

    @Value("${server.url}")
    private String serverUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .servers(Collections.singletonList(new Server().url(serverUrl).description("API Server")))
            .info(new Info()
                .title("HeartForecast")
                .description("이 API는 자체 로그인과 소셜 로그인(구글, 네이버, 카카오)을 지원합니다. "
                    + "엑세스 토큰과 리프레시 토큰은 HttpOnly 쿠키로 반환됩니다.\n\n"
                    + "### 소셜 로그인 API 엔드포인트:\n"
                    + "- 카카오 로그인: `/oauth2/authorization/kakao`\n"
                    + "- 네이버 로그인: `/oauth2/authorization/naver`\n"
                    + "- 구글 로그인: `/oauth2/authorization/google`\n\n"
                    + "### 상태 코드 및 오류 메시지 형식:\n"
                    + "| 상태 코드 | 오류 코드 | 설명 |\n"
                    + "| --- | --- | --- |\n"
                    + "| 400 | INVALID_ARGUMENT | 잘못된 값이 들어왔습니다. |\n"
                    + "| 400 | TYPE_MISMATCH | 파라미터 타입이 일치하지 않습니다. |\n"
                    + "| 400 | NULL_VALUE | 필수 값이 누락되었습니다. |\n"
                    + "| 400 | INVALID_CREDENTIALS | 잘못된 이메일 또는 비밀번호입니다. |\n"
                    + "| 401 | DUPLICATE_LOGIN | 이미 로그인한 상태입니다. |\n"
                    + "| 401 | EXPIRED_REFRESH_TOKEN | 재로그인 해야 합니다. |\n"
                    + "| 401 | EXPIRED_TOKEN | 만료된 토큰입니다. |\n"
                    + "| 401 | INVALID_TOKEN | 잘못된 토큰입니다. |\n"
                    + "| 401 | REFRESH_TOKEN_NOT_FOUND | 리프레시 토큰이 존재하지 않습니다. |\n"
                    + "| 401 | UNAUTHENTICATED_ACCESS | 인증이 필요합니다. |\n"
                    + "| 401 | SECURITY_UNKNOWN | 시큐리티에서 알 수 없는 에러가 발생했습니다. |\n"
                    + "| 403 | ACCESS_DENIED | 권한이 필요합니다. |\n"
                    + "| 403 | HEART_SHARE_ACCESS_DENIED | 해당 마음공유에 접근 권한이 없습니다. |\n"
                    + "| 403 | FORECAST_RECORD_UPDATE_TIME_EXPIRED | 예보 기록은 생성 후 24시간 이내에만 수정할 수 있습니다. |\n"
//                    + "| 403 | SPECIAL_FORECAST_RECORD_UPDATE_TIME_EXPIRED | 특보 기록은 생성 후 24시간 이내에만 수정할 수 있습니다. |\n"
                    + "| 404 | CHILD_NOT_FOUND | 아이를 찾을 수 없습니다. |\n"
                    + "| 404 | CHILD_RELATION_NOT_FOUND | 아이와의 관계를 찾을 수 없습니다. |\n"
                    + "| 404 | EMOTION_TYPE_NOT_FOUND | 감정 종류를 찾을 수 없습니다. |\n"
//                    + "| 404 | EVENT_NOT_FOUND | 이벤트를 찾을 수 없습니다. |\n"
                    + "| 404 | FORECAST_NOT_FOUND | 예보를 찾을 수 없습니다. |\n"
                    + "| 404 | FORECAST_RECORD_NOT_FOUND | 예보 기록을 찾을 수 없습니다. |\n"
                    + "| 404 | HEART_SHARE_NOT_FOUND | 마음공유를 찾을 수 없습니다. |\n"
//                    + "| 404 | SPECIAL_FORECAST_NOT_FOUND | 특보를 찾을 수 없습니다. |\n"
//                    + "| 404 | SPECIAL_FORECAST_RECORD_NOT_FOUND | 특보 기록을 찾을 수 없습니다. |\n"
                    + "| 404 | USER_NOT_FOUND | 유저를 찾을 수 없습니다. |\n"
                    + "| 409 | DUPLICATED_CHILD_RELATION | 이미 존재하는 돌봄관계입니다. |\n"
                    + "| 409 | FORECAST_ALREADY_EXISTS | 해당 날짜·시간대 예보가 이미 존재합니다. |\n"
                    + "| 409 | FORECAST_RECORD_ALREADY_EXISTS | 해당 예보로 생성된 예보 기록이 이미 존재합니다. |\n"
                    + "| 409 | FORECAST_RECORD_INVALID_DATE_TIME | 예보 기록은 원래 예보의 날짜와 시간대가 동일해야 합니다. |\n"
//                    + "| 409 | SPECIAL_FORECAST_ALREADY_EXISTS | 해당 이벤트로 생성된 특보가 이미 존재합니다. |\n"
//                    + "| 409 | SPECIAL_FORECAST_RECORD_ALREADY_EXISTS | 해당 특보로 생성된 특보 기록이 이미 존재합니다. |\n"
                    + "| 409 | USER_EXISTED | 유저가 이미 존재합니다. |\n"
                    + "| 500 | SERVER_UNKNOWN | 서버에서 알 수 없는 에러가 발생했습니다. |\n"
                    + "### 오류 메시지 예시:\n"
                    + "```json\n"
                    + "{\n"
                    + "  \"status\": 401,\n"
                    + "  \"errorCode\": \"UNAUTHENTICATED_ACCESS\",\n"
                    + "  \"message\": \"인증이 필요합니다.\",\n"
                    + "  \"timestamp\": \"2024-09-29T10:00:00\"\n"
                    + "}\n"
                    + "```"))
            .addSecurityItem(new SecurityRequirement().addList("jwtAuth"))
            .components(new Components()
                .addSecuritySchemes("jwtAuth", new SecurityScheme()
                    .name("JWT Authentication")
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .description("엑세스 토큰과 리프레시 토큰은 HttpOnly 쿠키로 설정됩니다. "
                        + "API 호출 시 클라이언트는 쿠키로 인증이 진행됩니다.")));
    }
}
